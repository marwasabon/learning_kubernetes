package com.zain.shortcode;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zain.shortcode.models.Status;
import com.zain.shortcode.services.StatusService;

@SpringBootTest
public class StatusServiceUnitTests {

	@Autowired
	private StatusService statuservice;

	@Test
	public void add_Status_Test()  {

		Status Status = new Status();
		Status.setStatusName("new");
		Status newStatus = null;
		try {
			newStatus = statuservice.add_Status(Status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (newStatus != null)
			System.out.println(newStatus.toString());
	}
	@Test
	public void update_Status_Test() {
		Status ststus = statuservice.get_Status_ById(9L);
		System.out.println("id is "+ststus.getStatusID());
	ststus.setStatusName("new");
		Status newStatus = null;
		try {
			newStatus = statuservice.add_Status(ststus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  if (newStatus != null) System.out.println(newStatus.toString());
		 
	}
}