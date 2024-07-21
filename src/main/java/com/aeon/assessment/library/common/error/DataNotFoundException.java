package com.aeon.assessment.library.common.error;

import jakarta.persistence.EntityNotFoundException;

public class DataNotFoundException extends EntityNotFoundException {
    public DataNotFoundException(String message) {
        super(message);
    }
}
