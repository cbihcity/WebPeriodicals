package by.pvt.heldyieu.command.Subscription;

import by.pvt.heldyieu.command.ServletCommand;
import by.pvt.heldyieu.entity.Magazine;
import by.pvt.heldyieu.entity.SubscriptionType;
import by.pvt.heldyieu.magazine.MagazineServiceImpl;
import by.pvt.heldyieu.subscription.type.SubscriptionTypeServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;

public class CountTotalPriceCommand implements ServletCommand {

	private static final Logger LOGGER = Logger.getLogger(CountTotalPriceCommand.class);

    private String prepareAddSubscriptionPage;
    private String errorPage;
    private String resultPage;
	
	public CountTotalPriceCommand() {
		LOGGER.info(INITIALIZING_COUNT_TOTAL_PRICE_COMMAND);
		prepareAddSubscriptionPage = resmanager.getProperty(_ADD_SUBSCRIPTION_PAGE);
		errorPage = resmanager.getProperty(ERROR_PAGE);
	}
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
				try {
					Magazine magazine = MagazineServiceImpl.getInstance().getMagazine(Integer.valueOf(request.getParameter(MAG_ID)));
					SubscriptionType subscriptionType = SubscriptionTypeServiceImpl.getInstance().getSubscriptionType(Integer.valueOf(request.getParameter(TYPE_ID)));
					request.setAttribute(MAG, magazine);
					request.setAttribute(USER, request.getParameter(USER));
					request.setAttribute(TYPE, subscriptionType);
					Double total = subscriptionType.getMonthValue()*Double.valueOf(request.getParameter(PRICE));
					request.setAttribute(TOTAL, round(total,2));
					resultPage = prepareAddSubscriptionPage;
				} catch (NumberFormatException e) {
					LOGGER.error(NUMBER_FORMAT_EXCEPTION_AT_COUNT_TOTAL_PRICE_COMMAND);
					request.setAttribute(ERROR_MESSAGE,
							NUMBER_FORMAT_EXCEPTION_AT_COUNT_TOTAL_PRICE_COMMAND);
					resultPage = errorPage;
				} catch (SQLException e) {
					LOGGER.error(SQLEXCEPTION_AT_COUNT_TOTAL_PRICE_COMMAND);
					request.setAttribute(ERROR_MESSAGE,
							SQLEXCEPTION_AT_COUNT_TOTAL_PRICE_COMMAND);
					resultPage = errorPage;
				}
		return resultPage;
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
