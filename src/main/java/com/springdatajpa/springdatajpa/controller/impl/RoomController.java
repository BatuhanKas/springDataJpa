package com.springdatajpa.springdatajpa.controller.impl;

import com.springdatajpa.springdatajpa.controller.IRoomController;
import com.springdatajpa.springdatajpa.dto.DtoAdress;
import com.springdatajpa.springdatajpa.dto.DtoRoom;
import com.springdatajpa.springdatajpa.entities.Room;
import com.springdatajpa.springdatajpa.services.impl.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room")
public class RoomController implements IRoomController {
    @Autowired
    private RoomService roomService;

    @Override
    @PostMapping("/save")
    public DtoRoom saveRoom(@RequestBody DtoRoom dtoRoom) {
        return roomService.saveRoom(dtoRoom);
    }

    @Override
    @GetMapping("/list")
    public List<DtoRoom> getAllRooms() {
        return roomService.getAllRooms();
    }
}
