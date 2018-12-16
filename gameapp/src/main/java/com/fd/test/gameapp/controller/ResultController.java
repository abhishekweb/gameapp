package com.fd.test.gameapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fd.test.gameapp.model.MultiplicationResultAttempt;
import com.fd.test.gameapp.model.ResultResponse;
import com.fd.test.gameapp.service.MultiplicationService;

@RestController
@RequestMapping("/results")
public class ResultController {
	
	private final MultiplicationService multiplicationService;
	
	@Autowired
	public ResultController(MultiplicationService multiplicationService) {
		this.multiplicationService = multiplicationService;
	}
	
	
	@PostMapping
	public ResponseEntity<ResultResponse> postResult(@RequestBody MultiplicationResultAttempt multiplicationResultAttempt) {
		return ResponseEntity.ok(new ResultResponse(multiplicationService.checkAttempt(multiplicationResultAttempt)));
	}
	

}
