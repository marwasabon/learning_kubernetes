package com.zain.shortcode.controller.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.zain.shortcode.models.Status;
import com.zain.shortcode.repository.StatusRepository;

/**
 * @author m.sabon
 *
 */
@RestController
@RequestMapping(value = "/statuses")

public class StatusesRestController {

	@Autowired
	StatusRepository statusRepo;

	/**
	 * getStatuses
	 * 
	 * @param input
	 * @return
	 * @throws InterruptedException
	 */
	@JsonView(DataTablesOutput.View.class)
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public DataTablesOutput<Status> getStatuses(@Valid DataTablesInput input) throws InterruptedException {
		DataTablesOutput<Status> data = statusRepo.findAll(input);
		System.out.println("-----data" + data);
		return data;
	}
}
