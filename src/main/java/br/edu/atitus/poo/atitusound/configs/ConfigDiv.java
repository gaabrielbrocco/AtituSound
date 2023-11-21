package br.edu.atitus.poo.atitusound.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ConfigDiv {

	@Bean
	public PasswordEncoder getpassEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
