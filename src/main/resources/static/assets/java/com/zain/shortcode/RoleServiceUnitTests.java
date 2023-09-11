package com.zain.shortcode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zain.shortcode.models.Roles;
import com.zain.shortcode.services.RoleService;

/**
 * @author MJ
 *
 */

@SpringBootTest
public class RoleServiceUnitTests {

	@Autowired
	private RoleService roleService;

	@Test
	public void get_Role_ById_Test() {
		Roles role = roleService.get_Role_ById(1L);
		if (role != null)
			System.out.println(role.toString());
	}

	@Test
	public void get_All_Roles_Test() {
		for (Roles role : roleService.get_All_Roles()) {
			System.out.println(role.toString());
		}
	}

	@Test
	public void add_role_Test() {
		Roles role = new Roles();
		role.setName("admin");
		Roles new_role = roleService.add_role(role);
		if (new_role != null)
			System.out.println(new_role.toString());
	}

}
