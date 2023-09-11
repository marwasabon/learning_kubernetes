package com.zain.shortcode.services;

import java.util.List;

import com.zain.shortcode.models.Users;

/**
 * @author m.sabon
 *
 */
public interface UserService {
	/**
	 * get_User_ById
	 * 
	 * @param id
	 * @return
	 */
	public Users get_User_ById(Long id);

	/**
	 * get_All_Users
	 * 
	 * @return
	 */
	public List<Users> get_All_Users();

	/**
	 * add_User
	 * 
	 * @param user
	 * @return
	 */
	public Users add_User(Users user);

	/**
	 * update_User
	 * 
	 * @param user
	 * @param id
	 * @return
	 */
	Users update_User(Users user, Long id);

	/**
	 * delete_User
	 * 
	 * @param user
	 * @return
	 */
	public Boolean delete_User(Users user);

	/**
	 * get_User_By_UserName
	 * 
	 * @param user_name
	 * @return
	 */
	public Users get_User_By_UserName(String user_name);

	/**
	 * isRoleChangeForLoggedInUser
	 * @param user
	 * @return
	 */
	public boolean isRoleChangeForLoggedInUser(Users user);

 

}
