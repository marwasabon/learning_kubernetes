package com.zain.shortcode.services;

import java.util.List;

import com.zain.shortcode.models.RoutingMSISDNs;

/**
 * @author m.sabon
 *
 */
public interface RoutingMSISDNsService {
	/**
	 * get_RoutingMSISDNs_ById
	 * 
	 * @param id
	 * @return
	 */
	public RoutingMSISDNs get_RoutingMSISDNs_ById(Long id);

	/**
	 * get_All_RoutingMSISDNs
	 * 
	 * @return
	 */
	public List<RoutingMSISDNs> get_All_RoutingMSISDNs();

	/**
	 * add_RoutingMSISDNs
	 * 
	 * @param RoutingMSISDNs
	 * @param shorcodeID
	 * @return
	 * @throws Exception
	 */
	public RoutingMSISDNs add_RoutingMSISDNs(RoutingMSISDNs RoutingMSISDNs, Long shorcodeID) throws Exception;

	/**
	 * update_RoutingMSISDNs
	 * 
	 * @param newRoutingMSISDNs
	 * @param oringal
	 * @param shorcodeID
	 */
	public void update_RoutingMSISDNs(RoutingMSISDNs newRoutingMSISDNs, RoutingMSISDNs oringal, Long shorcodeID);

	/**
	 * delete_RoutingMSISDNs_ById
	 * 
	 * @param id
	 */
	public void delete_RoutingMSISDNs_ById(Long id);

}
