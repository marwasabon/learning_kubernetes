package com.zain.shortcode.services.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zain.shortcode.models.AdditionalService;
import com.zain.shortcode.repository.AdditionalServiceRepository;
import com.zain.shortcode.services.AdditionalServiceService;

/**
 * @author MJ
 *
 */
@Service
public class AdditionalServiceServiceImp implements AdditionalServiceService {

	@Autowired
	private AdditionalServiceRepository AdditionalServiceRepositsory;

	@Override
	public AdditionalService get_AdditionalService_ById(Long id) {
		// TODO Auto-generated method stub
		return AdditionalServiceRepositsory.findById(id).get();

	}

	@Override
	public List<AdditionalService> get_All_AdditionalService() {
		// TODO Auto-generated method stub
		return (List<AdditionalService>) AdditionalServiceRepositsory.findAll();
	}

	@Override
	public AdditionalService add_AdditionalService(AdditionalService additionalService) throws Exception {
		// TODO Auto-generated method stub
		Optional<AdditionalService> op = AdditionalServiceRepositsory
				.findByaserviceName(additionalService.getAserviceName().trim());
		if (op.isPresent()) {
			throw new Exception(
					"AdditionalService with Name  " + additionalService.getAserviceName() + "  Already Exists");
		}
		try {
			AdditionalService new_AdditionalService = AdditionalServiceRepositsory.save(additionalService);
			return new_AdditionalService;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Something went wrong");
		}

	}

	@Override
	public AdditionalService update_AdditionalService(AdditionalService AdditionalService) {
		// TODO Auto-generated method stub
		try {
			AdditionalService new_AdditionalService = AdditionalServiceRepositsory.save(AdditionalService);
			return new_AdditionalService;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public void delete_AdditionalService_ById(Long id) {
		// TODO Auto-generated method stub
		AdditionalServiceRepositsory.deleteById(id);
	}

}