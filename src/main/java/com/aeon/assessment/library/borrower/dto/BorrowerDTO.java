package com.aeon.assessment.library.borrower.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class BorrowerDTO {
    private String id;
    private String name;
    private String email;
}
