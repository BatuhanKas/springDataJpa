package com.springdatajpa.springdatajpa.controller;

import com.springdatajpa.springdatajpa.dto.DtoAdress;

public interface IAdressController {
    public DtoAdress saveAdress(DtoAdress dtoAdress);

    public DtoAdress getAdressById(int id);
}
