package com.zain.shortcode;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zain.shortcode.models.Users;
import com.zain.shortcode.services.RoleService;
import com.zain.shortcode.services.UserService;

@SpringBootTest
public class UserServiceUnitTests {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Test
	public void add_User_Test() {
		Users user = new Users();
		user.setUserName("m.s");
		user.setFullName("Mohamed Ali Abbas");
		user.setEmail("marwasabon@zain.sd.com");
		user.setRole(roleService.get_Role_ById(1L));

		// user.setCreated_by(userService.get_User_ById(1L));
		Users newUser = userService.add_User(user);
		if (newUser != null)
			System.out.println(user.getID());
	}

	@Test
	public void get_User_Test() {
		Users user = userService.get_User_ById(1L);
		if (user != null) {
			System.out.println(user.toString());
		}
	}

	@Test
	public void get_User_Roles_Test() {
		Users user = userService.get_User_ById(1L);
		if (user != null) {
			System.out.println(user.getRole().toString());
		}
	}

	@Test
	public void delete_User_Test() {
		if (userService.delete_User(userService.get_User_ById(5L)))
			System.out.println("Done...");
	}

	@Test
	public void get_All_Users_Test() {
		List<Users> users = userService.get_All_Users();
		for (Users user : users) {
			System.out.println(user.toString());
		}
	}

}
