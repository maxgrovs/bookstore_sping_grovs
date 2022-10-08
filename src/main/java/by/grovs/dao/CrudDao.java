package by.grovs.dao;

import java.util.List;

public interface CrudDao<T,L> {

    T findById(L id);

    List<T> findAll();

    T update (T entity);

    T create (T entity);

    boolean delete (L id);

}
