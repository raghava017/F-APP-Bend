package com.cigniti.foodApp.service;

import com.cigniti.foodApp.entity.User;
import com.cigniti.foodApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	@Override
	public void saveGuestUser(User user) {
		userRepo.save(user);
	}

	@Override
	public List<User> findAll() {
		List<User> users = userRepo.findAll();
		return users;
	}

	@Override
	public void save(User user) {
		userRepo.save(user);
	}

	@Override
	public User findByUserId(int id) {
		Optional<User> result = userRepo.findById(id);
		User user = null;
		if (result.isPresent()) {
			user = result.get();
		} else {
			throw new RuntimeException("Could not find by Id:" + id);
		}
		return user;
	}

	@Override
	public void deleteByUserId(int id) {
		userRepo.deleteUser(id);
	}

	@Override
	public List<User> findByEmailAndPassword(String email, String password) {
		List<User> users = userRepo.findAllByEmailAndPassword(email, password);
		return users;
	}

}