package com.aeon.assessment.library.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorDTO {
    private Date timestamp;
    private String message;
    private String details;
}