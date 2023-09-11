package com.zain.shortcode;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zain.shortcode.models.Segment;
import com.zain.shortcode.services.SegmentService;

@SpringBootTest
public class SegmentServiceUnitTests {

	@Autowired
	private SegmentService Segmentervice;

	@Test
	public void add_Segment_Test() {

		Segment Segment = new Segment();
		Segment.setSegmentName("segment1");
		Segment newSegment = null;
		try {
			newSegment = Segmentervice.add_Segment(Segment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (newSegment != null)
			System.out.println(newSegment.toString());
	}
	@Test
	public void update_Segment_Test() throws Exception {
		Segment ststus = Segmentervice.get_Segment_ById(9L);
		System.out.println("id is "+ststus.getSegmentName());
	ststus.setSegmentName("new");
		Segment newSegment = Segmentervice.add_Segment(ststus);
		
		  if (newSegment != null) System.out.println(newSegment.toString());
		 
	}
}