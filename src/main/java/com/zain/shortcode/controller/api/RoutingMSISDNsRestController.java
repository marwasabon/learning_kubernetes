package com.zain.shortcode.controller.api;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.zain.shortcode.models.RoutingMSISDNs;
import com.zain.shortcode.repository.RoutingMSISDNsRepository;

/**
 * @author m.sabon
 *
 */
 
@RestController
@RequestMapping(value = "/api/routingMSISDNs")

public class RoutingMSISDNsRestController {

	@Autowired
	RoutingMSISDNsRepository routingMSISDNsRepo;

	/**
	 * getroutingMSISDNses
	 * 
	 * @param input
	 * @param shortcodeId
	 * @return
	 * @throws InterruptedException
	 */
	@JsonView(DataTablesOutput.View.class)
	@RequestMapping(value = "/{shortcodeId}", method = RequestMethod.GET)
	public DataTablesOutput<RoutingMSISDNs> getroutingMSISDNses(@Valid DataTablesInput input,
			@PathVariable("shortcodeId") Long shortcodeId) throws InterruptedException {

		DataTablesOutput<RoutingMSISDNs> data = routingMSISDNsRepo.findAll(input, new RoutingQuery(shortcodeId));
		System.out.println("-----data" + data);
		return data;
	}
}

/**
 * 
 * @author m.sabon & omar.
 *
 */
class RoutingQuery implements Specification<RoutingMSISDNs> {

	private static final long serialVersionUID = 1L;
	private Long shortcodeId;

	public RoutingQuery(Long shortcodeId) {
		super();
		this.shortcodeId = shortcodeId;
	}

	@Override
	public Predicate toPredicate(Root<RoutingMSISDNs> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Join<Object, Object> joinParent = root.join("shortcode");

		@SuppressWarnings("rawtypes")
		Path expression = joinParent.get("shortcodeID");

		Predicate equal = criteriaBuilder.equal(expression, this.shortcodeId);
		return equal;
	}

}
