package com.pirqana.bookrental.shared.exception;

import lombok.AllArgsConstructor;
import lombok.Data;


public class NotFoundException extends Exception {
    public NotFoundException(String message) {
        super(message);
    }
}
