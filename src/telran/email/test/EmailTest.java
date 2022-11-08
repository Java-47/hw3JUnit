package telran.email.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.user.model.User;

class EmailTest {
	User user;
	String email = "peter@gmail.com";
	String password = "123456Ab!";

	@BeforeEach
	void setUp() throws Exception {
		user = new User(email, password);
	}

	@Test
	void testValidEmail() {
		String validEmail = "qwerty123@gmail.com";
		user.setEmail(validEmail);
		assertEquals(validEmail, user.getEmail());
	}
	@Test
	void testEmailMinTwoSymbolsAfterDot (){
		String inValidMail = "qwerty123@gmail.c";
		user.setEmail(inValidMail);
		assertEquals(email, user.getEmail());
	}
	@Test
	void testEmailNotContainAt (){
		String inValidMail = "qwerty123gmail.com";
		user.setEmail(inValidMail);
		assertEquals(email, user.getEmail());
	}
	@Test
	void testEmailAnotherSymbol (){
		String inValidMail = "qw^erty123@gmail.com";
		user.setEmail(inValidMail);
		assertEquals(email, user.getEmail());
	}
	@Test
	void testEmailToManyAt (){
		String inValidMail = "qwerty1@23@gmail.com";
		user.setEmail(inValidMail);
		assertEquals(email, user.getEmail());
	}
	@Test
	void testEmailDotAfterAt (){
		String inValidMail = "qwert.y1@23gmailcom";
		user.setEmail(inValidMail);
		assertEquals(email, user.getEmail());
	}
	
	
}