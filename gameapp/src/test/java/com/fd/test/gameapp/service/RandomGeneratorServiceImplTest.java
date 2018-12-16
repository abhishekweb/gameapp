package com.fd.test.gameapp.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorServiceImplTest {
	
	@Autowired
	private RandomNumberGeneratorService randomNumberGeneratorService;
	@Before
	public void setUp() throws Exception {
		randomNumberGeneratorService = new RandomGeneratorServiceImpl();
	}

	@Test
	public void getNumberTest() {
		
		List<Integer> randomFactor = IntStream.range(1, 1000)
										.map(i -> randomNumberGeneratorService.getRandomNumber())
										.boxed().collect(Collectors.toList());
			
		assertThat(randomFactor).containsOnlyElementsOf(IntStream.range(11, 100).boxed().collect(Collectors.toList()));
								
		
	}

}
