package com.pirqana.bookrental.shared.exception;

import lombok.Data;

import java.util.Map;

@Data
public class ResponseArgumentNotValidException extends ResponseException{

    private Map<String, String> error;
}
