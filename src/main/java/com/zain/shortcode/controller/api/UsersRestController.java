package com.zain.shortcode.controller.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.zain.shortcode.models.Roles;
import com.zain.shortcode.models.Users;
import com.zain.shortcode.repository.UserRepository;
import com.zain.shortcode.services.UserService;

/**
 * @author m.sabon
 *
 */
@RestController
@RequestMapping(value = "/user")

public class UsersRestController {

	@Autowired
	UserRepository UserRepo;
	@Autowired
	UserService userService;

	/**
	 * getUseres
	 * 
	 * @param input
	 * @return
	 * @throws InterruptedException
	 */
	@JsonView(DataTablesOutput.View.class)
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public DataTablesOutput<Users> getUseres(@Valid DataTablesInput input) throws InterruptedException {
		DataTablesOutput<Users> data = UserRepo.findAll(input);
		System.out.println("-----data" + data);
		return data;
	}

	/**
	 * role
	 * 
	 * @return
	 */
	@GetMapping("/role")
	public Roles getUserRole() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		Users user = userService.get_User_By_UserName(username);
		return user.getRole();
	}
}
