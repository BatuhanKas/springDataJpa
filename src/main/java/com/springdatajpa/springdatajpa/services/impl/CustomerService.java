package com.springdatajpa.springdatajpa.services.impl;

import com.springdatajpa.springdatajpa.dto.DtoAdress;
import com.springdatajpa.springdatajpa.dto.DtoCustomer;
import com.springdatajpa.springdatajpa.entities.Adress;
import com.springdatajpa.springdatajpa.entities.Customer;
import com.springdatajpa.springdatajpa.repository.AdressRepository;
import com.springdatajpa.springdatajpa.repository.CustomerRepository;
import com.springdatajpa.springdatajpa.services.ICustomerService;
import org.apache.catalina.mbeans.MBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

            DtoAdress dtoAdress = new DtoAdress();
            BeanUtils.copyProperties(optional.get(), dtoAdress);

            DtoCustomer response = new DtoCustomer();
            BeanUtils.copyProperties(c1, response);
            response.setDtoAdress(dtoAdress);

            return response;
        }
        return null;
    }

    @Override
    public DtoCustomer getCustomerById(int id) {
        DtoCustomer dtoCustomer = new DtoCustomer();
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            BeanUtils.copyProperties(customer.get(), dtoCustomer);

            DtoAdress dtoAdress = new DtoAdress();
            Adress adress = customer.get().getAdress();

            // istege bagli 2 farkli yapim sekli
//            dtoAdress.setId(adress.getId());
//            dtoAdress.setDescription(adress.getDescription());
            BeanUtils.copyProperties(adress, dtoAdress);

            dtoCustomer.setDtoAdress(dtoAdress);
        }
        return dtoCustomer;
    }
}
