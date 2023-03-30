package com.pirqana.bookrental.web.controller;

import com.pirqana.bookrental.shared.exception.NotFoundException;
import com.pirqana.bookrental.shared.exception.ResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseException handleInvalidArgument (MethodArgumentNotValidException ex) {
        ResponseException response = new ResponseException();
        Map<String, String> errorMap = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->{
            errorMap.put(error.getField(), error.getDefaultMessage());
        });

        response.setMessage("Ingrese todos los datos requeridos");
        response.setError(errorMap);

        return response;
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseException handleNotFound (NotFoundException ex) {
        ResponseException response = new ResponseException();

        response.setMessage(ex.getMessage());

        return response;
    }
}
