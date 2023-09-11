package com.zain.shortcode.repository;

import java.util.Optional;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.zain.shortcode.models.Segment;
/**
 * 
 * @author m.sabon
 *
 */
public interface SegmentRepository extends DataTablesRepository<Segment, Long> {
	Optional <Segment> findBysegmentName(String name);
}
