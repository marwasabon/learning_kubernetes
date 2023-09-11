package com.zain.shortcode.services;

import java.util.List;

import com.zain.shortcode.models.Segment;

/**
 * @author m.sabon
 *
 */
public interface SegmentService {
	/**
	 * get_Segment_ById
	 * 
	 * @param id
	 * @return
	 */
	public Segment get_Segment_ById(Long id);

	/**
	 * get_All_Segment
	 * 
	 * @return
	 */
	public List<Segment> get_All_Segment();

	/**
	 * add_Segment
	 * 
	 * @param Segment
	 * @return
	 * @throws Exception
	 */
	public Segment add_Segment(Segment Segment) throws Exception;

	/**
	 * delete_Segment_ById
	 * 
	 * @param id
	 */
	public void delete_Segment_ById(Long id);

	/**
	 * update_Segment
	 * 
	 * @param Segment
	 * @return
	 */
	public Segment update_Segment(Segment Segment);

}
