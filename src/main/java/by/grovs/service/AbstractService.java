package by.grovs.service;
import java.util.List;

public interface AbstractService<T, L> {



    T findById(L id);

    List<T> findAll();

    T update (T entity);

    T create (T entity);

    void delete (L id);


}
