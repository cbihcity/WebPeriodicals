package by.pvt.heldyieu.command.magazines;

import by.pvt.heldyieu.category.CategoryTypeServiceImpl;
import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.CategoryType;
import by.pvt.heldyieu.entity.Magazine;
import by.pvt.heldyieu.exceptions.DaoException;
import by.pvt.heldyieu.magazine.MagazineServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class AddMagazineCommand implements ServletCommand {
	
	private static final Logger LOGGER = Logger.getLogger(AddMagazineCommand.class);
    private String sucessPage = resmanager.getProperty(SUCESS_PAGE);
    private String errorPage = resmanager.getProperty(ERROR_PAGE);
    private String resultPage;
    
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		Magazine magazine = new Magazine();
		CategoryType categoryType = null;
		try {
			categoryType = CategoryTypeServiceImpl.getInstance().findCategoryByName(request.getParameter(TYPE));
		} catch (DaoException e) {
			e.printStackTrace();
		}
		if (!request.getParameter(NAME).equals("")
				&& !request.getParameter(TYPE).equals("")
				&& !request.getParameter(PRICE).equals("")) {
			magazine.setName(request.getParameter(NAME).trim());
			magazine.setCategoryType(categoryType);
			magazine.setPrice(Double
					.valueOf(request.getParameter(PRICE).trim()));
			try {
				MagazineServiceImpl.getInstance().addMagazine(magazine);
				request.setAttribute(SUCCESS_MESSAGE, MAGAZINE_ADD_SUCCESS);
				resultPage = sucessPage;
			} catch (DaoException e) {
				LOGGER.error(SQLEXCEPTION_AT_ADD_MAGAZINE_COMMAND);
				request.setAttribute(ERROR_MESSAGE,
						SQLEXCEPTION_AT_ADD_MAGAZINE_COMMAND);
				resultPage = errorPage;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute(ERROR_MESSAGE, PLEASE_INSERT_ALL_FIELDS);
			resultPage = errorPage;
		}
		return resultPage;
	}
}
