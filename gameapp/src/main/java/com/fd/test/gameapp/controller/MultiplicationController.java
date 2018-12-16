package com.fd.test.gameapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fd.test.gameapp.model.Multiplication;
import com.fd.test.gameapp.service.MultiplicationService;

@RestController
@RequestMapping("/multiplication")
public class MultiplicationController {

	private final MultiplicationService multiplicationService;
	
	@Autowired
	public MultiplicationController(MultiplicationService multiplicationService) {
		this.multiplicationService = multiplicationService;
	}
	
	@GetMapping("/random")
	public Multiplication getRandomMultiplication() {
		return multiplicationService.getMultiplication();
	}
}
