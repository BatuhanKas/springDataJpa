package com.springdatajpa.springdatajpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoCustomer {
    private int Id;
    private String name;
    private int adrNum;
    private DtoAdress dtoAdress;
}
