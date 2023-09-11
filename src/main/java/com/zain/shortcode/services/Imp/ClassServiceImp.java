package com.zain.shortcode.services.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zain.shortcode.models.Classes;
import com.zain.shortcode.repository.ClassesRepository;
import com.zain.shortcode.services.ClassService;


/**
 * @author m.sabon
 *
 */
@Service
public class ClassServiceImp implements ClassService {

	@Autowired
	private ClassesRepository classRepositsory;

	@Override
	public Classes get_Class_ById(Long id) {
		// TODO Auto-generated method stub
		return classRepositsory.findById(id).get();

	}

	@Override
	public List<Classes> get_All_Classes() {
		// TODO Auto-generated method stub
		return (List<Classes>) classRepositsory.findAll();
	}

	@Override
	public Classes add_class(Classes classe) throws Exception {
		// TODO Auto-generated method stub
		Optional<Classes> op = classRepositsory.findByclassName(classe.getClassName().trim());

		if (op.isPresent()) {
			throw new Exception("Class with Name  " + classe.getClassName() + "  Already Exists");
		}

		try {
			Classes new_class = classRepositsory.save(classe);
			return new_class;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Something went wrong");
		}

	}

	@Override
	public Classes update_class(Classes classe) {
		// TODO Auto-generated method stub
		try {
			Classes new_class = classRepositsory.save(classe);
			return new_class;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void delete_Class_ById(Long id) {
		// TODO Auto-generated method stub
		classRepositsory.deleteById(id);
	}

}