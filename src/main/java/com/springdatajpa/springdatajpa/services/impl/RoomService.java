package com.springdatajpa.springdatajpa.services.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.springdatajpa.springdatajpa.dto.DtoRoom;
import com.springdatajpa.springdatajpa.entities.Room;
import com.springdatajpa.springdatajpa.repository.RoomRepository;
import com.springdatajpa.springdatajpa.services.IRoomService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService implements IRoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public DtoRoom saveRoom(DtoRoom dtoRoom) {
        Room room = new Room();
        BeanUtils.copyProperties(dtoRoom, room);
        Room response = roomRepository.save(room);
        BeanUtils.copyProperties(response, dtoRoom);
        return dtoRoom;
    }

    @Override
    public List<DtoRoom> getAllRooms() {
        List<DtoRoom> dtoRooms = new ArrayList<>();

        for (Room room : roomRepository.findAll()) {
            DtoRoom copyroom = new DtoRoom();
            BeanUtils.copyProperties(room, copyroom);
            dtoRooms.add(copyroom);
        }
        return dtoRooms;
    }
}
