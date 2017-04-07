package by.pvt.heldyieu.command.user;

import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.User;
import by.pvt.heldyieu.entity.UserT;
import by.pvt.heldyieu.exceptions.DaoException;
import by.pvt.heldyieu.user.UserServiceImpl;
import by.pvt.heldyieu.userT.UserTServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class AddUserCommand implements ServletCommand {
	private static final Logger LOGGER = Logger.getLogger(AddUserCommand.class);
    
    private String sucessPage = resmanager.getProperty(SUCESS_PAGE);
    private String errorPage = resmanager.getProperty(ERROR_PAGE);
    private String resultPage;
    
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response){
		String first_name = request.getParameter(FIRSTNAME);
		String last_name = request.getParameter(LASTNAME);
		String email = request.getParameter(EMAIL);
		String pass = request.getParameter(PASS);
		User user = new User();
		UserT userT = null;
		try {
			userT = UserTServiceImpl.getInstance().getUserT(2);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		if ( !first_name.equals("")
				&& !last_name.equals("")
				&& !email.equals("")
				&& !pass.equals("")) {
			user.setFirstName(first_name);
			user.setLastName(last_name);
			user.setEmail(email);
			user.setPassword(pass);
			user.setUserT(userT);
			try {
				UserServiceImpl.getInstance().addUser(user);
			request.setAttribute(SUCCESS_MESSAGE, USER_ADD_SUCCESS);
				resultPage = sucessPage;
			} catch (DaoException e) {
				LOGGER.error(SQLEXCEPTION_AT_ADD_USER_COMMAND);
				request.setAttribute(ERROR_MESSAGE,
						SQLEXCEPTION_AT_ADD_USER_COMMAND);
				resultPage = errorPage;
			}
		} else {
			request.setAttribute(ERROR_MESSAGE, PLEASE_INSERT_ALL_FIELDS);
			resultPage = errorPage;
		}
		return resultPage;
	}

}
