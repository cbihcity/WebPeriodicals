package by.pvt.heldyieu.category;

import by.pvt.heldyieu.entity.CategoryType;
import by.pvt.heldyieu.exception.DaoException;
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
        try {
            categoryTypeDAO.create(categoryType);
        } catch (Exception e){
            throw new DaoException();
        }
    }

    @Override
    public CategoryType getCategoryType(Integer id) throws DaoException {
        CategoryType categoryType = null;
        try {
            categoryType = categoryTypeDAO.readById(id);
        }
        catch (Exception e) {
            throw new DaoException();
        }
        return categoryType;
    }

    @Override
    public void updateCategoryType(CategoryType categoryType) throws DaoException {
        try {
            categoryTypeDAO.update(categoryType);
        }
        catch (Exception e) {
            throw new DaoException();
        }
    }

    @Override
    public boolean deleteCategoryType(Integer id) throws DaoException  {
        boolean result = false;
        try {
            result = categoryTypeDAO.delete(id);
        }
        catch (Exception e) {
            throw new DaoException();
        }
        return result;
    }

    @Override
    public List<CategoryType> getAllCategoryType() throws DaoException {
        List<CategoryType> categoryTypes = null;
        try {
            categoryTypes = categoryTypeDAO.getAll();
        }
        catch (Exception e) {
            throw new DaoException();
        }
        return categoryTypes;
    }

    @Override
    public CategoryType findCategoryByName(String name) throws DaoException {
        CategoryType categoryType = null;
        try {
            categoryType = categoryTypeDAO.findCategoryByName(name);
        } catch (Exception e){
            throw new DaoException();
        }
        return categoryType;
    }
}
