package com.hlag.service;

import java.util.List;
import java.util.Optional;

import com.hlag.model.User;

public interface UserService {

	public User addUser(User user);

	public Optional<User> getUser(String userId);

	public Optional<List<User>> getUsers();

	public void deleteUser(String userId);

	public User updateUser(String id, User user);

}
