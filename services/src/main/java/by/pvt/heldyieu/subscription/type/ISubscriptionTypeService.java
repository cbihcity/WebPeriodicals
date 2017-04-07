package by.pvt.heldyieu.subscription.type;

import by.pvt.heldyieu.entity.SubscriptionType;
import by.pvt.heldyieu.exception.DaoException;

import java.util.List;

public interface ISubscriptionTypeService {
	 SubscriptionType addSubscriptionType(SubscriptionType subscriptionType) throws DaoException;
	
	 SubscriptionType getSubscriptionType(Integer id) throws DaoException;
	
	 void updateSubscriptionType(SubscriptionType subscriptionType) throws DaoException;
	
	 boolean deleteSubscriptionType(Integer id) throws DaoException;
	
	 List<SubscriptionType> getAllSubscriptionTypes() throws DaoException;
	
	 SubscriptionType findSubscriptionTypeByName(String name) throws DaoException;
}
