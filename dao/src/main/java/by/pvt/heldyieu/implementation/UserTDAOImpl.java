package by.pvt.heldyieu.implementation;

import by.pvt.heldyieu.AbstractDAO;
import by.pvt.heldyieu.entity.UserT;
import by.pvt.heldyieu.exception.InvalidValueException;
import by.pvt.heldyieu.factory.DaoFactory;

/**
 * Created by HeroDishonest on 07.04.2017.
 */
public class UserTDAOImpl extends AbstractDAO<UserT, Integer> {

    private static UserTDAOImpl INSTANCE;

    public UserTDAOImpl() {
        super(UserT.class);
    }

    public static UserTDAOImpl getInstance(){
        if (INSTANCE == null) {
            try {
                INSTANCE = (UserTDAOImpl) new DaoFactory().createDao("userTDao");
            } catch (InvalidValueException e) {
            }
        }
        return INSTANCE;
    }

}
