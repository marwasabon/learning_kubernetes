package com.zain.shortcode;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zain.shortcode.models.Roles;
import com.zain.shortcode.services.RoleService;

@SpringBootTest
public class RoleServiceUnitTests {

	@Autowired
	private RoleService Roleervice;

	@Test
	public void add_Role_Test() throws Exception {

		Roles Role = new Roles();
		
		Role.setName("Role1");
		Roleervice.add_role(Role);
		if (Role != null)
			System.out.println(Role.toString());
	}
	@Test
	public void update_Role_Test() throws Exception {
		Roles role = Roleervice.get_Role_ById(9L);
		System.out.println("id is "+role.getId());
		role.setName("new");
		Roles newRole = Roleervice.add_role(role);
		
		  if (newRole != null) System.out.println(newRole.toString());
		 
	}
}