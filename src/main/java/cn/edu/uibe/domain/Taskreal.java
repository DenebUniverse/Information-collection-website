package cn.edu.uibe.domain;

public class Taskreal {
    private Long taskid;

    private Long projectid;

    private String details;

    private String taskname;

    private Integer tasknumber;

    private Integer startedtime;

    private Integer period;

    private Float quota;

    private Float cost;

    private String submitter;

    public Long getTaskid() {
        return taskid;
    }

    public void setTaskid(Long taskid) {
        this.taskid = taskid;
    }

    public Long getProjectid() {
        return projectid;
    }

    public void setProjectid(Long projectid) {
        this.projectid = projectid;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname == null ? null : taskname.trim();
    }

    public Integer getTasknumber() {
        return tasknumber;
    }

    public void setTasknumber(Integer tasknumber) {
        this.tasknumber = tasknumber;
    }

    public Integer getStartedtime() {
        return startedtime;
    }

    public void setStartedtime(Integer startedtime) {
        this.startedtime = startedtime;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Float getQuota() {
        return quota;
    }

    public void setQuota(Float quota) {
        this.quota = quota;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter == null ? null : submitter.trim();
    }
}