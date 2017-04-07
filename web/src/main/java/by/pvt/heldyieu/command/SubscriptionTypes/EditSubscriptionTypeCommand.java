package by.pvt.heldyieu.command.SubscriptionTypes;

import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.SubscriptionType;
import by.pvt.heldyieu.exception.DaoException;
import by.pvt.heldyieu.subscription.type.SubscriptionTypeServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditSubscriptionTypeCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(EditSubscriptionTypeCommand.class);
	private SubscriptionTypeServiceImpl subscriptionTypeServiceImpl;
    private String errorPage;
    private String sucessPage;
    private String resultPage;
	
	public EditSubscriptionTypeCommand() {
		LOGGER.info(INITIALIZING_EDIT_SUBSCRIPTION_TYPE_COMMAND);
		sucessPage = resmanager.getProperty(SUCESS_PAGE);
		errorPage = resmanager.getProperty(ERROR_PAGE);
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		subscriptionTypeServiceImpl = SubscriptionTypeServiceImpl.getInstance();
		if (!request.getParameter(NAME).equals("")
				&& !request.getParameter(MONTH_VALUE).equals("")) {
			try {
				SubscriptionType subscriptionType  = new SubscriptionType();
				subscriptionType.setId(Integer.valueOf(request.getParameter(TYPE_ID)));
				subscriptionType.setName(request.getParameter(NAME));
				subscriptionType.setMonthValue(Integer.valueOf(request.getParameter(MONTH_VALUE)));
				subscriptionTypeServiceImpl.updateSubscriptionType(subscriptionType);
					request.setAttribute(SUCCESS_MESSAGE, SUBSCRIPTION_TYPE_EDIT_SUCCESS);
					resultPage =  sucessPage;
			} catch (DaoException e) {
					request.setAttribute(ERROR_MESSAGE,
							SQLEXCEPTION_AT_EDIT_SUBSCRIPTION_TYPE_COMMAND);
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
