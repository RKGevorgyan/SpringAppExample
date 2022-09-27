package ru.stc.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.stc.springbootdemo.dao.UserRepository;
import ru.stc.springbootdemo.model.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	private UserRepository repository;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Autowired
	public void setRepository(UserRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public User create(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return  repository.save(user);
	}

	public User findById(Long id) {
		return repository.findById(id).orElse(new User());
	}

	public List<User> findAll () {
		return repository.findAll();
	}

	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public boolean existById(Long id) {
		return repository.existsById(id);
	}
}
