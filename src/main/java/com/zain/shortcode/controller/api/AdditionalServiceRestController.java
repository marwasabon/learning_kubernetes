package com.zain.shortcode.controller.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.zain.shortcode.models.AdditionalService;
import com.zain.shortcode.repository.AdditionalServiceRepository;

/**
 * @author m.sabon
 *
 */
@RestController
@RequestMapping(value = "/additionalservice")

public class AdditionalServiceRestController {

	@Autowired
	AdditionalServiceRepository AdditionalServieRepo;

	/**
	 * getAdditionalServicees
	 * 
	 * @param input
	 * @return
	 * @throws InterruptedException
	 */
	@JsonView(DataTablesOutput.View.class)
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public DataTablesOutput<AdditionalService> getAdditionalServicees(@Valid DataTablesInput input)
			throws InterruptedException {
		DataTablesOutput<AdditionalService> data = AdditionalServieRepo.findAll(input);
		System.out.println("-----data" + data);
		return data;
	}
}
