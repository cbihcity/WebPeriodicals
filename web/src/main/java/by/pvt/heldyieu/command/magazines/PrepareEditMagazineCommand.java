package by.pvt.heldyieu.command.magazines;

import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.Magazine;
import by.pvt.heldyieu.enums.CategoryType;
import by.pvt.heldyieu.magazine.MagazineServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class PrepareEditMagazineCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(PrepareEditMagazineCommand.class);

	private MagazineServiceImpl magazineServiceImpl;
    private String errorPage;
    private String editMagPage;
    private String resultPage;
	
	public PrepareEditMagazineCommand() {
		LOGGER.info(INITIALIZING_PREPARE_EDIT_MAGAZINE_COMMAND);
		editMagPage = resmanager.getProperty(EDIT_MAG_PAGE);
		errorPage = resmanager.getProperty(ERROR_PAGE);
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		magazineServiceImpl = MagazineServiceImpl.getInstance();
			try {
				Magazine magazine = magazineServiceImpl.getMagazine(Integer.valueOf(request.getParameter(MAG_ID)));
				CategoryType[] listOfCategories = CategoryType.values();
				request.setAttribute(LIST, listOfCategories);
				request.setAttribute(MAG, magazine);
				resultPage = editMagPage;
			} catch (SQLException e) {
					request.setAttribute(ERROR_MESSAGE,
							SQLEXCEPTION_AT_PREPARE_EDIT_MAGAZINE_COMMAND);
					resultPage = errorPage;
				} 
		return resultPage;
	}
}
