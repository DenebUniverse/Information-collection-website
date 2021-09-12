package cn.edu.uibe.domain;

public class Forbid {
    private Long forbidid;

    private Long collectid;

    private String details;

    private Integer col;

    private Integer row;

    public Long getForbidid() {
        return forbidid;
    }

    public void setForbidid(Long forbidid) {
        this.forbidid = forbidid;
    }

    public Long getCollectid() {
        return collectid;
    }

    public void setCollectid(Long collectid) {
        this.collectid = collectid;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }
}