package by.pvt.heldyieu.userT;

import by.pvt.heldyieu.entity.User;
import by.pvt.heldyieu.entity.UserT;
import by.pvt.heldyieu.implementation.UserTDAOImpl;
import by.pvt.heldyieu.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.sql.SQLException;
import java.util.List;

public class UserTServiceImpl implements IUserTService {
	private static final Logger LOGGER = Logger.getLogger(UserTServiceImpl.class);
	
	private UserTDAOImpl userTDao;
	private static UserTServiceImpl INSTANCE = null;
	

	private UserTServiceImpl() {
		LOGGER.info("Create new UserDAOImpl entity");
		userTDao = (UserTDAOImpl) UserTDAOImpl.getInstance();
	}
	
	public static UserTServiceImpl getInstance(){
		LOGGER.info("Getting userservice entity");
		if (INSTANCE == null) {
			INSTANCE = new UserTServiceImpl();
		} 
		return INSTANCE;
	}
	@Override
	public void addUserT(UserT userT) throws SQLException {
		LOGGER.info("Try to add new user to database");

		Session session = HibernateUtil.getInstance().getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			userTDao.create(userT);
			transaction.commit();
		} catch (Exception e){
			transaction.rollback();
		}
    }

	@Override
	public UserT getUserT(Integer id) throws SQLException {
		UserT userT = null;
		Session session = HibernateUtil.getInstance().getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			userT = userTDao.readById(id);
			transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
			LOGGER.error(e);
		}
		return userT;
    }
	@Override
	public void updateUserT(UserT userT) throws SQLException {
		Session session = HibernateUtil.getInstance().getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			userTDao.update(userT);
			transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
		}
    }
	@Override
	public boolean deleteUserT(Integer id) throws SQLException {
		boolean result = false;
		Session session = HibernateUtil.getInstance().getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			userTDao.delete(id);
			transaction.commit();
			result = true;
		}
		catch (Exception e) {
			transaction.rollback();
		}
		return result;
    }

	@Override
	public List<UserT> getAllUsersT() throws SQLException {
        List<UserT> users = null;
        Session session = HibernateUtil.getInstance().getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            users = userTDao.getAll();
            transaction.commit();
        }
        catch (Exception e) {
            transaction.rollback();
        }
        return users;
    }

}
