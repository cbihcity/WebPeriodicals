package by.pvt.heldyieu.command.user;

import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.User;
import by.pvt.heldyieu.entity.UserT;
import by.pvt.heldyieu.exception.DaoException;
import by.pvt.heldyieu.user.UserServiceImpl;
import by.pvt.heldyieu.userT.UserTServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PrepareEditUserCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(PrepareEditUserCommand.class);
	private UserServiceImpl userServiceImpl;
    private String errorPage;
    private String editUserPage;
    private String resultPage;
	
	public PrepareEditUserCommand() {
		LOGGER.info(INITIALIZING_PREPARE_EDIT_USER_COMMAND);
		editUserPage = resmanager.getProperty(EDIT_USER_PAGE);
		errorPage = resmanager.getProperty(ERROR_PAGE);
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		userServiceImpl = UserServiceImpl.getInstance();
			try {
				User user = userServiceImpl.getUser(Integer.valueOf(request.getParameter(USER_ID)));
				List<UserT>  userTlist = UserTServiceImpl.getInstance().getAllUsersT();
				request.setAttribute(LIST, userTlist);
				request.setAttribute(USER, user);
				resultPage = editUserPage;
			} catch (DaoException e) {
					request.setAttribute(ERROR_MESSAGE,
							SQLEXCEPTION_AT_PREPARE_EDIT_USER_COMMAND);
					resultPage = errorPage;
				} 
		return resultPage;
	}
}
