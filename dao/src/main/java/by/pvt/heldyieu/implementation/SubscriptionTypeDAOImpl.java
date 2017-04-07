package by.pvt.heldyieu.implementation;

import by.pvt.heldyieu.AbstractDAO;
import by.pvt.heldyieu.entity.SubscriptionType;
import by.pvt.heldyieu.exception.InvalidValueException;
import by.pvt.heldyieu.factory.DaoFactory;
import org.apache.log4j.Logger;

public class SubscriptionTypeDAOImpl extends AbstractDAO<SubscriptionType, Integer> {
	
	private static final Logger LOGGER = Logger.getLogger(SubscriptionTypeDAOImpl.class);
	private static SubscriptionTypeDAOImpl INSTANCE;
	
	public SubscriptionTypeDAOImpl() {
		super(SubscriptionType.class);
		LOGGER.info("Initialize resource for SubscriptionTypeDAOImpl and connection to database");
	}
	
	public static SubscriptionTypeDAOImpl getInstance(){
		if (INSTANCE == null) {
			try {
				INSTANCE = (SubscriptionTypeDAOImpl) new DaoFactory().createDao("subscriptionTypeDao");
			} catch (InvalidValueException e) {
				LOGGER.error(e.getMessage());
			}
		}
		return INSTANCE;
	}



	public SubscriptionType findSubscriptionTypeByName(String name) {
//		LOGGER.info("Try to find SubscriptionType by name " + name);
		SubscriptionType subscriptionType = null;
//		ResultSet result = null;
//		try(PreparedStatement statement = connect.prepareStatement(getFindNameQuery())) {
//			statement.setString(1, name);
//			result = statement.executeQuery();
//			subscriptionType = parseResultSet(result);
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
		return subscriptionType;
	}
	
}
