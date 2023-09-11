package com.zain.shortcode.repository;

import java.util.Optional;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.zain.shortcode.models.Status;

/**
 * @author m.sabon
 *
 */
public interface StatusRepository extends DataTablesRepository<Status, Long> {
	/**
	 * findBystatusName
	 * 
	 * @param Name
	 * @return
	 */
	Optional<Status> findBystatusName(String Name);

}
