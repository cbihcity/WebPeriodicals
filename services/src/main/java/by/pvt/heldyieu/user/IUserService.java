package by.pvt.heldyieu.user;

import by.pvt.heldyieu.entity.User;
import by.pvt.heldyieu.exception.DaoException;

import java.util.List;

public interface IUserService {
	 void addUser(User user) throws DaoException;
	
	 User getUser(Integer id) throws DaoException;
	
	 void updateUser(User user) throws DaoException;
	
	 boolean deleteUser(Integer id) throws DaoException;
	
	 List<User> getAllUsers() throws DaoException;
	
	 User findUserByEmail(String email, String pass) throws DaoException;
}
