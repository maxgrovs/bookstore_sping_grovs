package by.grovs.dto;

import lombok.Data;


@Data
public class UserDto {

    private long id;
    private String firstName;
    private String lastName;
    private Role role;
    private String password;

    public enum Role {

        Admin, Manager, Customer

    }
}
