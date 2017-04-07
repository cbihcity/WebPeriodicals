package by.pvt.heldyieu.category;

import by.pvt.heldyieu.entity.CategoryType;
import by.pvt.heldyieu.entity.Magazine;
import by.pvt.heldyieu.implementation.CategoryTypeDAOImpl;
import by.pvt.heldyieu.implementation.MagazineDAOImpl;
import by.pvt.heldyieu.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
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
	public void addCategoryType(CategoryType categoryType) throws Exception {
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
	public CategoryType getCategoryType(Integer id) throws SQLException {
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
	public void updateCategoryType(CategoryType categoryType) throws SQLException {
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
	public boolean deleteCategoryType(Integer id) throws SQLException  {
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
	public List<CategoryType> getAllCategoryType() throws SQLException {
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
	public CategoryType findCategoryByName(String name) throws SQLException {
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
