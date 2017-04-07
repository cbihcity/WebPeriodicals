package by.pvt.heldyieu.user;

import by.pvt.heldyieu.entity.User;
import by.pvt.heldyieu.exception.DaoException;
import by.pvt.heldyieu.implementation.UserDAOImpl;
import by.pvt.heldyieu.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserServiceImpl implements IUserService{
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	
	private UserDAOImpl userDao;
	private static UserServiceImpl INSTANCE = null;
	

	private UserServiceImpl() {
		LOGGER.info("Create new UserDAOImpl entity");
		userDao = (UserDAOImpl) UserDAOImpl.getInstance();
	}
	
	public static UserServiceImpl getInstance(){
		LOGGER.info("Getting userservice entity");
		if (INSTANCE == null) {
			INSTANCE = new UserServiceImpl();
		} 
		return INSTANCE;
	}
	@Override
	public void addUser(User user) throws DaoException {
		LOGGER.info("Try to add new user to database");

		User us = null;

		Session session = HibernateUtil.getInstance().getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			userDao.create(user);

			transaction.commit();
		} catch (Exception e){
			transaction.rollback();
		}
    }

	@Override
	public User getUser(Integer id) throws DaoException {
		User user = null;
		Session session = HibernateUtil.getInstance().getSession();
        session.setCacheMode(CacheMode.IGNORE);
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			user = userDao.readById(id);
			transaction.commit();
			LOGGER.info(user);
		}
		catch (Exception e) {
			transaction.rollback();
			LOGGER.error(e);
		}
		return user;
    }
	@Override
	public void updateUser(User user) throws DaoException {
		Session session = HibernateUtil.getInstance().getSession();
        session.setCacheMode(CacheMode.IGNORE);
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			userDao.update(user);
			transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
            throw new DaoException();
		}
    }
	@Override
	public boolean deleteUser(Integer id) throws DaoException {
		boolean result = false;
		Session session = HibernateUtil.getInstance().getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			userDao.delete(id);
			transaction.commit();
			result = true;
		}
		catch (Exception e) {
			transaction.rollback();
		}
		return result;
    }

	@Override
	public List<User> getAllUsers() throws DaoException {
        List<User> users = null;
        Session session = HibernateUtil.getInstance().getSession();
        session.setCacheMode(CacheMode.IGNORE);
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            users = userDao.getAll();
            transaction.commit();
        }
        catch (Exception e) {
            transaction.rollback();
        }
        HibernateUtil.getInstance().releaseSession(session);

        return users;
    }
	@Override
	public User findUserByEmail(String email, String pass) throws DaoException {
		LOGGER.info("Try to find user by email");
		User user = null;
		Session session = HibernateUtil.getInstance().getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			user = userDao.findUserByEmailAndPass(email, pass);
			transaction.commit();
		} catch (Exception e){
			transaction.rollback();
		}
			return user;
    }
}
