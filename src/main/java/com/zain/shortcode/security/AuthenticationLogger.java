package com.zain.shortcode.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.authentication.event.LogoutSuccessEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationLogger implements ApplicationListener<AbstractAuthenticationEvent>{

	private static final Logger log = LogManager.getLogger();

	@Override
	public void onApplicationEvent(AbstractAuthenticationEvent event) {

		if(event instanceof InteractiveAuthenticationSuccessEvent || event instanceof LogoutSuccessEvent) {
			
			WebAuthenticationDetails  details = (WebAuthenticationDetails) event.getAuthentication().getDetails();
			
			if( event instanceof InteractiveAuthenticationSuccessEvent)
				log.info("LOGIN SUCCESS - "+ event.getAuthentication().getName()+" - from IP :"+details.getRemoteAddress());
			else if(event instanceof LogoutSuccessEvent)
				log.info("LOGOUT SUCCESS - "+ event.getAuthentication().getName()+" - from IP :"+details.getRemoteAddress());
		
		}
	}

}
