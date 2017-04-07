package by.pvt.heldyieu.magazine;

import by.pvt.heldyieu.entity.Magazine;
import by.pvt.heldyieu.exception.DaoException;
import by.pvt.heldyieu.implementation.MagazineDAOImpl;
import by.pvt.heldyieu.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MagazineServiceImpl implements IMagazineService {
	private MagazineDAOImpl magazineDao;
	private static MagazineServiceImpl INSTANCE = null;
	
	private MagazineServiceImpl() {
		magazineDao = MagazineDAOImpl.getInstance();
	}
	
	public static MagazineServiceImpl getInstance(){
		if (INSTANCE == null) {
			INSTANCE = new MagazineServiceImpl();
		} 
		return INSTANCE;
	}
	
	@Override
	public void addMagazine(Magazine magazine) throws DaoException {
		Session session = HibernateUtil.getInstance().getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			magazineDao.create(magazine);
			transaction.commit();
		} catch (Exception e){
			transaction.rollback();
		}
		HibernateUtil.getInstance().releaseSession(session);
    }
	
	@Override
	public Magazine getMagazine(Integer id) throws DaoException {
		Magazine magazine = null;
		Session session = HibernateUtil.getInstance().getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			magazine = magazineDao.readById(id);
			transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
		}
		HibernateUtil.getInstance().releaseSession(session);
		return magazine;
    }
	
	@Override
	public void updateMagazine(Magazine magazine) throws DaoException {
		Session session = HibernateUtil.getInstance().getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			magazineDao.update(magazine);
			transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
		}
		HibernateUtil.getInstance().releaseSession(session);
    }
	
	@Override
	public boolean deleteMagazine(Integer id) throws DaoException  {
		boolean result = false;
		Session session = HibernateUtil.getInstance().getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			magazineDao.delete(id);
			transaction.commit();
			result = true;
		}
		catch (Exception e) {
			transaction.rollback();
		}
		HibernateUtil.getInstance().releaseSession(session);
		return result;
    }
	
	@Override
	public List<Magazine> getAllMagazines() throws DaoException {
		List<Magazine> magazines = null;
		Session session = HibernateUtil.getInstance().getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			magazines = magazineDao.getAll();
			transaction.commit();
		}
		catch (Exception e) {
			transaction.rollback();
		}
		HibernateUtil.getInstance().releaseSession(session);
		return magazines;
    }
	
	@Override
	public Magazine findMagazineByName(String name) throws DaoException {
		return magazineDao.findMagazineByName(name);
    }
}
