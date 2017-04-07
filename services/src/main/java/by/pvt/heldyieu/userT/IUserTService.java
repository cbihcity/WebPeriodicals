package by.pvt.heldyieu.userT;

import by.pvt.heldyieu.entity.UserT;

import java.sql.SQLException;
import java.util.List;

public interface IUserTService {
	 void addUserT(UserT userT) throws SQLException;
	
	 UserT getUserT(Integer id) throws SQLException;
	
	 void updateUserT(UserT user) throws SQLException;
	
	 boolean deleteUserT(Integer id) throws SQLException;
	
	 List<UserT> getAllUsersT() throws SQLException;
}
