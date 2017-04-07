package by.pvt.heldyieu.command.user;

import by.pvt.heldyieu.category.CategoryTypeServiceImpl;
import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.CategoryType;
import by.pvt.heldyieu.exception.DaoException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetListCategoryCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(GetListCategoryCommand.class);
    private String addMagazinePage;
    private String errorPage;
    private String resultPage;
    
	public GetListCategoryCommand() {
		LOGGER.info(INITIALIZING_GET_LIST_CATEGORY_COMMAND);
		addMagazinePage = resmanager.getProperty(ADD_MAGAZINE_PAGE);
		errorPage = resmanager.getProperty(ERROR_PAGE);
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		List<CategoryType> categoryTypes = null;
		try {
			categoryTypes = CategoryTypeServiceImpl.getInstance().getAllCategoryType();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		if (categoryTypes.size()!=0) {
				request.setAttribute(LIST, categoryTypes);
				resultPage =  addMagazinePage;
			} else {
				request.setAttribute(ERROR_MESSAGE, LIST_CATEGORY_TYPES_MAGAZINES_EMPTY);
	        	resultPage =  errorPage;
			}
		return resultPage;
	}

}
