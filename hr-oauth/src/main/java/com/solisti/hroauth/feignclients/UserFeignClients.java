package com.solisti.hroauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.solisti.hroauth.entities.User;


@Component
@FeignClient(name = "hr-user", path= "/users")
public interface UserFeignClients {

	
	@GetMapping(value = "/search")
    ResponseEntity<User> findByEmail(@RequestParam("email") String email);
		
}
