package com.zain.shortcode.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.zain.shortcode.models.RoutingMSISDNs;
/**
 * 
 * @author m.sabon
 *
 */
public interface RoutingMSISDNsRepository extends DataTablesRepository<RoutingMSISDNs, Long> {
	Optional <RoutingMSISDNs> findByroutingMSISDN (String name);

	List<RoutingMSISDNs> findAllByroutingMSISDN(String trim);
	
}
