package by.pvt.heldyieu.magazine;

import by.pvt.heldyieu.implementation.MagazineDAOImpl;
import by.pvt.heldyieu.entity.Magazine;

import java.sql.SQLException;
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
	public Magazine addMagazine(Magazine magazine) throws Exception {
		return magazineDao.create(magazine);
    }
	
	@Override
	public Magazine getMagazine(Integer id) throws SQLException {
		return magazineDao.readById(id);
    }
	
	@Override
	public void updateMagazine(Magazine magazine) throws SQLException {
		try {
			magazineDao.update(magazine);
		} catch (SQLException e) {
			throw new SQLException(e);
		}
    }
	
	@Override
	public boolean deleteMagazine(Integer id) throws SQLException  {
		try {
			return magazineDao.delete(id);
		} catch (SQLException e) {
			throw new SQLException(e);
		}
    }
	
	@Override
	public List<Magazine> getAllMagazines() throws SQLException {
		return magazineDao.getAll();
    }
	
	@Override
	public Magazine findMagazineByName(String name) throws SQLException {
		return magazineDao.findMagazineByName(name);
    }
}
