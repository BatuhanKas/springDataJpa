package com.springdatajpa.springdatajpa.controller;

import com.springdatajpa.springdatajpa.dto.DtoRoom;

import java.util.List;

public interface IRoomController {
    public DtoRoom saveRoom(DtoRoom dtoRoom);

    public List<DtoRoom> getAllRooms();
}
