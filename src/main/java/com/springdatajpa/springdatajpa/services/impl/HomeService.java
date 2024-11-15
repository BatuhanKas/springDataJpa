package com.springdatajpa.springdatajpa.services.impl;

import com.springdatajpa.springdatajpa.controller.impl.HomeController;
import com.springdatajpa.springdatajpa.dto.DtoHome;
import com.springdatajpa.springdatajpa.dto.DtoRoom;
import com.springdatajpa.springdatajpa.entities.Home;
import com.springdatajpa.springdatajpa.entities.Room;
import com.springdatajpa.springdatajpa.repository.HomeRepository;
import com.springdatajpa.springdatajpa.repository.RoomRepository;
import com.springdatajpa.springdatajpa.services.IHomeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HomeService implements IHomeService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HomeRepository homeRepository;

    @Override
    public DtoHome saveHome(DtoHome dtoHome) {
        Home saveHome = new Home();
        BeanUtils.copyProperties(dtoHome, saveHome);
        System.out.println("geldinmi");
        for (int i : dtoHome.getRooms_id()) {
            System.out.printf("i val:" , i);
            Optional<Room> room = roomRepository.findById(i);
            if (room.isPresent()) {
                saveHome.getRoom().add(room.get());
            }
        }
        Home dbHome = homeRepository.save(saveHome);

        DtoHome response = new DtoHome();
        BeanUtils.copyProperties(dbHome, response);

        List<DtoRoom> dtoRoom = new ArrayList<>();
        for (Room room : dbHome.getRoom()) {
            DtoRoom copyroom = new DtoRoom();
            BeanUtils.copyProperties(room, copyroom);
            dtoRoom.add(copyroom);
        }

        response.setRooms(dtoRoom);

        return response;
    }

    @Override
    public DtoHome getHome(int id) {
        DtoHome response = new DtoHome();
        Optional<Home> dbHome = homeRepository.findById(id);
        if (dbHome.isPresent()) {
            BeanUtils.copyProperties(dbHome.get(), response);
        }

        for (Room room : dbHome.get().getRoom()) {
            DtoRoom copyroom = new DtoRoom();
            BeanUtils.copyProperties(room, copyroom);
            response.getRooms().add(copyroom);
        }

        return response;
    }
}
