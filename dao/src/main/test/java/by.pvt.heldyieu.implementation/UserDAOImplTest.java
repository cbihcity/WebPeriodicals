package by.pvt.heldyieu.implementation;

import by.pvt.heldyieu.entity.User;
import org.junit.*;

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
//        User expected = new User("igor","heldyieu", "test@mail.ru","123", UserType.USER);
//        User k = UserDAOImpl.getInstance().create(expected);
//        User actual = UserDAOImpl.getInstance().findUserByEmail(k.getEmail());
//        Assert.assertEquals(expected,actual);
//        UserDAOImpl.getInstance().delete(k.getId());
    }

}
