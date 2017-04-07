package by.pvt.heldyieu.subscription;

import by.pvt.heldyieu.exceptions.DaoException;
import by.pvt.heldyieu.implementation.SubscriptionDAOImpl;
import by.pvt.heldyieu.entity.Subscription;
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
	public Subscription addSubscription(Subscription subscription) throws DaoException {
		return subscriptionDao.create(subscription);
    }
	@Override
	public Subscription getSubscription(Integer id) throws DaoException {
		return subscriptionDao.readById(id);
    }
	@Override
	public void updateSubscription(Subscription subscription) throws DaoException {
		subscriptionDao.update(subscription);
    }
	@Override
	public boolean deleteSubscription(Integer id) throws DaoException {
		try {
			return subscriptionDao.delete(id);
		} catch (DaoException e) {
			throw new DaoException(e.getMessage());
		}
    }
	@Override
	public List<Subscription> getAllSubscriptions() throws DaoException {
		return subscriptionDao.getAll();
    }
	@Override
	public List<Subscription> findSubscriptionByEmail(String email) throws DaoException {
		return subscriptionDao.findSubscriptionByUser(email);
    }
}
