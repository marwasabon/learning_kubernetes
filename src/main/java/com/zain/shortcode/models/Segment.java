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
@Table(name = "segment")
public class Segment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(DataTablesOutput.View.class)
	private Long segmentID;

	@JsonView(DataTablesOutput.View.class)
	private String segmentName;

	

	public Long getSegmentID() {
		return segmentID;
	}

	public void setSegmentID(Long segmentID) {
		this.segmentID = segmentID;
	}

	public String getSegmentName() {
		return segmentName;
	}

	public void setSegmentName(String segmentName) {
		this.segmentName = segmentName;
	}

	@Override
	public String toString() {
		return "Segment [SegmentID=" + segmentID + ", SegmentName=" + segmentName + "]";
	}
}
