package by.pvt.heldyieu.subscription;

import by.pvt.heldyieu.entity.Subscription;
import by.pvt.heldyieu.exception.DaoException;

import java.util.List;

public interface ISubscriptionService {
	 Subscription addSubscription(Subscription subscription) throws DaoException;
	
	 Subscription getSubscription(Integer id) throws DaoException;
	
	 void updateSubscription(Subscription subscription) throws DaoException;
	
	 boolean deleteSubscription(Integer id) throws DaoException;
	
	 List<Subscription> getAllSubscriptions() throws DaoException;
	
	 List<Subscription> findSubscriptionByEmail(String email) throws DaoException;
}
