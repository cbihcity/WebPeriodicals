package by.pvt.heldyieu.command.SubscriptionTypes;

import by.pvt.heldyieu.command.ServletCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReferAddSubscriptionTypeCommand implements ServletCommand {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		return resmanager.getProperty(ADD_SUBSCRIPTION_TYPE_PAGE);
	}

}
