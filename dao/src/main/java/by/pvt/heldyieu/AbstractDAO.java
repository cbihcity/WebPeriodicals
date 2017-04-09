package by.pvt.heldyieu;

import by.pvt.heldyieu.exception.DaoException;
import by.pvt.heldyieu.interfaces.Constants;
import by.pvt.heldyieu.interfaces.GenericDAO;
import by.pvt.heldyieu.interfaces.Identified;
import by.pvt.heldyieu.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractDAO<T extends Identified, PK extends Number> implements GenericDAO<T, PK>, Constants{
	private static final Logger LOGGER = Logger.getLogger(AbstractDAO.class);
    protected static HibernateUtil util = HibernateUtil.getInstance();
    private Class persistentClass;
	
	public AbstractDAO() {
		super();
	}

	public AbstractDAO(Class persistentClass) {
            this.persistentClass = persistentClass;
    }
	
    @Override
    public T create(T object) throws DaoException {
        LOGGER.info("Try to create new user in USER database");
        Session session = util.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
        }
        catch(HibernateException e) {
            transaction.rollback();
            throw new DaoException();
        }
        finally {
            util.releaseSession(session);
        }
        return object;
    }

    @Override
    public T readById(Number key) throws DaoException {
    	LOGGER.info("Find object by id and return it");
        T tempEntity = null;
        Session session = util.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            tempEntity = (T)session.get(persistentClass, key);
            transaction.commit();
        }
        catch(HibernateException e){
            LOGGER.error("Error was thrown in DAO: " + e);
            transaction.rollback();
            throw new DaoException();
        }
        finally {
            util.releaseSession(session);
        }
        return tempEntity;
    }

    @Override
    public void update(T object) throws DaoException {
        Session session = util.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(object);
            transaction.commit();
        }
        catch(HibernateException e) {
            transaction.rollback();
            throw new DaoException();
        }
        finally {
            util.releaseSession(session);
        }
    }

    @Override
    public boolean delete(Number key) throws DaoException {
    	boolean result = false;
        Session session = HibernateUtil.getInstance().getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            T entity = (T) session.get(persistentClass, key);
            session.delete(entity);
            transaction.commit();
            result = true;
        }
        catch(HibernateException e){
            transaction.rollback();
            throw new DaoException();
        }
        finally {
            util.releaseSession(session);
        }
        return result;
    }

    @Override
    public List<T> getAll() throws DaoException{
        List<T> list = new ArrayList<T>();
        Session session = HibernateUtil.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Criteria criteria = session.createCriteria(persistentClass);
            list = criteria.list();
            transaction.commit();
        }
        catch(HibernateException e){
            transaction.rollback();
            throw new DaoException();
        }
        finally {
            util.releaseSession(session);
        }
		return list;
    }
}
