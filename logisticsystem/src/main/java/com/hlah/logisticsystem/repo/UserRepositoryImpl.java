package com.hlah.logisticsystem.repo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import com.hlag.test.User;
import com.hlag.test.exception.InvalidEmailFormatException;
import com.hlag.test.exception.InvalidMobileFormatException;

public class UserRepositoryImpl implements UserRepository{
	
	private static UserRepositoryImpl userRepositoryImpl;

	// private List<User> users = new ArrayList<>();
	// private List<User> users = new LinkedList<>();

	private Set<User> users = new HashSet();

	private UserRepositoryImpl() {
	}

	public static UserRepositoryImpl getInstance() {
		if (userRepositoryImpl == null) {
			userRepositoryImpl = new UserRepositoryImpl();
		}
		return userRepositoryImpl;

	}

	@Override
	public User addUser(User user) {
		boolean result = users.add(user);
		if (result) {
			return user;
		}
		return null;
	}

	@Override
	public Optional<User> getUserById(String id) {
		UUID uuid = UUID.fromString(id);

		/*
		 * for (User user : users) { if (user.getId().equals(uuid)) { return
		 * Optional.of(user); } }
		 */
		// Atomic Reference

		/*	AtomicReference<User> atomicRef = new AtomicReference<>();
			Consumer<User> consumer = e -> {
				if (e.getId().toString().equals(id)) {
					atomicRef.set(e);
				}
			};
			users.forEach(consumer);
			return Optional.ofNullable(atomicRef.get());*/
		// stram api concept
		return users.stream().filter(user -> user.getId().toString().equals(id)).findFirst();
	}
	// array list and linkedList
	/*	@Override
		public Optional<List<User>> getUsers() {
			if (users.isEmpty()) {
				return Optional.empty();
			} else {
				return Optional.of(users);
			}
		}*/

	// HashSet
	@Override
	public Optional<List<User>> getUsers() {
		if (users.isEmpty()) {
			return Optional.empty();
		} else {
			return Optional.of(new ArrayList<>(users));
		}
	}

	@Override
	public void deleteUser(String id) {
		Optional<User> userOpt = getUserById(id);
		if (userOpt.isPresent()) {
			users.remove(userOpt.get());
			System.out.println("User with ID " + id + " deleted.");
		} else {
			System.out.println("User with ID " + id + " not found.");
		}
	}

	// array list and linkedList
	/*	@Override
		public User updateUser(String id, User updatedUser) throws InvalidEmailFormatException, InvalidMobileFormatException {
			Optional<User> existUset = getUserById(id);
			if (existUset.isPresent()) {
				User user = existUset.get();
				int index = users.indexOf(user);
				users.add(index, updatedUser);
				return updatedUser;
			}
			return updatedUser;
	
		}*/

	// HashSet
	@Override
	public User updateUser(String id, User updatedUser) throws InvalidEmailFormatException, InvalidMobileFormatException {
		Optional<User> existUset = getUserById(id);
		if (existUset.isPresent()) {
			User user = existUset.get();
			users.remove(user);
			users.add(updatedUser);
			return updatedUser;
		}
		return updatedUser;

	}

}
