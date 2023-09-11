package com.zain.shortcode;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zain.shortcode.models.Classes;
import com.zain.shortcode.services.ClassService;

@SpringBootTest
public class ClassServiceUnitTests {

	@Autowired
	private ClassService classservice;

	@Test
	public void add_Class_Test() throws Exception {

		Classes classe = new Classes();
		classe.setClassName("Silver23");
		Classes newClass = classservice.add_class(classe);
		if (newClass != null)
			System.out.println(newClass.getClassID());
	}

	@Test
	public void get_All_Classes_Test() {
		List<Classes> classes = classservice.get_All_Classes();
		for (Classes classe : classes) {
			System.out.println(classe.toString());
		}
	}
}