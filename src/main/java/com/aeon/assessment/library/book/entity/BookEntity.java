package com.aeon.assessment.library.book.entity;

import com.aeon.assessment.library.borrower.entity.BorrowerEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class BookEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String isbn;
    private String name;
    private String author;
    private Boolean isBorrowed;
    @ManyToOne
    @JoinColumn(name = "borrower")
    private BorrowerEntity borrowerEntity;

}
