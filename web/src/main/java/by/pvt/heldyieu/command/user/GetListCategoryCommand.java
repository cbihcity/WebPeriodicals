package by.pvt.heldyieu.command.user;

import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.enums.CategoryType;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		CategoryType[] listOfCategories = CategoryType.values();
			if (listOfCategories.length!=0) {
				request.setAttribute(LIST, listOfCategories);
				resultPage =  addMagazinePage;
			} else {
				request.setAttribute(ERROR_MESSAGE, LIST_CATEGORY_TYPES_MAGAZINES_EMPTY);
	        	resultPage =  errorPage;
			}
		return resultPage;
	}

}
