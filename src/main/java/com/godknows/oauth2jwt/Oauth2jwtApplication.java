package com.godknows.oauth2jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Oauth2jwtApplication implements CommandLineRunner{
	
	/* for test purpose injected passwrodEncoder and 
	 * also implemented CommandLineRunner so we can try and
	 * test password encript the password '123456'
	 * and add the hash password to the sql tb_user table
	 * Gonna delete this after test succesfully (next commit)
	 */
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(Oauth2jwtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("ENCODE = " + passwordEncoder.encode("123456"));
		
		//this is how password tests are made:
		boolean result1 = passwordEncoder.matches("123456", "$2a$10$mw7stpbfKWYIrI..FzovYOV2GgA/sTzBJ7tTg.9h4D8YsF20noiP2");
		boolean result2 = passwordEncoder.matches("123456789", "$2a$10$mw7stpbfKWYIrI..FzovYOV2GgA/sTzBJ7tTg.9h4D8YsF20noiP2");
		System.out.println("RESULTADO 1 =" + result1);
		System.out.println("RESULTADO 2 =" + result2);
		
	}

}
