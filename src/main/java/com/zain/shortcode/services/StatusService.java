package com.zain.shortcode.services;

import java.util.List;

import com.zain.shortcode.models.Status;

/**
 * @author m.sabon
 *
 */
public interface StatusService {
	/**
	 * get_Status_ById
	 * 
	 * @param id
	 * @return
	 */
	public Status get_Status_ById(Long id);

	/**
	 * get_All_Status
	 * 
	 * @return
	 */
	public List<Status> get_All_Status();

	/**
	 * add_Status
	 * 
	 * @param Status
	 * @return
	 * @throws Exception
	 */
	public Status add_Status(Status Status) throws Exception;

	/**
	 * update_status
	 * 
	 * @param Status
	 * @return
	 */
	public Status update_status(Status Status);

	/**
	 * delete_Status_ById
	 * 
	 * @param id
	 */
	public void delete_Status_ById(Long id);

}
