package com.solisti.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.solisti.hrpayroll.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(Long workerId, Long days) {
		return new Payment("Bob", 200.0, days);
	}

}
