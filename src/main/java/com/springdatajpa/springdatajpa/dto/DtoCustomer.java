package com.springdatajpa.springdatajpa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DtoCustomer {
    private int Id;
    private String name;
    private int adrNum;
    private DtoAdress dtoAdress;
}
