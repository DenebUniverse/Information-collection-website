package cn.edu.uibe.domain;

import java.util.Date;

public class Project {
    private Long projectid;

    private String projectname;

    private String details;

    private Integer collen;

    private Integer rowlen;

    private String collist;

    private String rowlist;

    private Date createdtime;

    private Date ddl;

    private String manager;

    public Long getProjectid() {
        return projectid;
    }

    public void setProjectid(Long projectid) {
        this.projectid = projectid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname == null ? null : projectname.trim();
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

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }
}