package com.springdatajpa.springdatajpa.dto;

import com.springdatajpa.springdatajpa.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoAdress {
    private int Id;
    private String description;
}
