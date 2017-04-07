package by.pvt.heldyieu.interfaces;

import by.pvt.heldyieu.exceptions.DaoException;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO <T, PK extends Number> {
	
    public T create(T object) throws DaoException;

    public T readById(PK key) throws DaoException;

    public void update(T object) throws DaoException;

    public boolean delete(PK key) throws DaoException;

    public List<T> getAll() throws DaoException;
}
