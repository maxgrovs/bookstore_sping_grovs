package by.grovs.util;

import by.grovs.dto.BookDto;
import by.grovs.dto.UserDto;
import by.grovs.entity.Book;
import by.grovs.entity.User;


public class ObjectMapper {

    public BookDto toDto(Book entity) {
        BookDto dto = new BookDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAuthor(entity.getAuthor());
        dto.setIsbn(entity.getIsbn());
        dto.setCost(entity.getCost());

        return dto;
    }

    public Book toEntity(BookDto dto) {
        Book entity = new Book();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAuthor(dto.getAuthor());
        entity.setIsbn(dto.getIsbn());
        entity.setCost(dto.getCost());

        return entity;
    }

    public UserDto toDto(User entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setRole(UserDto.Role.valueOf(entity.getRole().toString()));
        dto.setPassword(entity.getPassword());

        return dto;
    }

    public User toEntity(UserDto dto) {
        User entity = new User();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setRole(User.Role.valueOf(dto.getRole().toString()));
        entity.setPassword(dto.getPassword());

        return entity;
    }

}
