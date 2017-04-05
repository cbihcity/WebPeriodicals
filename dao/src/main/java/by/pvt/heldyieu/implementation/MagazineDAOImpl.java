package by.pvt.heldyieu.implementation;

import by.pvt.heldyieu.AbstractDAO;
import by.pvt.heldyieu.factory.DaoFactory;
import by.pvt.heldyieu.entity.Magazine;
import by.pvt.heldyieu.enums.CategoryType;
import by.pvt.heldyieu.exception.InvalidValueException;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MagazineDAOImpl extends AbstractDAO<Magazine, Integer> {
	
	private static final Logger LOGGER = Logger.getLogger(MagazineDAOImpl.class);
	private static MagazineDAOImpl INSTANCE;
	
	public MagazineDAOImpl() {
		super(Magazine.class);
		LOGGER.info("Initialize resource for MagazineDAOImpl and connection to database");
	}
	
	public static MagazineDAOImpl getInstance(){
		if (INSTANCE == null) {
			try {
				INSTANCE = (MagazineDAOImpl) new DaoFactory().createDao("magazineDao");
			} catch (InvalidValueException e) {
				LOGGER.error(e.getMessage());
			}
		}
		return INSTANCE;
	}


	public Magazine findMagazineByName(String name){
		Magazine magazine = null;
//		ResultSet result = null;
//		try(PreparedStatement statement = connect.prepareStatement(getFindNameQuery())) {
//			statement.setString(1, name);
//			result = statement.executeQuery();
//			magazine = parseResultSet(result);
//		} catch (SQLException e) {
//			LOGGER.error(e.getMessage());
//			System.out.println(ERROR_SQL_EXECUTE);
//		}
//		 finally {
//				try {
//					result.close();
//				} catch (SQLException e) {
//					LOGGER.info(e.getMessage());
//					System.out.println(ERROR_CLOSING_RESULTSET);
//				}
//			}
		return magazine;
	}
}
