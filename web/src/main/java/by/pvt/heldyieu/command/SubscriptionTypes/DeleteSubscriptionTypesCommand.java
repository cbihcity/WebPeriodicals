package by.pvt.heldyieu.command.SubscriptionTypes;

import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.exception.DaoException;
import by.pvt.heldyieu.subscription.type.SubscriptionTypeServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteSubscriptionTypesCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(DeleteSubscriptionTypesCommand.class);
	private SubscriptionTypeServiceImpl subscriptionTypeServiceImpl;
    private String errorPage;
    private String sucessPage;
    private String resultPage;
	
	public DeleteSubscriptionTypesCommand() {
		LOGGER.info(INITIALIZING_DELETE_SUBSCRIPTION_TYPES_COMMAND);
		sucessPage = resmanager.getProperty(SUCESS_PAGE);
		errorPage = resmanager.getProperty(ERROR_PAGE);
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		subscriptionTypeServiceImpl = SubscriptionTypeServiceImpl.getInstance();
				boolean result = false;
				try {
					result = subscriptionTypeServiceImpl.deleteSubscriptionType(Integer.valueOf(request.getParameter(TYPE_ID)));
					if (result) {
						request.setAttribute(SUCCESS_MESSAGE, SUBSCRIPTION_TYPE_DELETE_SUCCESS);
						resultPage =  sucessPage;
					} 
				 else {
						request.setAttribute(ERROR_MESSAGE,
								SQLEXCEPTION_AT_DELETE_SUBSCRIPTION_TYPES_COMMAND);
						resultPage = errorPage;
					}
				} catch (NumberFormatException e) {
					request.setAttribute(ERROR_MESSAGE,
							NUMBER_FORMAT_EXCEPTION_AT_DELETE_SUBSCRIPTION_TYPES_COMMAND);
					resultPage = errorPage;
				} catch (DaoException e) {
					request.setAttribute(ERROR_MESSAGE,
							SQLEXCEPTION_AT_DELETE_SUBSCRIPTION_TYPES_COMMAND);
					resultPage = errorPage;
				}
		return resultPage;
	}
}
