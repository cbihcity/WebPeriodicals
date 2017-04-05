package by.pvt.heldyieu.subscription.type;

import by.pvt.heldyieu.entity.SubscriptionType;

import java.sql.SQLException;
import java.util.List;

public interface ISubscriptionTypeService {
	 SubscriptionType addSubscriptionType(SubscriptionType subscriptionType) throws Exception;
	
	 SubscriptionType getSubscriptionType(Integer id) throws SQLException;
	
	 void updateSubscriptionType(SubscriptionType subscriptionType) throws SQLException;
	
	 boolean deleteSubscriptionType(Integer id) throws SQLException;
	
	 List<SubscriptionType> getAllSubscriptionTypes() throws SQLException;
	
	 SubscriptionType findSubscriptionTypeByName(String name) throws SQLException;
}
