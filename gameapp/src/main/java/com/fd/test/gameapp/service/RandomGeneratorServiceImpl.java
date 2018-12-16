package com.fd.test.gameapp.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class RandomGeneratorServiceImpl implements RandomNumberGeneratorService {
	
	private static int MIN_LIMIT = 11;
	private static int MAX_LIMIT = 99;

	@Override
	public int getRandomNumber() {
		// TODO Auto-generated method stub
		//return new Random().nextInt((MAX_LIMIT - MIN_LIMIT) + 1) + MIN_LIMIT;
		
		return (int) (Math.random() * ((MAX_LIMIT - MIN_LIMIT) + 1)) + MIN_LIMIT;
		
	}

}
