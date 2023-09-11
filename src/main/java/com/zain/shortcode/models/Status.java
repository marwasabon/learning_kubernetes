package com.zain.shortcode.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.fasterxml.jackson.annotation.JsonView;
/**
 * 
 * @author m.sabon
 *
 */
@Entity
@Table(name = "status")
public class Status {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(DataTablesOutput.View.class)

	private Long statusID;

	@JsonView(DataTablesOutput.View.class)
	private String statusName;

	
	public Long getStatusID() {
		return statusID;
	}


	public void setStatusID(Long statusID) {
		this.statusID = statusID;
	}


	public String getStatusName() {
		return statusName;
	}


	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}


	@Override
	public String toString() {
		return "Status [statusID=" + statusID + ", statusName=" + statusName + "]";
	}
}
