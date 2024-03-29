package com.solisti.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solisti.hroauth.entities.User;
import com.solisti.hroauth.feignclients.UserFeignClients;

@Service
public class UserService {
	
	private  static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClients userFeignClients;
	
	public User findByEmail(String email) throws IllegalAccessException {
		
		User user = userFeignClients.findByEmail(email).getBody();
		if(user == null) {
			logger.error("EMAIL NOT FOUND : " + email);
			throw new IllegalAccessException("EMAIL NOT FOUND"); 
		}
		logger.info("EMAIL FOUND : " + email);
		return user;
	}

}
