package com.beaconfire.personalProject.service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beaconfire.personalProject.daoImpl.UserDaoImpl;
import com.beaconfire.personalProject.domain.User;

@Component
public class UserService {

	private UserDaoImpl userDaoImpl;
	
	@Autowired
	public void setRegister(UserDaoImpl register) {
		this.userDaoImpl = register;
	}
	
	public User getUser(User user) {
		return userDaoImpl.getUser(user);
	}
	
	public int insertRegstration(User user) {
		return userDaoImpl.insertRegstration(user);
 	}
	
	@Transactional
	public List<User> getAllusers(){
		return userDaoImpl.getAllusers();
	}
	
	@Transactional
	public void updateUser(User user) {
		userDaoImpl.updateUser(user);
	}


	public void practiceLambda(){
		List<User> users= getAllusers();

		users.stream()
				.filter(x->x.getFirstName().toLowerCase(Locale.ROOT).startsWith("h"))
				.collect(Collectors.toMap(x->x.getUser_id(),x->x))
				.forEach((x,y)->System.out.println(x));
	}
}
