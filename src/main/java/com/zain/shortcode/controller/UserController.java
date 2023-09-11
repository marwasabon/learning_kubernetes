package com.zain.shortcode.controller;

import java.util.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zain.shortcode.models.Roles;
import com.zain.shortcode.models.Users;
import com.zain.shortcode.services.Imp.RoleServiceImp;
import com.zain.shortcode.services.Imp.UserServiceImp;

/**
 * @author m.sabon
 *
 */
@Controller
@RequestMapping("/users")

public class UserController {

	@Autowired
	UserServiceImp userServiceImp;
	@Autowired
	RoleServiceImp rolesServiceImp;

	/**
	 * getUsers
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String getUsers(Model model) {
		List<Users> Useres = userServiceImp.get_All_Users();
		List<Roles> Roles = rolesServiceImp.get_All_Roles();
		model.addAttribute("Useres", Useres);

		model.addAttribute("Roles", Roles);

		return "users/user-list";
	}

	/**
	 * getUser
	 * 
	 * @param UserID
	 * @return
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping({ "/getUser" })
	@ResponseBody
	public ResponseEntity<Users> getUser(@RequestParam Long UserID) {
		Users User = this.userServiceImp.get_User_ById(UserID);
		System.out.println("############# User is  = " + User.getUserName() + "ID is " + User.getID());
		return new ResponseEntity(User, HttpStatus.OK);
	}

	/**
	 * saveUser
	 * 
	 * @param User
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping({ "/saveUser" })
	public String saveUser(@ModelAttribute Users User, RedirectAttributes redirectAttributes) {
		this.userServiceImp.add_User(User);

		redirectAttributes.addFlashAttribute("success", "User added successfuly!");
		return "redirect:/users/all";
	}

	/**
	 * updateUser
	 * 
	 * @param User
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping({ "/updateUser" })
	public String updateUser(@ModelAttribute Users User, RedirectAttributes redirectAttributes) {

		if (this.userServiceImp.isRoleChangeForLoggedInUser(User)) {
			this.userServiceImp.update_User(User, User.getID());
			redirectAttributes.addFlashAttribute("success", "User updated successfuly!");
			this.userServiceImp.logoutUser();

			return "redirect:/login";

		} else {
			this.userServiceImp.update_User(User, User.getID());
			redirectAttributes.addFlashAttribute("success", "User updated successfuly!");
		}
		return "redirect:/users/all";
	}
	
	/**
	 * checkUser
	 * @param User
	 * @return
	 */
	@PostMapping({ "/check" })
	@ResponseBody
	public Map<String, Object> checkUser(@ModelAttribute Users User) {
		boolean isRoleChanged = this.userServiceImp.isRoleChangeForLoggedInUser(User);
		this.userServiceImp.update_User(User, User.getID());
		Map<String, Object> response = new HashMap<>();
		response.put("user", User);
		response.put("isRoleChanged", isRoleChanged);
		return response;
	}
	/**
	 * deleteUser
	 * 
	 * @param UserID
	 * @param redirectAttributes
	 * @return
	 */
	@GetMapping({ "/deleteUser" })
	public String deleteUser(@RequestParam Long UserID, RedirectAttributes redirectAttributes) {

		this.userServiceImp.delete_User_By_ID(UserID);
		redirectAttributes.addFlashAttribute("success", "User deleted successfuly!");
		return "redirect:/users/all";
	}
}
