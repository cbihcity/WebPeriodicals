package by.pvt.heldyieu.user;

import by.pvt.heldyieu.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
	 void addUser(User user) throws SQLException;
	
	 User getUser(Integer id) throws SQLException;
	
	 void updateUser(User user) throws SQLException;
	
	 boolean deleteUser(Integer id) throws SQLException;
	
	 List<User> getAllUsers() throws SQLException;
	
	 User findUserByEmail(String email, String pass) throws SQLException;
}
