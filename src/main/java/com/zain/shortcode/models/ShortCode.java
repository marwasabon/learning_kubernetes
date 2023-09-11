package com.zain.shortcode.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
/**
 * 
 * @author m.sabon
 *
 */
@Entity
@Table(name = "shortcode")
public class ShortCode {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(DataTablesOutput.View.class)
	private Long shortcodeID;

	@JsonView(DataTablesOutput.View.class)
	private String shortcodeNO;

	@JsonView(DataTablesOutput.View.class)
	private String accountName;

	@JsonView(DataTablesOutput.View.class)
	private String customerName;

	@JsonView(DataTablesOutput.View.class)
	private String followUpNumber;

	@OneToMany(mappedBy = "shortcode", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonView(DataTablesOutput.View.class)
	@JsonIgnore
	private Set<RoutingMSISDNs> routingMSISDNs;
	@Positive
	@JsonView(DataTablesOutput.View.class)
	private String shortCodePrice;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "class_id", referencedColumnName = "classID")
	@JsonView(DataTablesOutput.View.class)
	private Classes classes;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "aservice_id", referencedColumnName = "aserviceID")
	@JsonView(DataTablesOutput.View.class)
	private AdditionalService additionalServices;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "status_id", referencedColumnName = "statusID")
	@JsonView(DataTablesOutput.View.class)
	private Status statuses;

	@JsonView(DataTablesOutput.View.class)
	private String zainRequesterAccount;

	@JsonView(DataTablesOutput.View.class)
	private String zainRequesterEmail;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "segment_id", referencedColumnName = "segmentID")
	@JsonView(DataTablesOutput.View.class)
	private Segment segments;

	@JsonView(DataTablesOutput.View.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expiryDate;

	@JsonView(DataTablesOutput.View.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date activationDate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+2:00")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date creationDate;

	@JsonView(DataTablesOutput.View.class)
	private String createdBy;

	@JsonView(DataTablesOutput.View.class)
	private String comment;

	@JsonView(DataTablesOutput.View.class)
	private String createdByRole;

	public String getCreatedByRole() {
		return createdByRole;
	}

	public void setCreatedByRole(String createdByRole) {
		this.createdByRole = createdByRole;
	}


	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getShortcodeID() {
		return shortcodeID;
	}

	public void setShortcodeID(Long shortcodeID) {
		this.shortcodeID = shortcodeID;
	}

	public String getShortcodeNO() {
		return shortcodeNO;
	}

	public void setShortcodeNO(String shortcodeNo) {
		this.shortcodeNO = shortcodeNo;
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

	public Set<RoutingMSISDNs> getRoutingMSISDNs() {
		return routingMSISDNs;
	}

	public void setRoutingMSISDNs(Set<RoutingMSISDNs> routingMSISDNs) {
		this.routingMSISDNs = routingMSISDNs;
	}

	public String getShortCodePrice() {
		return shortCodePrice;
	}

	public void setShortCodePrice(String shortCodePrice) {
		this.shortCodePrice = shortCodePrice;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public AdditionalService getAdditionalServices() {
		return additionalServices;
	}

	public void setAdditionalServices(AdditionalService additionalServices) {
		this.additionalServices = additionalServices;
	}

	public Status getStatuses() {
		return statuses;
	}

	public void setStatuses(Status statuses) {
		this.statuses = statuses;
	}

	public String getZainRequesterAccount() {
		return zainRequesterAccount;
	}

	public void setZainRequesterAccount(String zainRequesterAccout) {
		this.zainRequesterAccount = zainRequesterAccout;
	}

	public String getZainRequesterEmail() {
		return zainRequesterEmail;
	}

	public void setZainRequesterEmail(String zainRequesterEmail) {
		this.zainRequesterEmail = zainRequesterEmail;
	}

	public Segment getSegments() {
		return segments;
	}

	public void setSegments(Segment segments) {
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
