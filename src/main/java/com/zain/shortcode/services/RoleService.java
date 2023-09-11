package com.zain.shortcode.services;

import java.util.List;

import com.zain.shortcode.models.Roles;

/**
 * @author m.sabon
 *
 */
public interface RoleService {
	/**
	 * get_Role_ById
	 * 
	 * @param id
	 * @return
	 */
	public Roles get_Role_ById(Long id);

	/**
	 * get_All_Roles
	 * 
	 * @return
	 */
	public List<Roles> get_All_Roles();

	/**
	 * add_role
	 * 
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public Roles add_role(Roles role) throws Exception;

	/**
	 * update_role
	 * 
	 * @param role
	 * @return
	 */
	
	public Roles update_role(Roles role);

 
	/**
	 * delete_Role_By_ID
	 * 
	 * @param id
	 */
	public void delete_Role_By_ID(Long id);
}
