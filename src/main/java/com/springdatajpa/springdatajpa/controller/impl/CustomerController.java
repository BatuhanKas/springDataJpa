package com.springdatajpa.springdatajpa.controller.impl;

import com.springdatajpa.springdatajpa.controller.ICustomerController;
import com.springdatajpa.springdatajpa.dto.DtoCustomer;
import com.springdatajpa.springdatajpa.services.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController implements ICustomerController {
    @Autowired
    private CustomerService customerService;

    @Override
    @PostMapping("/save")
    public DtoCustomer saveCustomer(@RequestBody DtoCustomer dtoCustomer) {
        return customerService.saveCustomer(dtoCustomer);
    }

    @Override
    @GetMapping("/list/{id}")
    public DtoCustomer getCustomerById(@PathVariable(name = "id", required = true) int id) {
        return customerService.getCustomerById(id);
    }
}
