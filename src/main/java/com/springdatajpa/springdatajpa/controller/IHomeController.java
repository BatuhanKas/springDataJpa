package com.springdatajpa.springdatajpa.controller;

import com.springdatajpa.springdatajpa.dto.DtoHome;

public interface IHomeController {
    public DtoHome saveHome(DtoHome dtoHome);

    public DtoHome getHome(int id);
}
