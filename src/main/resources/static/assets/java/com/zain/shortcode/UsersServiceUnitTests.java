package com.zain.shortcode;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zain.shortcode.models.Users;
import com.zain.shortcode.services.RoleService;
import com.zain.shortcode.services.UserService;

/**
 * @author MJ
 *
 */

@SpringBootTest
public class UsersServiceUnitTests {

	@Autowired
	private UserService UsersService;

	@Autowired
	private RoleService roleService;

	@Test
	public void add_Users_Test() throws NoSuchAlgorithmException {
		Users users = new Users();
		users.setFullName("Marwa Jaberallah Sabon");
		users.setEmail("m");
		users.setUserName("m.sabon");
		users.setRole(roleService.get_Role_ById(1L));
		users.setStatus(1);
		;

		Users newUsers = UsersService.add_User(users);
		if (newUsers != null)
			System.out.println(users.getId());
	}

	@Test
	public void get_Users_Test() {
		Users Users = UsersService.get_User_ById(1L);
		if (Users != null) {
			System.out.println(Users.toString());
		}
	}

	@Test
	public void get_Users_Roles_Test() {
		Users Users = UsersService.get_User_ById(1L);
		if (Users != null) {
			System.out.println(Users.getRole().toString());
		}
	}



}
