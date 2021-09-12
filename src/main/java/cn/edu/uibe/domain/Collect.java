package cn.edu.uibe.domain;

import java.util.Date;

public class Collect {
    private Long collectid;

    private String collectname;

    private String details;

    private Integer collen;

    private Integer rowlen;

    private String collist;

    private String rowlist;

    private Date createdtime;

    private Date ddl;

    private String collecter;

    private Boolean uniqueflag;

    private Boolean forbidflag;

    public Long getCollectid() {
        return collectid;
    }

    public void setCollectid(Long collectid) {
        this.collectid = collectid;
    }

    public String getCollectname() {
        return collectname;
    }

    public void setCollectname(String collectname) {
        this.collectname = collectname == null ? null : collectname.trim();
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    public Integer getCollen() {
        return collen;
    }

    public void setCollen(Integer collen) {
        this.collen = collen;
    }

    public Integer getRowlen() {
        return rowlen;
    }

    public void setRowlen(Integer rowlen) {
        this.rowlen = rowlen;
    }

    public String getCollist() {
        return collist;
    }

    public void setCollist(String collist) {
        this.collist = collist == null ? null : collist.trim();
    }

    public String getRowlist() {
        return rowlist;
    }

    public void setRowlist(String rowlist) {
        this.rowlist = rowlist == null ? null : rowlist.trim();
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public Date getDdl() {
        return ddl;
    }

    public void setDdl(Date ddl) {
        this.ddl = ddl;
    }

    public String getCollecter() {
        return collecter;
    }

    public void setCollecter(String collecter) {
        this.collecter = collecter == null ? null : collecter.trim();
    }

    public Boolean getUniqueflag() {
        return uniqueflag;
    }

    public void setUniqueflag(Boolean uniqueflag) {
        this.uniqueflag = uniqueflag;
    }

    public Boolean getForbidflag() {
        return forbidflag;
    }

    public void setForbidflag(Boolean forbidflag) {
        this.forbidflag = forbidflag;
    }
}