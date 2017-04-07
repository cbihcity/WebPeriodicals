package by.pvt.heldyieu.command.magazines;

import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.Magazine;
import by.pvt.heldyieu.exceptions.DaoException;
import by.pvt.heldyieu.magazine.MagazineServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShowAllMagazinesCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(ShowAllMagazinesCommand.class);

	private MagazineServiceImpl magazineServiceImpl;
    private String magazinePage;
    private String errorPage;
    private String resultPage;
    List<Magazine> listOfMagazines = new ArrayList<Magazine>();
	
	public ShowAllMagazinesCommand() {
		LOGGER.info(INITIALIZING_SHOW_ALL_MAGAZINES_COMMAND);
		magazinePage = resmanager.getProperty(MAGAZINE_PAGE);
		errorPage = resmanager.getProperty(ERROR_PAGE);
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		magazineServiceImpl = MagazineServiceImpl.getInstance();
		try {
			List<Magazine> listOfMagazines = magazineServiceImpl.getAllMagazines();
			if (listOfMagazines!=null) {
				request.setAttribute(LIST, listOfMagazines);
				resultPage =  magazinePage;
			}
		} catch (DaoException e) {
			LOGGER.error(SQLEXCEPTION_AT_SHOW_ALL_MAGAZINES_COMMAND);
        	request.setAttribute(ERROR_MESSAGE, SQLEXCEPTION_AT_SHOW_ALL_MAGAZINES_COMMAND);
        	resultPage =  errorPage;
		}
		return resultPage;
	}

}
