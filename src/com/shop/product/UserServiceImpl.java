package com.shop.product;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserServiceImpl implements UserService{

	private final Map<String, User> users = new ConcurrentHashMap<String, User>();
	
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return users.get(username);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		users.put(user.getUsername(), user);
	}

}
