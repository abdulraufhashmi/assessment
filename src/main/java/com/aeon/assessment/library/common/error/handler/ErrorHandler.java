package com.aeon.assessment.library.common.error.handler;

import com.aeon.assessment.library.common.dto.ErrorDTO;
import com.aeon.assessment.library.common.error.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<?> dataNotFoundExceptionHandling(Exception exception, WebRequest request) {
        return new ResponseEntity<>(new ErrorDTO(new Date(), exception.getMessage(), request.getDescription(false)), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request) {
        return new ResponseEntity<>(new ErrorDTO(new Date(), exception.getMessage(), request.getDescription(false)), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}