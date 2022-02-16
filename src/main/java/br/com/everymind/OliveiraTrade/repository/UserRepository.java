package br.com.everymind.OliveiraTrade.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.everymind.OliveiraTrade.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

	User findByUsername(String username);
	
	boolean existsByUsername(String username);
	boolean existsByCpf(String cpf);
	boolean existsByEmail(String email);
	
}
