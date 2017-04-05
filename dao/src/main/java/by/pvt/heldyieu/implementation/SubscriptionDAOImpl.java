package by.pvt.heldyieu.implementation;

import by.pvt.heldyieu.AbstractDAO;
import by.pvt.heldyieu.factory.DaoFactory;
import by.pvt.heldyieu.entity.Subscription;
import by.pvt.heldyieu.exception.InvalidValueException;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionDAOImpl extends AbstractDAO<Subscription, Integer>{
	
	private static final Logger LOGGER = Logger.getLogger(SubscriptionDAOImpl.class);
	private static SubscriptionDAOImpl INSTANCE;
	private UserDAOImpl userDao;
	private MagazineDAOImpl magazineDao;
	private SubscriptionTypeDAOImpl subscriptionTypeDao;
	
	public SubscriptionDAOImpl() {
		super(Subscription.class);
		LOGGER.info("Initialize resource for SubscriptionDAOImpl and connection to database");
		userDao = UserDAOImpl.getInstance();
		magazineDao = MagazineDAOImpl.getInstance();
		subscriptionTypeDao = SubscriptionTypeDAOImpl.getInstance();
	}

	public static SubscriptionDAOImpl getInstance(){
		if (INSTANCE == null) {
			try {
				INSTANCE = (SubscriptionDAOImpl) new DaoFactory().createDao("subscriptionDao");
			} catch (InvalidValueException e) {
				LOGGER.error(e.getMessage());
			}
		}
		return INSTANCE;
	}
	
	public List<Subscription> findSubscriptionByUser(String email) {
		List<Subscription> list = new ArrayList<Subscription>();
//		LOGGER.info("Try to find Subscription by user email " + email);
//		ResultSet result = null;
//
//		try(PreparedStatement statement = connect.prepareStatement(getFindQuery())) {
//			statement.setInt(1, userDao.findUserByEmail(email).getId());
//			result = statement.executeQuery();
//			list = parseResultSetList(result);
//		} catch (SQLException e) {
//			LOGGER.error(e.getMessage());
//			System.out.println(ERROR_SQL_EXECUTE);
//		}
//		 finally {
//				try {
//					result.close();
//				} catch (SQLException e) {
//					LOGGER.info(e.getMessage());
//					System.out.println(ERROR_CLOSING_RESULTSET);
//				}
//			}
		return list;
	}
	
}
