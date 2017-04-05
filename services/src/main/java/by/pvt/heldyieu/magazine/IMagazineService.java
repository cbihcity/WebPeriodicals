package by.pvt.heldyieu.magazine;

import by.pvt.heldyieu.entity.Magazine;

import java.sql.SQLException;
import java.util.List;

public interface IMagazineService {
	
	 Magazine addMagazine(Magazine magazine) throws Exception;
	
	 Magazine getMagazine(Integer id) throws SQLException;
	
	 void updateMagazine(Magazine magazine) throws SQLException;
	
	 boolean deleteMagazine(Integer id) throws SQLException;
	
	 List<Magazine> getAllMagazines() throws SQLException;
	
	 Magazine findMagazineByName(String name) throws SQLException;
}