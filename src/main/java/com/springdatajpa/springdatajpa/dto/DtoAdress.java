package com.springdatajpa.springdatajpa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.springdatajpa.springdatajpa.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DtoAdress {
    private int Id;
    private String description;
    private DtoCustomer customer;
}
