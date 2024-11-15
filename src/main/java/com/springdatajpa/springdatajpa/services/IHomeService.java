package com.springdatajpa.springdatajpa.services;

import com.springdatajpa.springdatajpa.dto.DtoHome;

public interface IHomeService {
    public DtoHome saveHome(DtoHome dtoHome);

    public DtoHome getHome(int id);
}
