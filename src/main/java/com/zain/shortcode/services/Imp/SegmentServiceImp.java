package com.zain.shortcode.services.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zain.shortcode.models.Segment;
import com.zain.shortcode.repository.SegmentRepository;
import com.zain.shortcode.services.SegmentService;

/**
 * @author m.sabon
 *
 */
@Service
public class SegmentServiceImp implements SegmentService {

	@Autowired
	private SegmentRepository SegmentRepositsory;

	@Override
	public Segment get_Segment_ById(Long id) {
		// TODO Auto-generated method stub
		return SegmentRepositsory.findById(id).get();

	}

	@Override
	public List<Segment> get_All_Segment() {
		// TODO Auto-generated method stub
		return (List<Segment>) SegmentRepositsory.findAll();
	}

	@Override
	public Segment add_Segment(Segment Segment) throws Exception {
		// TODO Auto-generated method stub

		Optional <Segment> op = SegmentRepositsory.findBysegmentName(Segment.getSegmentName().trim());
		if (op.isPresent()) {
			throw new Exception("Segment with Name  " + Segment.getSegmentName() + "  Already Exists");
		}
		try {
			Segment new_Segment = SegmentRepositsory.save(Segment);
			return new_Segment;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Something went wrong");
		}

	}

	@Override
	public Segment update_Segment(Segment Segment) {
		// TODO Auto-generated method stub
		try {
			Segment new_Segment = SegmentRepositsory.save(Segment);
			return new_Segment;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public void delete_Segment_ById(Long id) {
		// TODO Auto-generated method stub
		SegmentRepositsory.deleteById(id);
	}

}