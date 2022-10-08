package by.grovs.dto;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookDto {

    private long id;
    private String name;
    private String author;
    private String isbn;
    private BigDecimal cost;

}
