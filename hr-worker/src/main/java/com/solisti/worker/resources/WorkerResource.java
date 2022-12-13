package com.solisti.worker.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private WorkerRepository repository;
	
	
	
	@GetMapping
	public ResponseEntity<List<Worker>> finALL(){
		List<Worker> list = repository.findAll();
		return  ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Worker>> findId(@PathVariable("id") Long id){
		Optional<Worker> worker = repository.findById(id);
		return  ResponseEntity.ok(worker);
	}
}
