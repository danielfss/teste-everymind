package br.com.everymind.OliveiraTrade.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.everymind.OliveiraTrade.entity.User;
import br.com.everymind.OliveiraTrade.service.UserService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/")
public class UserController {
	
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@PostMapping("/sign-up")
	public ResponseEntity<Object> saveUser(@RequestBody User user) {
		if (userService.existsUsername(user.getUsername())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Esse nome de usuário já está sendo utilizado.");
		}
		if (userService.existsCpf(user.getCpf())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Esse CPF já foi cadastrado.");
		}
		if (userService.existsEmail(user.getEmail())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Esse e-mail já está sendo utilizado.");
		}

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setUsername(user.getUsername());
		user.setPassword(encoder.encode(user.getPassword()));
		user.setFullName(user.getFullName());
		user.setCpf(user.getCpf());
		user.setEmail(user.getEmail());
		user.setBirthDate(user.getBirthDate());
		user.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));

	}

	@GetMapping("user")
	public ResponseEntity<List<User>> findAllUsers() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
	}
	
}
