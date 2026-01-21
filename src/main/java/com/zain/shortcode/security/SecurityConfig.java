/*
 * @author m.sabon
 */
package com.zain.shortcode.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class SecurityConfig.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	/** The authentication failure handler. */
	@Autowired
	private AuthenticationFailureHandler authenticationFailureHandler;

	/**
	 * Configure global.
	 *
	 * @param auth the auth
	 * @throws Exception the exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("m.sabon").password("{noop}password").authorities("admin");

	}

	/**
	 * Filter chain.
	 *
	 * @param http the http
	 * @return the security filter chain
	 * @throws Exception the exception
	 */
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(request -> request.antMatchers("/error").permitAll()
						.antMatchers("/resources/**", "/assets/**", "/img/**", "/api-comp/**").permitAll()
						.antMatchers("/bundels/").hasAnyAuthority("User").anyRequest().authenticated())
				.formLogin(login -> login.loginPage("/login").failureHandler(authenticationFailureHandler)
						.defaultSuccessUrl("/home").failureUrl("/login?error").permitAll())

				.logout(logout -> logout.permitAll());
		return http.build();
	}
}