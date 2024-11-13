package com.springdatajpa.springdatajpa.controller.impl;

import com.springdatajpa.springdatajpa.controller.IAdressController;
import com.springdatajpa.springdatajpa.dto.DtoAdress;
import com.springdatajpa.springdatajpa.services.impl.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/adress")
public class AdressController implements IAdressController {

    @Autowired
    private AdressService adressService;

    @Override
    @PostMapping("/save")
    public DtoAdress saveAdress(@RequestBody DtoAdress dtoAdress) {
        return adressService.saveAdress(dtoAdress);
    }
}
