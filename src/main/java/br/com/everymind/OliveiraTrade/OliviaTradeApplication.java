package br.com.everymind.OliveiraTrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class OliviaTradeApplication {

	public static void main(String[] args) {
		SpringApplication.run(OliviaTradeApplication.class, args);
		System.out.print(new BCryptPasswordEncoder().encode("12345678"));
	}

}
