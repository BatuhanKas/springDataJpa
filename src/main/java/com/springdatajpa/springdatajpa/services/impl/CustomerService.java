package com.springdatajpa.springdatajpa.services.impl;

import com.springdatajpa.springdatajpa.dto.DtoAdress;
import com.springdatajpa.springdatajpa.dto.DtoCustomer;
import com.springdatajpa.springdatajpa.entities.Adress;
import com.springdatajpa.springdatajpa.entities.Customer;
import com.springdatajpa.springdatajpa.repository.AdressRepository;
import com.springdatajpa.springdatajpa.repository.CustomerRepository;
import com.springdatajpa.springdatajpa.services.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AdressRepository adressRepository;

    @Override
    public DtoCustomer saveCustomer(DtoCustomer dtoCustomer) {
        int num = dtoCustomer.getAdrNum();
        Optional<Adress> optional = adressRepository.findById(num);
        if (optional.isPresent()) {
            Customer customer = new Customer();
            BeanUtils.copyProperties(dtoCustomer, customer);
            customer.setAdress(optional.get());
            Customer c1 = customerRepository.save(customer);
            BeanUtils.copyProperties(c1, dtoCustomer);
            System.out.println("123123123");
            System.out.println(dtoCustomer.getDtoAdress().getDescription());
            return dtoCustomer;
        }
        return null;
    }
}
