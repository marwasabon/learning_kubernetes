package com.zain.shortcode.services.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zain.shortcode.models.Status;
import com.zain.shortcode.repository.StatusRepository;
import com.zain.shortcode.services.StatusService;

/**
 * @author m.sabon
 *
 */

@Service
public class StatusServiceImp implements StatusService {

	@Autowired
	private StatusRepository StatusRepositsory;

	@Override
	public Status get_Status_ById(Long id) {
		// TODO Auto-generated method stub
		return StatusRepositsory.findById(id).get();

	}

	@Override
	public List<Status> get_All_Status() {
		// TODO Auto-generated method stub
		return (List<Status>) StatusRepositsory.findAll();
	}

	@Override
	public Status add_Status(Status status) throws Exception {
		// TODO Auto-generated method stub
		Optional <Status> op = StatusRepositsory.findBystatusName(status.getStatusName().trim());
		if (op.isPresent()) {
			throw new Exception("Status with Name  " + status.getStatusName() + "  Already Exists");
		}

		try {

			Status new_Status = StatusRepositsory.save(status);
			return new_Status;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Something went wrong");
		}

	}

	@Override
	public Status update_status(Status status) {
		// TODO Auto-generated method stub
 
		try {

			Status new_Status = StatusRepositsory.save(status);
			return new_Status;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public void delete_Status_ById(Long id) {
		// TODO Auto-generated method stub

		StatusRepositsory.deleteById(id);
	}

}