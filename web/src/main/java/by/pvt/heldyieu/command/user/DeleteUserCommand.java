package by.pvt.heldyieu.command.user;

import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.user.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class DeleteUserCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(DeleteUserCommand.class);

	private UserServiceImpl userServiceImpl;
    private String errorPage;
    private String sucessPage;
    private String resultPage;
	
	public DeleteUserCommand() {
		LOGGER.info(INITIALIZING_DELETE_USER_COMMAND);
		sucessPage = resmanager.getProperty(SUCESS_PAGE);
		errorPage = resmanager.getProperty(ERROR_PAGE);
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		userServiceImpl = UserServiceImpl.getInstance();
				boolean result = false;
				try {
					result = userServiceImpl.deleteUser(Integer.valueOf(request.getParameter(USER_ID)));
				} catch (NumberFormatException e) {
					request.setAttribute(ERROR_MESSAGE, NUMBER_FORMAT_EXCEPTION_AT_DELETE_USER_COMMAND);
					resultPage =  errorPage;
				} catch (SQLException e) {
					request.setAttribute(ERROR_MESSAGE,
							SQLEXCEPTION_AT_DELETE_USER_COMMAND);
					resultPage = errorPage;
				}
				if (result) {
					request.setAttribute(SUCCESS_MESSAGE, USER_DELETE_SUCCESS);
					resultPage =  sucessPage;
				} 
		return resultPage;
	}

}
