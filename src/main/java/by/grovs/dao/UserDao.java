package by.grovs.dao;
import by.grovs.entity.User;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public interface UserDao extends CrudDao <User, Long> {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("psql");


}
