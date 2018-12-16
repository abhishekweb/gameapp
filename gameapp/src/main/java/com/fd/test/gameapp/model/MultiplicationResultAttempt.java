package com.fd.test.gameapp.model;

public class MultiplicationResultAttempt {

	private Multiplication multiplication;
	private User user;
	private int userAttempt;
	
	public MultiplicationResultAttempt() {
		// TODO Auto-generated constructor stub
	}	
	public MultiplicationResultAttempt(Multiplication multiplication, User user, int attempt) {
		this.multiplication = multiplication;
		this.user = user;
		this.userAttempt = attempt;
	}
	
	public Multiplication getMultiplication() {
		return multiplication;
	}
	public void setMultiplication(Multiplication multiplication) {
		this.multiplication = multiplication;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getUserAttempt() {
		return userAttempt;
	}
	public void setUserAttempt(int userAttempt) {
		this.userAttempt = userAttempt;
	}
	
	
}
