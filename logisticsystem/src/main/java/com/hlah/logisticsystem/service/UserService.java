package com.hlah.logisticsystem.service;

import java.util.List;
import java.util.Optional;

import com.hlag.test.User;
import com.hlag.test.exception.InvalidEmailFormatException;
import com.hlag.test.exception.InvalidMobileFormatException;

public interface UserService {

	public User addUser(User user);

	public Optional<User> getUserById(String id);

	public Optional<List<User>> getUsers();

	public void deleteUser(String id);

	public User updateUser(String id, User user) throws InvalidEmailFormatException, InvalidMobileFormatException;

}
