package com.springdatajpa.springdatajpa.exception;

import com.springdatajpa.springdatajpa.controller.IStudentController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    // Spring Validation'dan firlatilan throwlari yonetmek ve duzgun response donmek

    public List<String> addErrorsToList(List<String> list, String msg) {
        list.add(msg);
        return list;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public void handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, List<String>> errMap = new HashMap<>();
        for (ObjectError objectError : e.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError)objectError).getField();
            if (errMap.containsKey(fieldName)) {
                errMap.put(fieldName, addErrorsToList(errMap.get(fieldName), e.getMessage()));
            }
            else {
                errMap.put(fieldName, addErrorsToList(new ArrayList<>(), e.getMessage()));
            }
        }
    }
}
