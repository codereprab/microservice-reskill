package com.ibm.learning.controller;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.learning.entity.UserData;
import com.ibm.learning.model.LoginRequest;
import com.ibm.learning.model.LoginResponse;
import com.ibm.learning.security.config.TokenUtil;
import com.ibm.learning.service.CustomUserDetailsService;

@RestController
@CrossOrigin
public class LoginController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenUtil tokenUtil;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest)
			throws Exception {
		/*
		 * logger.info("Before Authenticate");
		 * authenticate(authenticationRequest.getUsername(),
		 * authenticationRequest.getPassword()); logger.info("After Authenticate");
		 * logger.info("Before loadUserByUsername"); final UserDetails userDetails =
		 * customUserDetailsService.loadUserByUsername(authenticationRequest.getUsername
		 * ()); logger.info("After loadUserByUsername");
		 */
		UserDetails userDetails = customUserDetailsService.loadUser(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final String token = tokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new LoginResponse(token));
	}

	/*
	 * private void authenticate(String username, String password) throws Exception
	 * { Objects.requireNonNull(username); Objects.requireNonNull(password);
	 * 
	 * try { authenticationManager.authenticate(new
	 * UsernamePasswordAuthenticationToken(username, password)); } catch
	 * (DisabledException e) { throw new Exception("USER_DISABLED", e); } catch
	 * (BadCredentialsException e) { throw new Exception("INVALID_CREDENTIALS", e);
	 * } }
	 */

}
