package com.springdatajpa.springdatajpa.controller.impl;

import com.springdatajpa.springdatajpa.controller.IHomeController;
import com.springdatajpa.springdatajpa.dto.DtoHome;
import com.springdatajpa.springdatajpa.services.impl.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/home")
public class HomeController implements IHomeController {

    @Autowired
    private HomeService homeService;

    @Override
    @PostMapping("/save")
    public DtoHome saveHome(@RequestBody DtoHome dtoHome) {
        return homeService.saveHome(dtoHome);
    }

    @Override
    @GetMapping("/list/{id}")
    public DtoHome getHome(@PathVariable(name = "id") int id) {
        return homeService.getHome(id);
    }
}
