package com.example.openrecipeapi.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Product with this id does not exist")
public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    private final HttpStatus httpStatus = HttpStatus.NOT_FOUND;
}
