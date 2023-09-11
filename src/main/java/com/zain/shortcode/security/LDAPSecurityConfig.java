package com.zain.shortcode.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;




@Configuration
public class LDAPSecurityConfig extends WebSecurityConfigurerAdapter {
   
	@Value("${ldap.domain}")
	private String ldapDomain;
	
	@Value("${ldap.urls}")
    private String ldapUrls;
    
    @Value("${ldap.base.dn}")
    private String ldapBaseDn;
   
    @Autowired
    @Qualifier("authFailureHandler")
    private AuthenticationFailureHandler authenticationFailureHandler;
    
    @Autowired
    private CustomUserDetailsContextMapper ldapUserDetailsMapper;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/users/all").hasAuthority("admin")

                .antMatchers("/login**").anonymous()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("**/user-photos/**").permitAll()
                .antMatchers("/assets/**").permitAll()
                .antMatchers("/img/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureHandler(authenticationFailureHandler)
                .permitAll()
                .and()
                .logout() 
                .permitAll()
                .and()
                .csrf()
                .disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth
            .authenticationProvider(activeDirectoryLdapAuthenticationProvider());

    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {

    	return new ProviderManager(Arrays.asList(activeDirectoryLdapAuthenticationProvider()));
    }
    
    @Bean
    public AuthenticationProvider activeDirectoryLdapAuthenticationProvider() {
    	
    	ActiveDirectoryLdapAuthenticationProvider provider = new ActiveDirectoryLdapAuthenticationProvider(ldapDomain,ldapUrls,ldapBaseDn);
        provider.setConvertSubErrorCodesToExceptions(true);
        provider.setUseAuthenticationRequestCredentials(true);
        provider.setUserDetailsContextMapper(ldapUserDetailsMapper);
        return provider;
    }
}
