package com.vico.license.service;

import java.util.List;

import com.vico.license.pojo.DataTableRequest;
import com.vico.license.pojo.User;
import com.vico.license.pojo.UserByPage;

public interface UserService {
	
	public List<User> SelectAllUsers();

	public int addUser(User user);
	
	public UserByPage getUserByPage(DataTableRequest request);

	public int modifyUserByID(User user);

	public int userLogin(User user);

	public String createToken(String username);
	
}