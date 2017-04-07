package by.pvt.heldyieu.magazine;

import by.pvt.heldyieu.entity.Magazine;
import by.pvt.heldyieu.exceptions.DaoException;

import java.util.List;

public interface IMagazineService {
	
	 void addMagazine(Magazine magazine) throws DaoException;
	
	 Magazine getMagazine(Integer id) throws DaoException;
	
	 void updateMagazine(Magazine magazine) throws DaoException;
	
	 boolean deleteMagazine(Integer id) throws DaoException;
	
	 List<Magazine> getAllMagazines() throws DaoException;
	
	 Magazine findMagazineByName(String name) throws DaoException;
}