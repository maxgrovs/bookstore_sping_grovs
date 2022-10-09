package by.grovs.controller;

import by.grovs.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("psql");
        EntityManager entityManager = factory.createEntityManager();

        List<User> users = entityManager.createQuery("from User", User.class).getResultList();

        System.out.println(users);
    }

}
