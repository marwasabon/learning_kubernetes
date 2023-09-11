package com.zain.shortcode.models;
/**
 * 
 * @author m.sabon
 *
 */
public class FilterOptions {
  private String filterBy;
  
  private String filterby;
  
  public String getFilterby() {
	return filterby;
}

public void setFilterby(String filterby) {
	this.filterby = filterby;
}

private String fromDate;
  
  private String toDate;
  
  public String getFilterBy() {
    return this.filterBy;
  }
  
  public void setFilterBy(String filterBy) {
	  this.filterBy = filterBy.isEmpty() ? null: filterBy;
  }
  
 
  
  public String getFromDate() {
    return this.fromDate;
  }
  
  public void setFromDate(String year) {

	  this.fromDate =  year;
  }
  
  public String getToDate() {
    return this.toDate;
  }
  
  public void setToDate(String quarter) {
    this.toDate = quarter;
  }
}
