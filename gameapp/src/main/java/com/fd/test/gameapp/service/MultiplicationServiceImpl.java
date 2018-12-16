package com.fd.test.gameapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fd.test.gameapp.model.Multiplication;
import com.fd.test.gameapp.model.MultiplicationResultAttempt;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {
	
	@Autowired
	private RandomNumberGeneratorService randomNumberGeneratorService;
	
	@Autowired
	public MultiplicationServiceImpl(RandomNumberGeneratorService randomNumberGeneratorService) {
		// TODO Auto-generated constructor stub
		this.randomNumberGeneratorService = randomNumberGeneratorService;
	}

	@Override
	public Multiplication getMultiplication() {
		// TODO Auto-generated method stub
		int factorA = randomNumberGeneratorService.getRandomNumber();
		int factorB = randomNumberGeneratorService.getRandomNumber();
		return new Multiplication(factorA, factorB);
	}
	
	@Override
	public boolean checkAttempt(MultiplicationResultAttempt attempt) {
		// TODO Auto-generated method stub
		return attempt.getUserAttempt() == (attempt.getMultiplication().getFactorA() * attempt.getMultiplication().getFactorB());
	}

}
