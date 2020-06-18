package dao;

import java.sql.SQLException;

import model.User;

public interface UserDaoInterface {
	int signUp(User user);
	boolean loginUser(User user);
}