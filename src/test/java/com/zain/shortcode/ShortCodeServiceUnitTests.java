
package com.zain.shortcode;

import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zain.shortcode.models.AdditionalService;
import com.zain.shortcode.models.Classes;
import com.zain.shortcode.models.Segment;
import com.zain.shortcode.models.ShortCode;
import com.zain.shortcode.models.Status;
import com.zain.shortcode.services.ShortCodeService;

@SpringBootTest
public class ShortCodeServiceUnitTests {

	@Autowired
	private ShortCodeService ShortCodervice;

	@Test
	public void add_ShortCode_Test() {

		ShortCode ShortCode = new ShortCode();

		// set.add(rm2);

		// rm.setShortcode(ShortCode);

		ShortCode.setAccountName("account5");
		ShortCode.setActivationDate(new Date());
		ShortCode.setComment("new commment24");
		ShortCode.setCustomerName("Marwa jaberallah24");
		ShortCode.setExpiryDate(new Date());
		ShortCode.setFollowUpNumber("123458");
		ShortCode.setShortcodeNO("1234556");
		ShortCode.setShortCodePrice("3000");
		ShortCode.setZainRequesterAccount("marwa2");
		ShortCode.setZainRequesterEmail("marwasabon2@gmail.com");

		Classes classes = new Classes();
		classes.setClassName("hhhclass33");
		// List<Classes> classeslist = new ArrayList<>(); //classeslist.add(classes);
		ShortCode.setClasses(classes);

		Status status = new Status();
		status.setStatusName("newstuff33");
		ShortCode.setStatuses(status);

		Segment segments = new Segment();
		segments.setSegmentName("hhhhh33");
		// List<Segment>segmentlist = new ArrayList<>(); //segmentlist.add(segments);
		ShortCode.setSegments(segments);

		AdditionalService aservice = new AdditionalService();
		aservice.setAserviceName("hhhhsssss33"); //

		ShortCode.setAdditionalServices(aservice);
	

		ShortCode newShortCode;
		try {
			newShortCode = ShortCodervice.add_ShortCode(ShortCode);
			if (newShortCode != null)
				System.out.println(newShortCode.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
