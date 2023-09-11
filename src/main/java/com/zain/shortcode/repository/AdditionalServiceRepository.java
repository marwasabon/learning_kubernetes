package com.zain.shortcode.repository;

import java.util.Optional;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.zain.shortcode.models.AdditionalService;
/**
 * 
 * @author m.sabon
 *
 */
public interface AdditionalServiceRepository extends DataTablesRepository<AdditionalService, Long> {
Optional <AdditionalService> findByaserviceName (String name);
}
