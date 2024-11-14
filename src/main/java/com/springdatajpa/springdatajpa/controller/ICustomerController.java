package com.springdatajpa.springdatajpa.controller;

import com.springdatajpa.springdatajpa.dto.DtoCustomer;

public interface ICustomerController {
    public DtoCustomer saveCustomer(DtoCustomer dtoCustomer);

    public DtoCustomer getCustomerById(int id);
}
