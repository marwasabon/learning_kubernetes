package com.zain.shortcode.repository;

import java.util.Optional;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.zain.shortcode.models.Classes;
/**
 * 
 * @author m.sabon
 *
 */
public interface ClassesRepository extends DataTablesRepository<Classes, Long> {

	Optional <Classes> findByclassName(String name);
}
