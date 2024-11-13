package com.springdatajpa.springdatajpa.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {
    // Spring Validation'dan firlatilan throwlari yonetmek ve duzgun response donmek

    public List<String> addErrorsToList(List<String> list, String msg) {
        list.add(msg);
        return list;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, List<String>> errMap = new HashMap<>();
        for (ObjectError objectError : e.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError)objectError).getField();
            if (errMap.containsKey(fieldName))
                errMap.put(fieldName, addErrorsToList(errMap.get(fieldName), objectError.getDefaultMessage()));
            else
                errMap.put(fieldName, addErrorsToList(new ArrayList<>(), objectError.getDefaultMessage()));
        }
        return ResponseEntity.badRequest().body(setToErrorFormat(errMap));
    }

    private <T> ApiError<T> setToErrorFormat(T errors) {
        ApiError<T> apiError = new ApiError<T>();
        apiError.setId(UUID.randomUUID());
        apiError.setErrorTime(new Date());
        apiError.setErrors(errors);

        return apiError;
    }
}
