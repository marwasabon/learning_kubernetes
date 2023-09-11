
package com.zain.shortcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import com.zain.shortcode.dto.ShortCodeDTO;
import com.zain.shortcode.models.AdditionalService;
import com.zain.shortcode.models.Classes;
import com.zain.shortcode.models.RoutingMSISDNs;
import com.zain.shortcode.models.Segment;
import com.zain.shortcode.models.ShortCode;
import com.zain.shortcode.models.Status;
import org.modelmapper.ModelMapper;

public class MapperUnitTests {
	private ModelMapper modelMapper;

	@Test
	void addshortcode() {

		ShortCodeDTO ShortCodeDTOo = new ShortCodeDTO();

		ShortCode ShortCode = new ShortCode();

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
		classes.setClassName("hhh");

		// List <Classes> = new ArrayList<Classes>();

		ShortCode.setClasses(classes);

		Segment segments = new Segment();
		segments.setSegmentName("hhh");
		 ShortCode.setSegments(segments);

		Status classess = new Status();
		classess.setStatusName("hhhh");
		 ShortCode.setStatuses(classess);
		 

		AdditionalService aservice = new AdditionalService();
		aservice.setAserviceName("hhhhsssss");
		ShortCode.setAdditionalServices(aservice);

		RoutingMSISDNs routing = new RoutingMSISDNs();
		routing.setRoutingMSISDN("list");
		Set<RoutingMSISDNs> routlist = new HashSet<RoutingMSISDNs>();
		routlist.add(routing);
		routing.setShortcode(ShortCode);

		//ShortCode.setRoutingMSISDNs(routlist);
		ShortCode shortcode12 = modelMapper.map(ShortCodeDTOo, ShortCode.class);

		assertEquals(routlist, ShortCodeDTOo.getRoutingMSISDNs());
		System.out.println("DTO--------" + shortcode12);

		// shortcodeervice.add_ShortCode(ShortCode);

		System.out.println("DTO--------" + ShortCode);
	}
}
