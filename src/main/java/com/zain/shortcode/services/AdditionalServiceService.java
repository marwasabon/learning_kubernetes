package com.zain.shortcode.services;

import java.util.List;

import com.zain.shortcode.models.AdditionalService;

/**
 * @author m.sabon
 *
 */
public interface AdditionalServiceService {
	/**
	 * get_AdditionalService_ById
	 * 
	 * @param id
	 * @return
	 */
	public AdditionalService get_AdditionalService_ById(Long id);

	/**
	 * get_All_AdditionalService
	 * 
	 * @return
	 */
	public List<AdditionalService> get_All_AdditionalService();

	/**
	 * add_AdditionalService
	 * 
	 * @param AdditionalService
	 * @return
	 * @throws Exception
	 */
	public AdditionalService add_AdditionalService(AdditionalService AdditionalService) throws Exception;

	/**
	 * update_AdditionalService
	 * 
	 * @param AdditionalService
	 * @return
	 */
	public AdditionalService update_AdditionalService(AdditionalService AdditionalService);

	/**
	 * delete_AdditionalService_ById
	 * 
	 * @param id
	 */
	public void delete_AdditionalService_ById(Long id);

}
