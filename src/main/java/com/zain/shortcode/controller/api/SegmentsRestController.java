package com.zain.shortcode.controller.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.zain.shortcode.models.Segment;
import com.zain.shortcode.repository.SegmentRepository;

/**
 * @author m.sabon
 *
 */
@RestController
@RequestMapping(value = "/segment")

public class SegmentsRestController {

	@Autowired
	SegmentRepository SegmentRepo;

	/**
	 * getSegmentes
	 * 
	 * @param input
	 * @return
	 * @throws InterruptedException
	 */
	@JsonView(DataTablesOutput.View.class)
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public DataTablesOutput<Segment> getSegmentes(@Valid DataTablesInput input) throws InterruptedException {
		DataTablesOutput<Segment> data = SegmentRepo.findAll(input);
		System.out.println("-----data" + data);
		return data;
	}
}
