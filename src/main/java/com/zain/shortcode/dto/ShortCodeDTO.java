package com.zain.shortcode.dto;

import java.util.Date;
import java.util.List;

public class ShortCodeDTO {

	private List<String> routingMSISDNs;

	private String shortcodeNo;

	private String accountName;

	private String customerName;

	private String followUpNumber;

	private String shortCodePrice;

	private List<String> classes;

	private List<String> AdditionalServices;

	private List<String> statuses;

	private String zainRequesterAccout;

	private String zainRequesterEmail;

	private List<String> segments;

	private Date activationDate;

	private Date expiryDate;

	private String comment;

	public ShortCodeDTO() {
		
	}

	
	public ShortCodeDTO(List<String> routingMSISDNs, String shortcodeNo, String accountName, String customerName,
			String followUpNumber, String shortCodePrice, List<String> classes, List<String> additionalServices,
			List<String> statuses, String zainRequesterAccout, String zainRequesterEmail, List<String> segments,
			Date activationDate, Date expiryDate, String comment) {
		super();
		this.routingMSISDNs = routingMSISDNs;
		this.shortcodeNo = shortcodeNo;
		this.accountName = accountName;
		this.customerName = customerName;
		this.followUpNumber = followUpNumber;
		this.shortCodePrice = shortCodePrice;
		this.classes = classes;
		this.AdditionalServices = additionalServices;
		this.statuses = statuses;
		this.zainRequesterAccout = zainRequesterAccout;
		this.zainRequesterEmail = zainRequesterEmail;
		this.segments = segments;
		this.activationDate = activationDate;
		this.expiryDate = expiryDate;
		this.comment = comment;
	}

	public List<String> getRoutingMSISDNs() {
		return routingMSISDNs;
	}
	
	public void setRoutingMSISDNs(List<String> routingMSISDNs) {
		this.routingMSISDNs = routingMSISDNs;
	}

	public String getShortcodeNo() {
		return shortcodeNo;
	}

	public void setShortcodeNo(String shortcodeNo) {
		this.shortcodeNo = shortcodeNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getFollowUpNumber() {
		return followUpNumber;
	}

	public void setFollowUpNumber(String followUpNumber) {
		this.followUpNumber = followUpNumber;
	}

	public String getShortCodePrice() {
		return shortCodePrice;
	}

	public void setShortCodePrice(String shortCodePrice) {
		this.shortCodePrice = shortCodePrice;
	}

	public List<String> getClasses() {
		return classes;
	}

	public void setClasses(List<String> classes) {
		this.classes = classes;
	}

	public List<String> getAdditionalServices() {
		return AdditionalServices;
	}

	public void setAdditionalServices(List<String> additionalServices) {
		AdditionalServices = additionalServices;
	}

	public List<String> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<String> statuses) {
		this.statuses = statuses;
	}

	public String getZainRequesterAccout() {
		return zainRequesterAccout;
	}

	public void setZainRequesterAccout(String zainRequesterAccout) {
		this.zainRequesterAccout = zainRequesterAccout;
	}

	public String getZainRequesterEmail() {
		return zainRequesterEmail;
	}

	public void setZainRequesterEmail(String zainRequesterEmail) {
		this.zainRequesterEmail = zainRequesterEmail;
	}

	public List<String> getSegments() {
		return segments;
	}

	public void setSegments(List<String> segments) {
		this.segments = segments;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
