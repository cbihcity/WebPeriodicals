package by.pvt.heldyieu.category;

import by.pvt.heldyieu.entity.CategoryType;
import by.pvt.heldyieu.exceptions.DaoException;
import by.pvt.heldyieu.implementation.CategoryTypeDAOImpl;
import by.pvt.heldyieu.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class CategoryTypeServiceImpl implements ICategoryTypeService {
	private CategoryTypeDAOImpl categoryTypeDAO;
	private static CategoryTypeServiceImpl INSTANCE = null;
	
	private CategoryTypeServiceImpl() {
		categoryTypeDAO = CategoryTypeDAOImpl.getInstance();
	}
	
	public static CategoryTypeServiceImpl getInstance(){
		if (INSTANCE == null) {
			INSTANCE = new CategoryTypeServiceImpl();
		} 
		return INSTANCE;
	}
	
	@Override
	public void addCategoryType(CategoryType categoryType) throws DaoException {
		Session session = HibernateUtil.getInstance().getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			categoryTypeDAO.create(categoryType);
			transaction.commit();
		} catch (Exception e){
			transaction.rollback();
		}
    }
	
	@Override
	public CategoryType getCategoryType(Integer id) throws DaoException {
		CategoryType categoryType = null;
		Session session = HibernateUtil.getInstance().getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			categoryType = categoryTypeDAO.readById(id);
			transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
		}
		return categoryType;
    }
	
	@Override
	public void updateCategoryType(CategoryType categoryType) throws DaoException {
		Session session = HibernateUtil.getInstance().getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			categoryTypeDAO.update(categoryType);
			transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
		}
    }
	
	@Override
	public boolean deleteCategoryType(Integer id) throws DaoException  {
		boolean result = false;
		Session session = HibernateUtil.getInstance().getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			categoryTypeDAO.delete(id);
			transaction.commit();
			result = true;
		}
		catch (Exception e) {
			transaction.rollback();
		}
		return result;
    }
	
	@Override
	public List<CategoryType> getAllCategoryType() throws DaoException {
		List<CategoryType> categoryTypes = null;
		Session session = HibernateUtil.getInstance().getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			categoryTypes = categoryTypeDAO.getAll();
			transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
		}
		return categoryTypes;
    }

	@Override
	public CategoryType findCategoryByName(String name) throws DaoException {
		CategoryType categoryType = null;
		Session session = HibernateUtil.getInstance().getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			categoryType = categoryTypeDAO.findCategoryByName(name);
			transaction.commit();
		} catch (Exception e){
			transaction.rollback();
		}
		return categoryType;
	}
}
