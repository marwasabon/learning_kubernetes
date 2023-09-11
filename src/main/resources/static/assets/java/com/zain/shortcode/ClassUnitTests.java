package com.zain.shortcode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zain.shortcode.models.Classes;
import com.zain.shortcode.models.Roles;
import com.zain.shortcode.services.ClassService;
import com.zain.shortcode.services.RoleService;

/**
 * @author MJ
 *
 */

@SpringBootTest

public class ClassUnitTests {

	@Autowired
	private ClassService classService;
	
	@Test
	public void get_Class_ById_Test() {
		Classes classe = classService.get_Class_ById(1L);
		if (classe != null)
			System.out.println(classe.toString());
	}

	@Test
	public void get_All_Classes_Test() {
		for (Classes classe : classService.get_All_Classes()) {
			System.out.println(classe.toString());
		}
	}

	@Test
	public void add_Class_Test() {
		Classes classe = new Classes();
		classe.setClassName("Silver");
		Classes classee = classService.add_class(classe);
		if (classee != null)
			System.out.println(classee.toString());
	}
}
