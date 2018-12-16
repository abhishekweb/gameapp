package com.fd.test.gameapp.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fd.test.gameapp.model.Multiplication;
import com.fd.test.gameapp.model.MultiplicationResultAttempt;
import com.fd.test.gameapp.model.ResultResponse;
import com.fd.test.gameapp.model.User;
import com.fd.test.gameapp.service.MultiplicationService;

@RunWith(SpringRunner.class)
@WebMvcTest(ResultController.class)
public class ResultControllerTest {
	
	@MockBean
	private MultiplicationService multiplicationService;
	
	@Autowired
	private MockMvc mockMvc;
	
	private JacksonTester<MultiplicationResultAttempt> jsonResult;
	private JacksonTester<ResultResponse> jsonResponse;
	
	@Before
	public void setUp() throws Exception {
		JacksonTester.initFields(this, new ObjectMapper());
	}

	@Test
	public void postAttemptTest() throws Exception {
		given(multiplicationService.checkAttempt(Mockito.any(MultiplicationResultAttempt.class))).willReturn(true);
		User user = new User("John");
		Multiplication multiplication = new Multiplication(30, 40);
		MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(multiplication, user, 1200);
		
		// when
		MockHttpServletResponse response = mockMvc.perform(post("/results").contentType(MediaType.APPLICATION_JSON).content(jsonResult.write(attempt).getJson()).characterEncoding("utf-8")).andReturn().getResponse();
		
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo(jsonResponse.write(new ResultResponse(true)).getJson());
		
	}

}
