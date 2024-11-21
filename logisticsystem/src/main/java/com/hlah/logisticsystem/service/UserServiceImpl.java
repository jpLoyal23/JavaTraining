package com.hlah.logisticsystem.service;

import java.util.List;
import java.util.Optional;

import com.hlag.test.User;
import com.hlag.test.exception.InvalidEmailFormatException;
import com.hlag.test.exception.InvalidMobileFormatException;
import com.hlah.logisticsystem.repo.UserRepository;
import com.hlah.logisticsystem.repo.UserRepositoryImpl;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository = UserRepositoryImpl.getInstance();
	private static UserServiceImpl userServiceImpl;

	private UserServiceImpl() {
	}

	public static UserServiceImpl getInstance() {
		if (userServiceImpl == null) {
			userServiceImpl = new UserServiceImpl();
		}
		return userServiceImpl;
	}

	@Override
	public User addUser(User user) {
		return userRepository.addUser(user);
	}

	@Override
	public Optional<User> getUserById(String id) {
		return userRepository.getUserById(id);
	}

	@Override
	public Optional<List<User>> getUsers() {
		return userRepository.getUsers();
	}

	@Override
	public void deleteUser(String id) {
		userRepository.deleteUser(id);
	}

	@Override
	public User updateUser(String id, User user) throws InvalidEmailFormatException, InvalidMobileFormatException {
		return userRepository.updateUser(id, user);
	}

}
