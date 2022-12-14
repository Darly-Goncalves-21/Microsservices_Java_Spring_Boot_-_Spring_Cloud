package com.solisti.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solisti.hrpayroll.entities.Payment;
import com.solisti.hrpayroll.entities.Worker;
import com.solisti.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	
	public Payment getPayment(Long workerId, Long days) {
		Worker worker = workerFeignClient.findId(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}

}
