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
@Table(name = "additional_service")

public class AdditionalService {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(DataTablesOutput.View.class)

	private Long aserviceID;

	@JsonView(DataTablesOutput.View.class)
	private String aserviceName;

	
	public Long getAserviceID() {
		return aserviceID;
	}

	public void setAserviceID(Long aserviceID) {
		this.aserviceID = aserviceID;
	}

	public String getAserviceName() {
		return aserviceName;
	}

	public void setAserviceName(String aserviceName) {
		this.aserviceName = aserviceName;
	}

	@Override
	public String toString() {
		return "Aservice [AserviceID=" + aserviceID + ", AserviceName=" + aserviceName + "]";
	}
}
