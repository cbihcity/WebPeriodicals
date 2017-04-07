package by.pvt.heldyieu.command.actions;

import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.User;
import by.pvt.heldyieu.exceptions.DaoException;
import by.pvt.heldyieu.user.UserServiceImpl;
import org.apache.log4j.Logger;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand implements ServletCommand {
	private static final Logger LOGGER = Logger.getLogger(LoginCommand.class);
    private String errorPage;
	
	public LoginCommand() {
		errorPage = resmanager.getProperty(ERROR_PAGE);
		
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String resultPage = null;
		String reqEmail = request.getParameter(EMAIL);
		String reqPass = request.getParameter(PASSWORD);
		HttpSession session = request.getSession();
				
		if (!reqEmail.equals("") && !reqPass.equals("")) {
            try {
            	User user = UserServiceImpl.getInstance().findUserByEmail(reqEmail, reqPass);
                if (user == null) {
                	LOGGER.error(ERROR_LOGIN); 
                	request.setAttribute(ERROR_MESSAGE, INCORRECT_EMAIL_OR_PASSWORD);
                	resultPage = errorPage;
                } else {
                
                //Если авторизация выполнена, то присваиваем сессии соответствующие атрибуты
                //и устанавливаем куки
                session.setAttribute(USER, user);
                Cookie c = new Cookie(ID, String.valueOf(user.getId()));
                c.setMaxAge(COOKIE);
                response.addCookie(c);
                }
            } catch (DaoException e) {
            	LOGGER.error(SQLEXCEPTION_AT_LOGIN_USER_ACTION);
            	request.setAttribute(ERROR_MESSAGE, SQLEXCEPTION_AT_LOGIN_USER_ACTION);
            	resultPage = errorPage;
            }
        } else{
        	LOGGER.error(LOGIN_EMAIL_OR_PASWORD_IS_NULL);
        	request.setAttribute(ERROR_MESSAGE, PLEASE_INPUT_EMAIL_AND_PASSWORD);
        	resultPage = errorPage;
        }
		return resultPage;
	}
}
