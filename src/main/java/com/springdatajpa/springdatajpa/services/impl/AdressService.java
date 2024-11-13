package com.springdatajpa.springdatajpa.services.impl;

import com.springdatajpa.springdatajpa.dto.DtoAdress;
import com.springdatajpa.springdatajpa.entities.Adress;
import com.springdatajpa.springdatajpa.repository.AdressRepository;
import com.springdatajpa.springdatajpa.services.IAdressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class AdressService implements IAdressService {

    @Autowired
    private AdressRepository adressRepository;

    @Override
    public DtoAdress saveAdress(DtoAdress dtoAdress) {
        Adress adress = new Adress();
        BeanUtils.copyProperties(dtoAdress, adress);
        Adress adress2 = adressRepository.save(adress);
        BeanUtils.copyProperties(adress2, dtoAdress);
        return dtoAdress;
    }
}
