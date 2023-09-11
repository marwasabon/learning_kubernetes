package com.zain.shortcode.services;

import java.util.List;

import com.zain.shortcode.models.Classes;

/**
 * @author MJ
 *
 */
public interface ClassService {
	/**
	 * get_Class_ById
	 * 
	 * @param id
	 * @return
	 */
	public Classes get_Class_ById(Long id);

	/**
	 * get_All_Classes
	 * 
	 * @return
	 */
	public List<Classes> get_All_Classes();

	/**
	 * add_class
	 * 
	 * @param classe
	 * @return
	 * @throws Exception
	 */
	public Classes add_class(Classes classe) throws Exception;

	/**
	 * update_class
	 * 
	 * @param classe
	 * @return
	 */
	public Classes update_class(Classes classe);

	/**
	 * delete_Class_ById
	 * 
	 * @param id
	 */
	public void delete_Class_ById(Long id);

}
