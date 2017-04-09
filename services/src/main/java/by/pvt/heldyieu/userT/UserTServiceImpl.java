package by.pvt.heldyieu.userT;

import by.pvt.heldyieu.entity.UserT;
import by.pvt.heldyieu.exception.DaoException;
import by.pvt.heldyieu.implementation.UserTDAOImpl;
import by.pvt.heldyieu.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
    public void addUserT(UserT userT) throws DaoException {
        LOGGER.info("Try to add new user to database");
        try {
            userTDao.create(userT);
        } catch (Exception e){
            throw new DaoException();
        }
    }

    @Override
    public UserT getUserT(Integer id) throws DaoException {
        UserT userT = null;
        try {
            userT = userTDao.readById(id);
        }
        catch (Exception e) {
            throw new DaoException();
        }
        return userT;
    }
    @Override
    public void updateUserT(UserT userT) throws DaoException {
        try {
            userTDao.update(userT);
        }
        catch (Exception e) {
            throw new DaoException();
        }
    }
    @Override
    public boolean deleteUserT(Integer id) throws DaoException {
        boolean result = false;
        try {
            result = userTDao.delete(id);
        }
        catch (Exception e) {
            throw new DaoException();
        }
        return result;
    }

    @Override
    public List<UserT> getAllUsersT() throws DaoException {
        List<UserT> users = null;
        try {
            users = userTDao.getAll();
        }
        catch (Exception e) {
            throw new DaoException();
        }
        return users;
    }

}
