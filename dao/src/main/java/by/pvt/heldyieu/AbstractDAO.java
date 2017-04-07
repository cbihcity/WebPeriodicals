package by.pvt.heldyieu;

import by.pvt.heldyieu.exception.DaoException;
import by.pvt.heldyieu.interfaces.Constants;
import by.pvt.heldyieu.interfaces.GenericDAO;
import by.pvt.heldyieu.interfaces.Identified;
import by.pvt.heldyieu.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

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
        try {

            Session session = util.getSession();
            session.saveOrUpdate(object);
        }
        catch(HibernateException e) {
            throw new DaoException();
        }

        return object;
    }

    @Override
    public T readById(Number key) throws DaoException {
    	LOGGER.info("Find object by id and return it");
    	
        T tempEntity = null;
        try {
            Session session = util.getSession();
            tempEntity = (T)session.get(persistentClass, key);
        }
        catch(HibernateException e){
            LOGGER.error("Error was thrown in DAO: " + e);
            throw new DaoException();
        }
        return tempEntity;
    }

    @Override
    public void update(T object) throws DaoException {
        try {
            Session session = util.getSession();
            session.setCacheMode(CacheMode.IGNORE);
            session.update(object);
        }
        catch(HibernateException e) {
            LOGGER.error("Error was thrown in DAO: " + e);
            throw new DaoException();
        }
    }

    @Override
    public boolean delete(Number key) throws DaoException {
    	boolean result = false;
        try {
            Session session = util.getSession();
            T entity = (T) session.get(persistentClass, key);
            session.delete(entity);
            result = true;
        }
        catch(HibernateException e){
            //TODO исправить
            LOGGER.error("Error was thrown in DAO: " + e);
            throw new DaoException();
        }
        catch(IllegalArgumentException e){
            LOGGER.error("Error was thrown in DAO: " + e);
        }
        return result;
    }

    @Override
    public List<T> getAll() throws DaoException{
        List<T> list = new ArrayList<T>();
        try {
            Session session = util.getSession();
            session.setCacheMode(CacheMode.IGNORE);
            Criteria criteria = session.createCriteria(persistentClass);
            list = criteria.list();
        }
        catch(HibernateException e){
            LOGGER.error("Error was thrown in DAO: " + e);
            throw new DaoException();
        }
		return list;
    }
}
