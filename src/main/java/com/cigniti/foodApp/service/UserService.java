package com.cigniti.foodApp.service;

import com.cigniti.foodApp.entity.User;

import java.util.List;

public interface UserService {

	public void saveGuestUser(User user);
	public List<User> findAll();
	public void save(User user);
	public User findByUserId(int id);
	public void deleteByUserId(int id);
	public List<User> findByEmailAndPassword(String email, String password);
}
