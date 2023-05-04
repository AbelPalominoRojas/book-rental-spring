package com.pirqana.bookrental.shared.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;


@Data
@EqualsAndHashCode(callSuper = false)
public class ResponseArgumentNotValidException extends ResponseException{

    private Map<String, String> error;
}
