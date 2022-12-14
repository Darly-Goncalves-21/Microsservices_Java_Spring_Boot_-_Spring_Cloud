package com.solisti.worker.resources;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solisti.worker.entities.Worker;
import com.solisti.worker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerRepository repository;
	
	
	
	@GetMapping
	public ResponseEntity<List<Worker>> finALL(){
		List<Worker> list = repository.findAll();
		return  ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Worker>> findId(@PathVariable("id") Long id){
		
		logger.info("PORTA = " + env.getProperty("local.server.port"));
		
		Optional<Worker> worker = repository.findById(id);
		return  ResponseEntity.ok(worker);
	}
}
