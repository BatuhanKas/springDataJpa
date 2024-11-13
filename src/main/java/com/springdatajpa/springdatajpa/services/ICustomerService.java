package com.springdatajpa.springdatajpa.services;

import com.springdatajpa.springdatajpa.dto.DtoAdress;
import com.springdatajpa.springdatajpa.dto.DtoCustomer;

public interface ICustomerService {
    public DtoCustomer saveCustomer(DtoCustomer dtoCustomer);
}
