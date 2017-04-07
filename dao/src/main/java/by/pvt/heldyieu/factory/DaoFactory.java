package by.pvt.heldyieu.factory;

import by.pvt.heldyieu.AbstractDAO;
import by.pvt.heldyieu.implementation.*;
import by.pvt.heldyieu.exception.InvalidValueException;
import by.pvt.heldyieu.interfaces.Constants;

public class DaoFactory implements Constants {
	
	
	
	public DaoFactory() {
		super();
	}

	@SuppressWarnings("rawtypes")
	public AbstractDAO createDao(String daoImpl) throws InvalidValueException {
		switch (daoImpl){
		case USER_DAO:
			return new UserDAOImpl();
		case MAGAZINE_DAO:
			return new MagazineDAOImpl();
		case SUBSCRIPTION_DAO:
			return new SubscriptionDAOImpl();
		case SUBSCRIPTION_TYPE_DAO:
			return new SubscriptionTypeDAOImpl();
			case "userTDao":
				return new UserTDAOImpl();
			case "CategoryTypeDao":
				return new CategoryTypeDAOImpl();
			default:
				throw new InvalidValueException(INVALID_PARSER_PARAMETER, daoImpl); 
		}
	}
}
