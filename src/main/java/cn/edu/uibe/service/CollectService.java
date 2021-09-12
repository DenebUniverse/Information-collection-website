package cn.edu.uibe.service;

import java.util.List;

import cn.edu.uibe.domain.Collect;
import cn.edu.uibe.domain.Forbid;
import cn.edu.uibe.domain.Submit;
import cn.edu.uibe.myClass.MyTable;



public interface CollectService {
	
	Collect selectCollectById(String id);
	
	Collect selectCollectByCollecter(String name);
	
	Submit selectSubmitBySubmitId(String id);
	
	Submit selectSubmitBySubmitter(String name);
	
	List<Collect> getAllInfo();
	
	List<Submit> getSubmitByCollectID(String id);
	
	String check_collect_insert(String colLen, String rowLen, String colList,String rowList,String ddl);
	
	boolean add_collect(String collectName,String details,String colLen,String rowLen,String colList,String rowList,String ddl,String collecter,String uniqueflag,String forbidflag);
	
	boolean add_submit(String collectid,String details,String col,String row,String submitter);
	
	MyTable<Integer> SumCollectById(String id);
	
	List<Forbid> getForbidByCollectID(String collectid);

	MyTable<String> SumForbidByCollectId(String collectid);
	
	boolean add_forbid(String collectid,String details,String col,String row);
	
	boolean delete_submit(String submitid);
	
	boolean delete_forbid(String forbidid);
	
	boolean delect_collect(String collectid);

}
