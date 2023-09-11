package com.zain.shortcode.services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.zain.shortcode.models.Roles;
import com.zain.shortcode.models.Users;
import com.zain.shortcode.repository.UserRepository;
import com.zain.shortcode.services.UserService;

/**
 * @author m.sabon
 *
 */

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	RoleServiceImp roleServiceImp;

	@Override
	public Users get_User_ById(Long id) {
		System.out.println("User ID: " + id);
		return userRepository.findById(id).get();
	}

	@Override
	public List<Users> get_All_Users() {
		return (List<Users>) userRepository.findAll();
	}

	@Override
	public Users add_User(Users user) {
		try {
			Users new_user = userRepository.save(user);
			return new_user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/*
	 * @Override public Users updateUser(Users user,Long id) { // Check if the role
	 * change is for the currently logged-in user Authentication authentication =
	 * SecurityContextHolder.getContext().getAuthentication(); if (authentication !=
	 * null && authentication.isAuthenticated() && authentication.getPrincipal()
	 * instanceof UserDetails) { UserDetails userDetails = (UserDetails)
	 * authentication.getPrincipal(); String userAuthority =
	 * userDetails.getAuthorities().iterator().next().getAuthority(); String
	 * updatedRoleAuthority = user.getRole().getName(); if
	 * (user.getUserName().equals(userDetails.getUsername()) &&
	 * !userAuthority.equals(updatedRoleAuthority)) { // Perform logout actions
	 * String warningMessage = "Your role has been updated. Please log in again.";
	 * // Add the warning message as a flash attribute //
	 * redirectAttributes.addFlashAttribute("warningMessage", warningMessage);
	 * logoutUser(); } }
	 * 
	 * return userRepository.save(user); }
	 */

	public void logoutUser() {
		// Delay logout action for 5 seconds
		try {
			Thread.sleep(3000);
			System.out.println("we are waiting ...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Clear the authentication token or perform any other necessary logout actions
		SecurityContextHolder.clearContext();
	}

	@Override
	public boolean isRoleChangeForLoggedInUser(Users user) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.isAuthenticated()
				&& authentication.getPrincipal() instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String userAuthority = userDetails.getAuthorities().iterator().next().getAuthority();

			// Check if updated user matches currently logged in user
			return user.getUserName().equals(userDetails.getUsername())
					&& !user.getRole().getName().equals(userAuthority);
		}
		return false;
	}

	@Override
	public Users update_User(Users user, Long id) {
		try {
			Users usertarger = this.userRepository.findByID(id).get();

			usertarger.setEmail(user.getEmail());
			usertarger.setFullName(user.getFullName());
			usertarger.setStatus(user.getStatus());

			Roles role = roleServiceImp.update_role(user.getRole());
			usertarger.setRole(role);

			usertarger.setUserName(user.getUserName());

			Users new_user = userRepository.save(usertarger);
			return new_user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Boolean delete_User(Users user) {
		try {
			userRepository.delete(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Users get_User_By_UserName(String user_name) {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(user_name);
	}

	public Boolean delete_User_By_ID(Long userID) {
		// TODO Auto-generated method stub
		Users user = userRepository.findById(userID).get();
		try {
			userRepository.delete(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	 

}
