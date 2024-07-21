package com.aeon.assessment.library.book.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Setter
@Getter
public class BookDTO {
    private String id;
    private String name;
    private String isbn;
    private Long borrower;
}
