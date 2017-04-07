package by.pvt.heldyieu.category;
import by.pvt.heldyieu.entity.CategoryType;
import by.pvt.heldyieu.exception.DaoException;

import java.util.List;

public interface ICategoryTypeService {
	
	 void addCategoryType(CategoryType categoryType) throws DaoException;
	
	 CategoryType getCategoryType(Integer id) throws DaoException;
	
	 void updateCategoryType(CategoryType categoryType) throws DaoException;
	
	 boolean deleteCategoryType(Integer id) throws DaoException;
	
	 List<CategoryType> getAllCategoryType() throws DaoException;

	 CategoryType findCategoryByName(String name) throws DaoException;
}