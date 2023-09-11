package com.zain.shortcode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zain.shortcode.models.AdditionalService;
import com.zain.shortcode.services.AdditionalServiceService;

@SpringBootTest
public class AdditionalServiceServiceUnitTests {

	@Autowired
	private AdditionalServiceService AdditionalServicervice;

	@Test
	public void add_AdditionalService_Test() throws Exception {

		AdditionalService AdditionalService = new AdditionalService();
		AdditionalService AdditionalService2 = new AdditionalService();

		AdditionalService.setAserviceName("Hunting Service");
		AdditionalService2.setAserviceName("Call Masking");

		AdditionalService newAdditionalService = AdditionalServicervice.add_AdditionalService(AdditionalService);
		AdditionalService newAdditionalService2 = AdditionalServicervice.add_AdditionalService(AdditionalService2);
		if (newAdditionalService != null)
			System.out.println(newAdditionalService.toString());
		System.out.println(newAdditionalService2.toString());

	}

	@Test
	public void update_AdditionalService_Test() throws Exception {
		AdditionalService ststus = AdditionalServicervice.get_AdditionalService_ById(9L);
		System.out.println("id is " + ststus.getAserviceID());
		ststus.setAserviceName("new");
		AdditionalService newAdditionalService = AdditionalServicervice.add_AdditionalService(ststus);

		if (newAdditionalService != null)
			System.out.println(newAdditionalService.toString());

	}
}