package by.pvt.heldyieu.command.SubscriptionTypes;

import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.SubscriptionType;
import by.pvt.heldyieu.subscription.type.SubscriptionTypeServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class AddSubscriptionTypeCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(AddSubscriptionTypeCommand.class);
    
    private String sucessPage = resmanager.getProperty(SUCESS_PAGE);
    private String errorPage = resmanager.getProperty(ERROR_PAGE);
    private String resultPage;
    
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		SubscriptionType subscriptionType = new SubscriptionType();
		if (!request.getParameter(NAME).equals("")
				&& !request.getParameter(MONTH_VALUE).equals("")) {
			subscriptionType.setName(request.getParameter(NAME).trim());
			subscriptionType.setMonthValue(Integer.valueOf(request.getParameter(MONTH_VALUE)));
			try {
				SubscriptionTypeServiceImpl.getInstance().addSubscriptionType(subscriptionType);
				request.setAttribute(SUCCESS_MESSAGE, SUBSCRIPTION_TYPE_ADD_SUCCESS);
				resultPage = sucessPage;
			} catch (SQLException e) {
				LOGGER.error(SQLEXCEPTION_AT_ADD_SUBSCRIPTION_TYPE_COMMAND);
				request.setAttribute(ERROR_MESSAGE,
						SQLEXCEPTION_AT_ADD_SUBSCRIPTION_TYPE_COMMAND);
				resultPage = errorPage;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute(ERROR_MESSAGE, PLEASE_INSERT_ALL_FIELDS);
			resultPage = errorPage;
		}
		return resultPage;
	}

}
