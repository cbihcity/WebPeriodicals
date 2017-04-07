package by.pvt.heldyieu.subscription.type;

import by.pvt.heldyieu.exceptions.DaoException;
import by.pvt.heldyieu.implementation.SubscriptionTypeDAOImpl;
import by.pvt.heldyieu.entity.SubscriptionType;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class SubscriptionTypeServiceImpl implements ISubscriptionTypeService{
	
	private static final Logger LOGGER = Logger.getLogger(SubscriptionTypeServiceImpl.class);
	private SubscriptionTypeDAOImpl subscriptionTypeDao;
	private static SubscriptionTypeServiceImpl INSTANCE = null;
	
	
	private SubscriptionTypeServiceImpl() {
		LOGGER.info("Create new SubscriptionTypeDAOImpl entity");
		subscriptionTypeDao = SubscriptionTypeDAOImpl.getInstance();
	}
	
	public static SubscriptionTypeServiceImpl getInstance(){
		LOGGER.info("Getting SubscriptionTypeService entity");
		if (INSTANCE == null) {
			INSTANCE = new SubscriptionTypeServiceImpl();
		} 
		return INSTANCE;
	}
	@Override
	public SubscriptionType addSubscriptionType(SubscriptionType subscriptionType) throws DaoException {
		LOGGER.info("Try to add new SubscriptionType to database");
		return subscriptionTypeDao.create(subscriptionType);
    }
	@Override
	public SubscriptionType getSubscriptionType(Integer id) throws DaoException {
		LOGGER.info("Try to get SubscriptionType by Id");
		return subscriptionTypeDao.readById(id);
    }
	@Override
	public void updateSubscriptionType(SubscriptionType subscriptionType) throws DaoException {
		LOGGER.info("Try to update SubscriptionType");
		subscriptionTypeDao.update(subscriptionType);
    }
	@Override
	public boolean deleteSubscriptionType(Integer id) throws DaoException {
		LOGGER.info("Try to delete SubscriptionType");
		try {
			return subscriptionTypeDao.delete(id);
		} catch (DaoException e) {
			throw new DaoException(e.getMessage());
		}
    }
	@Override
	public List<SubscriptionType> getAllSubscriptionTypes() throws DaoException {
		LOGGER.info("Try to get all SubscriptionTypes");
		return subscriptionTypeDao.getAll();
    }
	@Override
	public SubscriptionType findSubscriptionTypeByName(String name) throws DaoException {
		LOGGER.info("Try to find SubscriptionType by name");
		return subscriptionTypeDao.findSubscriptionTypeByName(name);
    }
	
}
