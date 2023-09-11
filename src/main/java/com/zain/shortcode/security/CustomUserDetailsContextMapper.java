package com.zain.shortcode.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.ldap.userdetails.LdapUserDetailsMapper;
import org.springframework.stereotype.Component;

import com.zain.shortcode.models.Roles;
import com.zain.shortcode.models.Users;
import com.zain.shortcode.repository.UserRepository;

@Component
public class CustomUserDetailsContextMapper extends LdapUserDetailsMapper{
	private final Logger logger = LogManager.getLogger(CustomUserDetailsContextMapper.class);
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails mapUserFromContext(DirContextOperations ctx, String username,
			Collection<? extends GrantedAuthority> authorities) {
		
	/*	
		Attributes attributes = ctx.getAttributes();
		
		Attribute attributedept = attributes.get("department");
		
		try {
			
			Object object = attributedept.get();
			String string = object.toString();
			System.out.println(string);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		
		UserDetails userDetails = super.mapUserFromContext(ctx, username, getAuthorities(username));
		
		logger.info("LDAP User Details: {}", userDetails);
		return userDetails;

	}

	private Collection<? extends GrantedAuthority> getAuthorities(String username) {
		
		Users user = repository.findByUserName(username);
		if (user == null || user.getStatus() == 0) {
			
			throw new UsernameNotFoundException(username);
		}
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		 
	      Roles role = user.getRole();
	 
		 grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		
		 logger.info("Granted Authorities: {}", grantedAuthorities);
		
		return grantedAuthorities;
	}

}
