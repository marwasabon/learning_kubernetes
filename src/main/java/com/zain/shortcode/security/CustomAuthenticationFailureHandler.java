package com.zain.shortcode.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component("authFailureHandler")
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler{

	private static final Logger log = LogManager.getLogger();

	private static final String FAILURE_URL = "/login?error";

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {	

		setDefaultFailureUrl(FAILURE_URL);
		
		String username = (String) request.getParameter("username");

		log.info("AUTHENTICATION FAILURE - "+ username+" - from IP :"+getClientIP(request));
		super.onAuthenticationFailure(request, response, exception);
	}

	public final String getClientIP(HttpServletRequest request) {
		final String xfHeader = request.getHeader("X-Forwarded-For");
		if (xfHeader == null) {
			return request.getRemoteAddr();
		}
		return xfHeader.split(",")[0];
	}
}
