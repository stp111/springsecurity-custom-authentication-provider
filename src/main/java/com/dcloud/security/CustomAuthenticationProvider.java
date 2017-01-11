package com.dcloud.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private Logger logger = LoggerFactory.getLogger(getClass());

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		logger.info("custom authenticate ... ");
		//
		String strName = authentication.getName();
		if (strName == null) {
			logger.warn("authentication name is null!");
		}

		String strPwd = null;
		Object cred = authentication.getCredentials();
		if (cred != null) {

			strPwd = cred.toString();
		} else {
			// spring security 3 中credentials为null.
			logger.warn("authentication's credential is null!!");
		}

		logger.info("get auth info {} {}", strName, strPwd);

		// TODO ...
		final List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
		grantedAuths.add(new SimpleGrantedAuthority("admin"));
		final UserDetails principal = new User(strName, strPwd, grantedAuths);
		final Authentication auth = new UsernamePasswordAuthenticationToken(principal, (Object) strPwd, grantedAuths);
		return auth;

		/***
		 * Once created you cannot set this
		 * token to authenticated. Create a new instance using the constructor
		 * which takes a GrantedAuthority list will mark this as authenticated.
		 */
		
	}

	public boolean supports(Class<?> authentication) {
		//
		logger.info("custom authentication supports ... {}", authentication);
		boolean b = authentication.equals(UsernamePasswordAuthenticationToken.class);
		return b;
	}

}
