package com.springdatajpa.springdatajpa.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiError<T> {
    private UUID id;
    private Date errorTime;
    private T errors;
}
