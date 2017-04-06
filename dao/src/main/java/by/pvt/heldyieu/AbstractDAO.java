package by.pvt.heldyieu;

import by.pvt.heldyieu.interfaces.Constants;
import by.pvt.heldyieu.interfaces.GenericDAO;
import by.pvt.heldyieu.interfaces.Identified;
import by.pvt.heldyieu.utils.HibernateUtil;
import org.apache.log4j.Logger;

import org.hibernate.Criteria;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.sql.*;
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
    public T create(T object) throws Exception {
        LOGGER.info("Try to create new user in USER database");
        try {

            Session session = util.getSession();
            session.saveOrUpdate(object);
        }
        catch(HibernateException e) {

        }

        return object;
    }

    @Override
    public T readById(Number key) throws SQLException {
    	LOGGER.info("Find object by id and return it");
    	
        T tempEntity = null;
        try {
            Session session = util.getSession();
            tempEntity = (T)session.get(persistentClass, key);
        }
        catch(HibernateException e){
            LOGGER.error("Error was thrown in DAO: " + e);
        }
        return tempEntity;
    }

    @Override
    public void update(T object) throws SQLException {
        try {
            Session session = util.getSession();
            session.merge(object);
        }
        catch(HibernateException e) {
            LOGGER.error("Error was thrown in DAO: " + e);
        }
    }

    @Override
    public boolean delete(Number key) throws SQLException {
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
        }
        catch(IllegalArgumentException e){
            LOGGER.error("Error was thrown in DAO: " + e);
        }
        return result;
    }

    @Override
    public List<T> getAll() {
        List<T> list = new ArrayList<T>();
        try {
            Session session = util.getSession();
            Criteria criteria = session.createCriteria(persistentClass);
            list = criteria.list();
        }
        catch(HibernateException e){
            LOGGER.error("Error was thrown in DAO: " + e);
        }
		return list;
    }
}
