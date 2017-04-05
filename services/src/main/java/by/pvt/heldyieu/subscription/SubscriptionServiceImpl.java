package by.pvt.heldyieu.subscription;

import by.pvt.heldyieu.implementation.SubscriptionDAOImpl;
import by.pvt.heldyieu.entity.Subscription;

import java.sql.SQLException;
import java.util.List;

public class SubscriptionServiceImpl implements ISubscriptionService {

	private SubscriptionDAOImpl subscriptionDao;
	private static SubscriptionServiceImpl INSTANCE = null;
	

	private SubscriptionServiceImpl() {
		subscriptionDao = SubscriptionDAOImpl.getInstance();
	}
	
	public static SubscriptionServiceImpl getInstance(){
		if (INSTANCE == null) {
			INSTANCE = new SubscriptionServiceImpl();
		} 
		return INSTANCE;
	}
	@Override
	public Subscription addSubscription(Subscription subscription) throws Exception {
		return subscriptionDao.create(subscription);
    }
	@Override
	public Subscription getSubscription(Integer id) throws SQLException {
		return subscriptionDao.readById(id);
    }
	@Override
	public void updateSubscription(Subscription subscription) throws SQLException {
		subscriptionDao.update(subscription);
    }
	@Override
	public boolean deleteSubscription(Integer id) throws SQLException {
		try {
			return subscriptionDao.delete(id);
		} catch (Exception e) {
			throw new SQLException(e);
		}
    }
	@Override
	public List<Subscription> getAllSubscriptions() throws SQLException {
		return subscriptionDao.getAll();
    }
	@Override
	public List<Subscription> findSubscriptionByEmail(String email) throws SQLException {
		return subscriptionDao.findSubscriptionByUser(email);
    }
}
