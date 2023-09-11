
package com.zain.shortcode.services.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zain.shortcode.models.Roles;
import com.zain.shortcode.repository.RolesRepository;
import com.zain.shortcode.services.RoleService;

/**
 * @author m.sabon
 *
 */
@Service
public class RoleServiceImp implements RoleService {

	@Autowired
	private RolesRepository roleRepository;

	@Override
	public Roles get_Role_ById(Long id) {
		return roleRepository.findById(id).get();
	}

	@Override
	public List<Roles> get_All_Roles() {
		return (List<Roles>) roleRepository.findAll();
	}

	@Override
	public Roles add_role(Roles role) throws Exception {
		Optional<Roles> op = roleRepository.findByname(role.getName().trim());
		if (op.isPresent())
			throw new Exception("Role with Name  " + role.getName() + "  Already Exists");

		try {
			return roleRepository.save(role);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Something went wrong");
		}
	}
 


	@Override
	public Roles update_role(Roles role) {
		try {
			return roleRepository.save(role);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void delete_Role_By_ID(Long id) {

		// TODO Auto-generated method stub
		roleRepository.deleteById(id);
	}

}
