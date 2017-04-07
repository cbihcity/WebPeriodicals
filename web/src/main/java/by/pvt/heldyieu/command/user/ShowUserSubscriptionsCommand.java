package by.pvt.heldyieu.command.user;

import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.Subscription;
import by.pvt.heldyieu.exception.DaoException;
import by.pvt.heldyieu.subscription.SubscriptionServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ShowUserSubscriptionsCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(ShowUserSubscriptionsCommand.class);
	private SubscriptionServiceImpl subscriptionServiceImpl;
    private String usersSubscriptionsPage;
    private String errorPage;
    private String resultPage;
    List<Subscription> listOfSubscriptions = new ArrayList<>();
	
	public ShowUserSubscriptionsCommand() {
		LOGGER.info(INITIALIZING_SHOW_USER_SUBSCRIPTIONS_COMMAND);
		usersSubscriptionsPage = resmanager.getProperty(USERS_SUBSCRIPTIONS_PAGE);
		errorPage = resmanager.getProperty(ERROR_PAGE);
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		subscriptionServiceImpl = SubscriptionServiceImpl.getInstance();
		try {
			if (request.getParameter(EMAIL)!=null) {
				listOfSubscriptions = subscriptionServiceImpl.findSubscriptionByEmail(request.getParameter(EMAIL));
				if (listOfSubscriptions!=null) {
					request.setAttribute(LIST, listOfSubscriptions);
					resultPage =  usersSubscriptionsPage;
				} else {
					request.setAttribute(ERROR_MESSAGE, SQLEXCEPTION_AT_SHOW_USER_SUBSCRIPTIONS_COMMAND);
		        	resultPage =  errorPage;
				}
			} else {
				listOfSubscriptions = subscriptionServiceImpl.getAllSubscriptions();
				if (listOfSubscriptions!=null) {
					request.setAttribute(LIST, listOfSubscriptions);
					resultPage =  usersSubscriptionsPage;
				} else {
					request.setAttribute(ERROR_MESSAGE, SQLEXCEPTION_AT_SHOW_USER_SUBSCRIPTIONS_COMMAND);
		        	resultPage =  errorPage;
				}
			}
			
		} catch (DaoException e) {
			LOGGER.error(SQLEXCEPTION_AT_SHOW_USER_SUBSCRIPTIONS_COMMAND);
        	request.setAttribute(ERROR_MESSAGE, SQLEXCEPTION_AT_SHOW_USER_SUBSCRIPTIONS_COMMAND);
        	resultPage =  errorPage;
		}
		return resultPage;
	}
}
