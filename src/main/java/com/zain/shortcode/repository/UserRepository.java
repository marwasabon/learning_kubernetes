package com.zain.shortcode.repository;

import java.util.Optional;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import com.zain.shortcode.models.Users;

/**
 * @author m.sabon
 *
 */
public interface UserRepository extends DataTablesRepository<Users, Long> {
	/**
	 * findByUserName
	 * 
	 * @param userName
	 * @return
	 */
	public Users findByUserName(String userName);

	/**
	 * findByID
	 * 
	 * @param id
	 * @return
	 */
	Optional<Users> findByID(Long id);

}
