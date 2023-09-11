package com.zain.shortcode.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
/**
 * 
 * @author m.sabon
 *
 */
@Entity
@Table(name = "routing_MSISDNs")
public class RoutingMSISDNs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(DataTablesOutput.View.class)
	private Long routingMSISDNID;

	@JsonView(DataTablesOutput.View.class)
	private String routingMSISDN;

	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "shortcodeID", referencedColumnName = "shortcodeID")
	@JsonIgnore
	ShortCode shortcode;	


	public Long getRoutingMSISDNID() {
		return routingMSISDNID;
	}

	public ShortCode getShortcode() {
		return shortcode;
	}

	public void setShortcode(ShortCode shortcode) {
		this.shortcode = shortcode;
	}

	public void setRoutingMSISDNID(Long routingMSISDNID) {
		this.routingMSISDNID = routingMSISDNID;
	}

	public String getRoutingMSISDN() {
		return routingMSISDN;
	}

	public void setRoutingMSISDN(String routingMSISDN) {
		this.routingMSISDN = routingMSISDN;
	}

	
	

}
