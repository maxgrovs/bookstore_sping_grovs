package by.grovs.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
public class Book {

    private long id;
    private String name;
    private String author;
    private String isbn;
    private BigDecimal cost;

    private LocalDate date;
    private boolean deleted;

    public Book() {
    }

    public Book(long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public Book(long id, String name, String author, String isbn, BigDecimal cost) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.cost = cost;
    }

    public Book(long id, String name, String author, String isbn, BigDecimal cost, LocalDate date) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.cost = cost;
        this.date = date;
    }


    public static Book.Builder builder() {
        return new Book.Builder();
    }

    public static class Builder {

        private long id;
        private String name;
        private String author;
        private String isbn;
        private BigDecimal cost;
        private LocalDate date;

        public Book.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Book.Builder name(String name) {
            this.name = name;
            return this;
        }

        public Book.Builder author(String author) {
            this.author = author;
            return this;
        }

        public Book.Builder cost(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Book.Builder isbn(BigDecimal cost) {
            this.cost = cost;
            return this;
        }

        public Book.Builder date(LocalDate date) {
            this.date = date;
            return this;
        }


        public Book build() {

            return
                    new Book(
                            this.id,
                            this.name,
                            this.author,
                            this.isbn,
                            this.cost,
                            this.date
                    );
        }


    }
}
