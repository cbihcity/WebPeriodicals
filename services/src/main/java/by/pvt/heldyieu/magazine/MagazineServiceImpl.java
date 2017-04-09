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
		try {
			magazineDao.create(magazine);
		} catch (Exception e){
            throw new DaoException();
		}
    }
	
	@Override
	public Magazine getMagazine(Integer id) throws DaoException {
		Magazine magazine = null;
		try {
			magazine = magazineDao.readById(id);
		}
		catch (Exception e) {
            throw new DaoException();
		}
		return magazine;
    }
	
	@Override
	public void updateMagazine(Magazine magazine) throws DaoException {
		try {
			magazineDao.update(magazine);
		}
		catch (Exception e) {
		}
    }
	
	@Override
	public boolean deleteMagazine(Integer id) throws DaoException  {
		boolean result = false;
		try {
			result = magazineDao.delete(id);
		}
		catch (Exception e) {
            throw new DaoException();
		}
		return result;
    }
	
	@Override
	public List<Magazine> getAllMagazines() throws DaoException {
		List<Magazine> magazines = null;
		try {
			magazines = magazineDao.getAll();
		}
		catch (Exception e) {
            throw new DaoException();
		}
		return magazines;
    }
	
	@Override
	public Magazine findMagazineByName(String name) throws DaoException {
		return magazineDao.findMagazineByName(name);
    }
}
