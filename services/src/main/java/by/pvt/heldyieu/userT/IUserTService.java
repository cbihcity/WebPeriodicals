package by.pvt.heldyieu.userT;

import by.pvt.heldyieu.entity.UserT;
import by.pvt.heldyieu.exception.DaoException;

import java.util.List;

public interface IUserTService {
	 void addUserT(UserT userT) throws DaoException;
	
	 UserT getUserT(Integer id) throws DaoException;
	
	 void updateUserT(UserT user) throws DaoException;
	
	 boolean deleteUserT(Integer id) throws DaoException;
	
	 List<UserT> getAllUsersT() throws DaoException;
}
