package by.pvt.heldyieu.user;

import by.pvt.heldyieu.entity.User;
import by.pvt.heldyieu.exception.DaoException;
import by.pvt.heldyieu.implementation.UserDAOImpl;
import by.pvt.heldyieu.utils.HibernateUtil;
import org.apache.log4j.Logger;
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
			userDao.create(user);
    }

	@Override
	public User getUser(Integer id) throws DaoException {
		User user = null;
		user = userDao.readById(id);
		return user;
    }
	@Override
	public void updateUser(User user) throws DaoException {
			userDao.update(user);
    }

	@Override
	public boolean deleteUser(Integer id) throws DaoException {
		boolean result = false;
		result = userDao.delete(id);
		return result;
    }

	@Override
	public List<User> getAllUsers() throws DaoException {
        List<User> users = null;
        users = userDao.getAll();
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
		finally {
            HibernateUtil.getInstance().releaseSession(session);
        }
		return user;
    }
}
