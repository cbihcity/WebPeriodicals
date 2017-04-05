package by.pvt.heldyieu.command.Subscription;

import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.Magazine;
import by.pvt.heldyieu.entity.Subscription;
import by.pvt.heldyieu.entity.SubscriptionType;
import by.pvt.heldyieu.entity.User;
import by.pvt.heldyieu.magazine.MagazineServiceImpl;
import by.pvt.heldyieu.subscription.SubscriptionServiceImpl;
import by.pvt.heldyieu.subscription.type.SubscriptionTypeServiceImpl;
import by.pvt.heldyieu.user.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Date;

public class AddSubscriptionCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(AddSubscriptionCommand.class);
    
    private String sucessPage = resmanager.getProperty(SUCESS_PAGE);
    private String errorPage = resmanager.getProperty(ERROR_PAGE);
    private String resultPage;
    
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
			try {
				Date start = new Date();
				Magazine magazine = MagazineServiceImpl.getInstance().getMagazine(Integer.valueOf(request.getParameter(MAG_ID)));
				SubscriptionType subscriptionType = SubscriptionTypeServiceImpl.getInstance().getSubscriptionType(Integer.valueOf(request.getParameter(TYPE_ID)));
				User user = UserServiceImpl.getInstance().getUser(Integer.valueOf(request.getParameter(USER_ID)));
				Subscription subscription = new Subscription();
				subscription.setUser(user);
				subscription.setMagazine(magazine);
				subscription.setType(subscriptionType);
				subscription.setStartDate(start);
				subscription.setEndDate(Subscription.addDays(start, subscriptionType.getMonthValue()));
				subscription.setPrice(Double.valueOf(request.getParameter(TOTAL_PRICE)));
				SubscriptionServiceImpl.getInstance().addSubscription(subscription);
				request.setAttribute(SUCCESS_MESSAGE, SUBSCRIPTION_ADD_SUCCESS);
				resultPage = sucessPage;
			} catch (SQLException e) {
				LOGGER.error(SQLEXCEPTION_AT_ADD_SUBSCRIPTION_COMMAND);
				request.setAttribute(ERROR_MESSAGE,
						SQLEXCEPTION_AT_ADD_SUBSCRIPTION_COMMAND);
				resultPage = errorPage;
			} catch (Exception e) {
				e.printStackTrace();
			}
		return resultPage;
	}
}
