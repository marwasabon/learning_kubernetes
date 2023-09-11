package com.zain.shortcode.models;
/**
 * 
 * @author m.sabon
 *
 */
public class Report {
	private String fromDate;
	private String toDate;

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	@Override
	public String toString() {
		return "Report [fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}

}
