package service;

import dto.User;

public interface IUserManager {
	
	public User authenticate(String login, String pwd);

}
