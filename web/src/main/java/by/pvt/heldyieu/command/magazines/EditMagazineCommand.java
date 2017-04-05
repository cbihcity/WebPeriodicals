package by.pvt.heldyieu.command.magazines;

import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.Magazine;
import by.pvt.heldyieu.enums.CategoryType;
import by.pvt.heldyieu.magazine.MagazineServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class EditMagazineCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(EditMagazineCommand.class);
	private MagazineServiceImpl magazineServiceImpl;
    private String errorPage;
    private String sucessPage;
    private String resultPage;
	
	public EditMagazineCommand() {
		LOGGER.info(INITIALIZING_EDIT_MAGAZINE_COMMAND);
		sucessPage = resmanager.getProperty(SUCESS_PAGE);
		errorPage = resmanager.getProperty(ERROR_PAGE);
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		magazineServiceImpl = MagazineServiceImpl.getInstance();
		if (!request.getParameter(NAME).equals("")
				&& !request.getParameter(TYPE).equals("")
				&& !request.getParameter(PRICE).equals("")) {
			try {
				Magazine mag = new Magazine();
				mag.setId(Integer.valueOf(request.getParameter(MAG_ID)));
				mag.setName(request.getParameter(NAME));
				mag.setType(CategoryType.valueOf(request.getParameter(TYPE)));
				mag.setPrice(Double.valueOf(request.getParameter(PRICE)));
				magazineServiceImpl.updateMagazine(mag);
					request.setAttribute(SUCCESS_MESSAGE, MAGAZINE_EDIT_SUCCESS);
					resultPage =  sucessPage;
			} catch (SQLException e) {
					request.setAttribute(ERROR_MESSAGE,
							SQLEXCEPTION_AT_EDIT_MAGAZINE_COMMAND);
					resultPage = errorPage;
				}
		} else {
			request.setAttribute(ERROR_MESSAGE,
					PLEASE_INSERT_ALL_FIELDS);
			resultPage = errorPage;
		}
		return resultPage;
	}
}
