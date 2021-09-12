package cn.edu.uibe.domain;

import java.util.Date;

public class Submit {
    private Long submitid;

	private Long collectid;

	private String details;

	private Integer col;

	private Integer row;

	private Date finishedtime;

	private String submitter;

	public Long getSubmitid() {
		return submitid;
	}

	public void setSubmitid(Long submitid) {
		this.submitid = submitid;
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

	public Date getFinishedtime() {
		return finishedtime;
	}

	public void setFinishedtime(Date finishedtime) {
		this.finishedtime = finishedtime;
	}

	public String getSubmitter() {
		return submitter;
	}

	public void setSubmitter(String submitter) {
		this.submitter = submitter == null ? null : submitter.trim();
	}
}