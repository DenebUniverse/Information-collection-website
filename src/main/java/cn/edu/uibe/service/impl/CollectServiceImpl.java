package cn.edu.uibe.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.uibe.dao.CollectMapper;
import cn.edu.uibe.dao.ForbidMapper;
import cn.edu.uibe.dao.SubmitMapper;
import cn.edu.uibe.domain.Collect;
import cn.edu.uibe.domain.Forbid;
import cn.edu.uibe.domain.Submit;
import cn.edu.uibe.myClass.MyTable;
import cn.edu.uibe.service.CollectService;



@Service
@Transactional
public class CollectServiceImpl implements CollectService{
	
	@Autowired
	CollectMapper collectMapper;

	@Autowired
	SubmitMapper submitMapper;
	
	@Autowired
	ForbidMapper forbidMapper;
	

	@Override
	public Collect selectCollectById(String id) {
		long cid = Long.parseLong(StringUtils.trimToEmpty(id));
		Collect collect=collectMapper.selectByPrimaryKey(cid);
		return collect;
	}

	@Override
	public Collect selectCollectByCollecter(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Submit selectSubmitBySubmitId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Submit selectSubmitBySubmitter(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Collect> getAllInfo() {
		List<Collect> collectList=collectMapper.getAllCollect();
		return collectList;
	}
	
	@Override
	public String check_collect_insert(String colLen, String rowLen, String colList,String rowList,String ddl) {
		String message ="";
		int col_int= Integer. parseInt(StringUtils.trimToEmpty(colLen));
		int row_int= Integer. parseInt(StringUtils.trimToEmpty(rowLen));	
		String[] ColList2=colList.split(",");
		int col_int2=ColList2.length;
		String[] RowList2=rowList.split(",");
		int row_int2=RowList2.length;
		if(col_int2!=col_int||row_int2!=row_int) {
			message=message+"行列名称与行列数不符";
		}
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date=formatter.parse(ddl);
		} catch (ParseException e) {
			message=message+"日期格式错误";
			return message;
		}
		return message;
	}
	
	@Override
	@Transactional
	public boolean add_collect(String collectName, String details, String colLen, String rowLen, String colList,
			String rowList, String ddl, String collecter,String uniqueflag,String forbidflag) {
		int col_int= Integer. parseInt(StringUtils.trimToEmpty(colLen));
		int row_int= Integer. parseInt(StringUtils.trimToEmpty(rowLen));
		Collect collect=new Collect();
		collect.setCollectname(collectName);
		collect.setDetails(details);
		collect.setCollen(col_int);
		collect.setRowlen(row_int);
		collect.setCollist(colList);
		collect.setRowlist(rowList);
		collect.setCreatedtime(new Date());
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			collect.setDdl(formatter.parse(ddl));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		collect.setCollecter(collecter);
		collect.setUniqueflag(uniqueflag.equals("1"));
		collect.setForbidflag(forbidflag.equals("1"));

	    int count = collectMapper.insert(collect);
	    return count==1;//true表示成功
	}
	
	@Override
	@Transactional
	public boolean delect_collect(String collectid) {
		List<Submit> submitList=getSubmitByCollectID(collectid);
		List<Forbid> forbidList=getForbidByCollectID(collectid);
		for (Submit temp : submitList) {
			submitMapper.deleteByPrimaryKey(temp.getSubmitid());
        }
		for (Forbid temp : forbidList) {
            forbidMapper.deleteByPrimaryKey(temp.getForbidid());
        }
		long cid = Long.parseLong(StringUtils.trimToEmpty(collectid));
	    int count = collectMapper.deleteByPrimaryKey(cid);
	    return count==1;//true表示成功
	}
	
	@Override
	public List<Submit> getSubmitByCollectID(String id){
		long cid = Long.parseLong(StringUtils.trimToEmpty(id));
		List<Submit> submitList =submitMapper.selectBycollectId(cid);	
		return submitList;
	}
	

	
	@Override
	@Transactional
	public boolean add_submit(String collectid, String details, String col, String row, String submitter) {
		long cid = Long.parseLong(StringUtils.trimToEmpty(collectid));
		int col_int= Integer. parseInt(StringUtils.trimToEmpty(col));
		int row_int= Integer. parseInt(StringUtils.trimToEmpty(row));
		Submit submit=new Submit();
		submit.setCollectid(cid);
		submit.setDetails(details);
		submit.setCol(col_int);
		submit.setRow(row_int);
		submit.setFinishedtime(new Date());
		submit.setSubmitter(submitter);

	    int count = submitMapper.insert(submit);
	    return count==1;
	}

	@Override
	public MyTable<Integer> SumCollectById(String id) {
		List<Submit> submitList =getSubmitByCollectID(id);
		Collect collect=selectCollectById(id);
		
		MyTable<Integer> mytable = new MyTable<Integer>();
		mytable.setTableName(collect.getCollectname());
		String ColName=collect.getCollist();
		String[] ColList=ColName.split(",");
		String RowName=collect.getRowlist();
		String[] RowList=RowName.split(",");
		mytable.setColNames(ColList);
		mytable.setRowNames(RowList);
		int ColLen=ColList.length;
		int RowLen=RowList.length;	
		mytable.setColLen(ColLen);
		mytable.setRowLen(RowLen);
		Integer[][] matrix= new Integer[RowLen][ColLen];
		
		for (Integer[] row: matrix)
		    Arrays.fill(row, 0);
		
		for(Submit submit : submitList)
		{  
			matrix[submit.getRow()-1][submit.getCol()-1]+=1;
		}

		mytable.setMatrix(matrix);
		return mytable;
	}

	
	@Override
	@Transactional
	public boolean delete_submit(String submitid) {
		long sid = Long.parseLong(StringUtils.trimToEmpty(submitid));
	    int count = submitMapper.deleteByPrimaryKey(sid);
	    return count==1;//true表示成功
	}

	
	@Override
	public List<Forbid> getForbidByCollectID(String collectid) {
		long cid = Long.parseLong(StringUtils.trimToEmpty(collectid));
		List<Forbid> forbidList =forbidMapper.selectBycollectId(cid);	
		return forbidList;
	}

	@Override
	public MyTable<String> SumForbidByCollectId(String collectid) {
		List<Forbid> forbidList =getForbidByCollectID(collectid);
		Collect collect=selectCollectById(collectid);
		
		MyTable<String> mytable = new MyTable<String>();
		mytable.setTableName(collect.getCollectname());
		String ColName=collect.getCollist();
		String[] ColList=ColName.split(",");
		String RowName=collect.getRowlist();
		String[] RowList=RowName.split(",");
		mytable.setColNames(ColList);
		mytable.setRowNames(RowList);
		int ColLen=ColList.length;
		int RowLen=RowList.length;	
		mytable.setColLen(ColLen);
		mytable.setRowLen(RowLen);
		
		String[][] matrix= new String[RowLen][ColLen];
		
		for (String[] row: matrix)
		    Arrays.fill(row, "未禁止");
		
		for(Forbid forbid : forbidList)
		{  
			matrix[forbid.getRow()-1][forbid.getCol()-1]="已禁止";
		}
		mytable.setMatrix(matrix);
		return mytable;
	}

	@Override
	@Transactional
	public boolean add_forbid(String collectid, String details, String col, String row) {
		long cid = Long.parseLong(StringUtils.trimToEmpty(collectid));
		int col_int= Integer. parseInt(StringUtils.trimToEmpty(col));
		int row_int= Integer. parseInt(StringUtils.trimToEmpty(row));
		Forbid forbid=new Forbid();
		forbid.setCollectid(cid);
		forbid.setDetails(details);
		forbid.setCol(col_int);
		forbid.setRow(row_int);
	    int count = forbidMapper.insert(forbid);
	    return count==1;
	}

	@Override
	@Transactional
	public boolean delete_forbid(String forbidid) {
		long fid = Long.parseLong(StringUtils.trimToEmpty(forbidid));
	    int count = forbidMapper.deleteByPrimaryKey(fid);
	    return count==1;//true表示成功
	}


}
