package by.pvt.heldyieu.subscription;

import by.pvt.heldyieu.entity.Subscription;

import java.sql.SQLException;
import java.util.List;

public interface ISubscriptionService {
	 Subscription addSubscription(Subscription subscription) throws Exception;
	
	 Subscription getSubscription(Integer id) throws SQLException;
	
	 void updateSubscription(Subscription subscription) throws SQLException;
	
	 boolean deleteSubscription(Integer id) throws SQLException;
	
	 List<Subscription> getAllSubscriptions() throws SQLException;
	
	 List<Subscription> findSubscriptionByEmail(String email) throws SQLException;
}
