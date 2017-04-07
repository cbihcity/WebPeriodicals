package by.pvt.heldyieu.implementation;

import by.pvt.heldyieu.AbstractDAO;
import by.pvt.heldyieu.entity.User;
import by.pvt.heldyieu.exception.InvalidValueException;
import by.pvt.heldyieu.factory.DaoFactory;
import by.pvt.heldyieu.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

public class UserDAOImpl extends AbstractDAO<User, Integer> {
	private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class);
	private static UserDAOImpl INSTANCE;
	
	public UserDAOImpl() {
		super(User.class);
		LOGGER.info("Initialize resource for UserDAOImpl and connection to database");
	}
	
	public static UserDAOImpl getInstance(){
		if (INSTANCE == null) {
			try {
				INSTANCE = (UserDAOImpl) new DaoFactory().createDao("userDao");
			} catch (InvalidValueException e) {
				LOGGER.error(e.getMessage());
			}
		}
		return INSTANCE;
	}



	public User findUserByEmail(String email) {
//		LOGGER.info("Try to find user by email " + email);
//		User user = null;
//		ResultSet result = null;
//		try(PreparedStatement statement = connect.prepareStatement(getFindEmailQuery())) {
//			statement.setString(1, email);
//			result = statement.executeQuery();
//			user = parseResultSet(result);
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
		return new User();
	}
	
	public User findUserByEmailAndPass(String email, String pass) {
		LOGGER.info("Try to find user by email " + email);
		User user;
        Session session = HibernateUtil.getInstance().getSession();
        Query query = session.createQuery("from User where email = :email and password = :pass");
        query.setParameter("email", email);
        query.setParameter("pass", pass);
        user = (User) query.uniqueResult();
		return user;
	}
}
