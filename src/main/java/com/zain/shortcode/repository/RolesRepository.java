package com.zain.shortcode.repository;

import java.util.Optional;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zain.shortcode.models.Roles;
/**
 * 
 * @author m.sabon
 *
 */
public interface RolesRepository extends DataTablesRepository<Roles, Long> {
	Optional<Roles> findByname(String name);
	 @Query(value = " SELECT COUNT(*) FROM users WHERE role_id =:role_id", nativeQuery = true)
	    int countusersbyroleID(@Param("role_id") Long RoletID);
}
