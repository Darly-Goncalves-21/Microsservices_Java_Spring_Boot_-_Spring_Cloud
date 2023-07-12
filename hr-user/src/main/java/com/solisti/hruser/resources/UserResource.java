package com.solisti.hruser.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.solisti.hruser.entities.User;
import com.solisti.hruser.repositories.UserRepository;


@RefreshScope
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
		//private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
		
		
		@Autowired
		private UserRepository repository;
		
		
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<Optional<User>> findId(@PathVariable("id") Long id){
			
			//logger.info("PORTA = " + env.getProperty("local.server.port"));
			
			Optional<User> worker = repository.findById(id);
			return  ResponseEntity.ok(worker);
		}
		
		@GetMapping(value = "/search")
		public ResponseEntity<User> findId(@RequestParam("email") String email){
			
			//logger.info("PORTA = " + env.getProperty("local.server.port"));
			
			User user = repository.findByEmail(email);
			return  ResponseEntity.ok(user);
		}

}
