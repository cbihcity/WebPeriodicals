package by.pvt.heldyieu.command.SubscriptionTypes;

import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.SubscriptionType;
import by.pvt.heldyieu.subscription.type.SubscriptionTypeServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class ShowSubscriptionTypesCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(ShowSubscriptionTypesCommand.class);

	private SubscriptionTypeServiceImpl subscriptionTypeServiceImpl;

    private String subscriptionTypesPage;
    private String errorPage;
    private String resultPage;
	
	public ShowSubscriptionTypesCommand() {
		LOGGER.info(INITIALIZING_SHOW_SUBSCRIPTION_TYPES_COMMAND);
		subscriptionTypesPage = resmanager.getProperty(SUBSCRIPTION_TYPES_PAGE);
		errorPage = resmanager.getProperty(ERROR_PAGE);
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		subscriptionTypeServiceImpl = SubscriptionTypeServiceImpl.getInstance();
		try {
			List<SubscriptionType> list = subscriptionTypeServiceImpl.getAllSubscriptionTypes();
			if (list!=null) {
				request.setAttribute(LIST, list);
				resultPage =  subscriptionTypesPage;
			}
		} catch (SQLException e) {
			LOGGER.error(SQLEXCEPTION_AT_SHOW_SUBSCRIPTION_TYPES_COMMAND);
        	request.setAttribute(ERROR_MESSAGE, SQLEXCEPTION_AT_SHOW_SUBSCRIPTION_TYPES_COMMAND);
        	resultPage =  errorPage;
		}
		return resultPage;
	}

}
