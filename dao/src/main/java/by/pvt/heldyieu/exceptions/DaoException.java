package by.pvt.heldyieu.exceptions;


public class DaoException extends Exception {
    public DaoException() {
        super();
    }

    public DaoException(String message){
        super(message);
    }

    public DaoException(String message, Throwable cause){
        super(message, cause);
    }

}
