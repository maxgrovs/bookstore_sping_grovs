package by.grovs.entity;

import lombok.Data;

import java.util.Objects;

@Data
public class User {

    private long id;
    private String firstName;
    private String lastName;
    private Role role;
    private String password;


    public User() {
    }

    public User(long id, String firstName, String lastName, Role role, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.password = password;
    }

    public User(long id, String firstName, String lastName, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }


}
