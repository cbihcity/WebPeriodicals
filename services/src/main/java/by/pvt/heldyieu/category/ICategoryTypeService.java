package by.pvt.heldyieu.category;

import by.pvt.heldyieu.entity.CategoryType;
import by.pvt.heldyieu.entity.Magazine;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryTypeService {
	
	 void addCategoryType(CategoryType categoryType) throws Exception;
	
	 CategoryType getCategoryType(Integer id) throws SQLException;
	
	 void updateCategoryType(CategoryType categoryType) throws SQLException;
	
	 boolean deleteCategoryType(Integer id) throws SQLException;
	
	 List<CategoryType> getAllCategoryType() throws SQLException;

	 CategoryType findCategoryByName(String name) throws SQLException;
}