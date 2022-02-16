package br.com.everymind.OliveiraTrade.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.everymind.OliveiraTrade.entity.User;
import br.com.everymind.OliveiraTrade.repository.UserRepository;

@Service
public class UserService {

//	@Autowired
//	private UserRepository userRepository;
	
	final UserRepository userRepository;
	/**
	 * INJEÇÃO DE DEPENDÊNCIAS VIA CONSTRUTOR.
	 * @param usuarioRepository
	 */
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Optional<User> findById(UUID id) {
		return userRepository.findById(id);
	}
	
	@Transactional
	public User save(User user) {
		return userRepository.save(user);
	}

	public boolean existsUsername(String user) {
		return userRepository.existsByUsername(user);
	}

	public boolean existsCpf(String cpf) {
		return userRepository.existsByCpf(cpf);
	}

	public boolean existsEmail(String email) {
		return userRepository.existsByEmail(email);
	}

		public List<User> findAll() {
		return userRepository.findAll();
	}
	
}
