package by.pvt.heldyieu.implementation;
import by.pvt.heldyieu.entity.User;
import by.pvt.heldyieu.exception.DaoException;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImplTest {

    @Test
    public void testGetInstance() throws Exception {
        UserDAOImpl instance1 = UserDAOImpl.getInstance();
        UserDAOImpl instance2 = UserDAOImpl.getInstance();
        Assert.assertEquals(instance1.hashCode(),instance2.hashCode());
    }

    @Test
    @Ignore
    public void testAdd() throws Exception {
        int k = 0;
        for (int i = 0; i <50 ; i++) {
            try {
                List<User> listOfUsers = new ArrayList<User>();
                listOfUsers = UserDAOImpl.getInstance().getAll();
                k++;
                System.out.println(listOfUsers.get(0).toString());
            } catch (DaoException e) {
                System.out.println(e.getMessage());
            }
            finally {
                System.out.println(k);
            }
        }
        System.out.println(k);
    }
}
