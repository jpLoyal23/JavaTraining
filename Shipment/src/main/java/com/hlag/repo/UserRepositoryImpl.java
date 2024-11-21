package com.hlag.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.hlag.model.User;

public class UserRepositoryImpl implements UserRepository {

	private static UserRepositoryImpl userRepositoryImpl;

	private List<User> users = new ArrayList<>();

	private UserRepositoryImpl() {
	}

	public static UserRepositoryImpl getInstance() {
		synchronized (UserRepositoryImpl.class) {
			if (userRepositoryImpl == null) {
				userRepositoryImpl = new UserRepositoryImpl();
			}
		}
		return userRepositoryImpl;

	}
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> getUser(String userId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<List<User>> getUsers() {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public User updateUser(String id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		
		Runnable run = () -> {
			UserRepositoryImpl userRepositoryImpl = UserRepositoryImpl.getInstance();
			System.out.println(userRepositoryImpl.hashCode());
			
		};

		Thread t = new Thread(run);
		t.start();
		Thread t2 = new Thread(run);
		t2.start();
		Thread t3 = new Thread(run);
		t3.start();
	}

	

}
