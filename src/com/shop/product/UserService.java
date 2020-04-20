package com.shop.product;

public interface UserService {
	
	User getUser(String username);
	
	public void saveUser(User user);
}
