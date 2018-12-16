package com.fd.test.gameapp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fd.test.gameapp.model.Multiplication;
import com.fd.test.gameapp.model.MultiplicationResultAttempt;
import com.fd.test.gameapp.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiplicationServiceTest {
	
	@Autowired
	RandomNumberGeneratorService raodomNumberGeneratorService;
	
	@Autowired
	MultiplicationService multiplicationService;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void getMultiplicationTest() {
		//given(raodomNumberGeneratorService.getRandomNumber()).willReturn(30, 40);
		
		Multiplication multiplication = multiplicationService.getMultiplication();
		
		assertThat(multiplication.getFactorA()).isEqualTo(multiplication.getFactorA());
		assertThat(multiplication.getFactorB()).isEqualTo(multiplication.getFactorB());
		assertThat(multiplication.getResult()).isEqualTo(multiplication.getResult());
	}
	
	@Test
	public void checkCorrectAttemptTest() {
		//given
		User user = new User("Abhishek");
		Multiplication multiplication = new Multiplication(30, 20);
		int attempt = 600;
		MultiplicationResultAttempt multiplicationAttempt = new MultiplicationResultAttempt(multiplication, user, attempt);
		
		boolean check = multiplicationService.checkAttempt(multiplicationAttempt);
		assertThat(check).isTrue();
	}
	
	@Test
	public void checkIncorrectAttemptTest() {
		User user = new User("Abhishek");
		Multiplication multiplication = new Multiplication(30, 20);
		int attempt = 601;
		MultiplicationResultAttempt multiplicationAttempt = new MultiplicationResultAttempt(multiplication, user, attempt);
		boolean check = multiplicationService.checkAttempt(multiplicationAttempt);
		assertThat(check).isFalse();
	}

}
