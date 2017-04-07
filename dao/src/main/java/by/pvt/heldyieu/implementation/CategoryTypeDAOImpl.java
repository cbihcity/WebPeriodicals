package by.pvt.heldyieu.implementation;

import by.pvt.heldyieu.AbstractDAO;
import by.pvt.heldyieu.entity.CategoryType;
import by.pvt.heldyieu.exception.InvalidValueException;
import by.pvt.heldyieu.factory.DaoFactory;
import by.pvt.heldyieu.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Created by HeroDishonest on 07.04.2017.
 */
public class CategoryTypeDAOImpl extends  AbstractDAO<CategoryType, Integer> {
    private static CategoryTypeDAOImpl INSTANCE;

    public CategoryTypeDAOImpl() {
        super(CategoryType.class);
    }

    public static CategoryTypeDAOImpl getInstance(){
        if (INSTANCE == null) {
            try {
                INSTANCE = (CategoryTypeDAOImpl) new DaoFactory().createDao("CategoryTypeDao");
            } catch (InvalidValueException e) {
            }
        }
        return INSTANCE;
    }

    public CategoryType findCategoryByName(String name) {
        CategoryType categoryType;
        Session session = HibernateUtil.getInstance().getSession();
        Query query = session.createQuery("from CategoryType where type  = :name");
        query.setParameter("name", name);
        categoryType = (CategoryType) query.uniqueResult();
        return categoryType;
    }

}
