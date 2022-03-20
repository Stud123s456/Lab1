package by.bsuir.insurance.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

public abstract class Dao<T> {
    public final static Logger log = LogManager.getLogger("DaoLogger");

    public abstract T getById(int id);
    public abstract ArrayList<T> getAll();
    public abstract boolean insert(T obj);
    public abstract boolean update(T obj);
    public abstract boolean delete(T obj);
    public abstract boolean isExists(T obj);
}


