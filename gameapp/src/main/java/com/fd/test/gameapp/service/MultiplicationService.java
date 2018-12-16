package com.fd.test.gameapp.service;

import com.fd.test.gameapp.model.Multiplication;
import com.fd.test.gameapp.model.MultiplicationResultAttempt;

public interface MultiplicationService {

	Multiplication getMultiplication();
	
	boolean checkAttempt(MultiplicationResultAttempt attempt);
}
