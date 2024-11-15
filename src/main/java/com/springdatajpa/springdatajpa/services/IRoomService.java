package com.springdatajpa.springdatajpa.services;

import com.springdatajpa.springdatajpa.dto.DtoRoom;

import java.util.List;

public interface IRoomService {
    public DtoRoom saveRoom(DtoRoom dtoRoom);

    public List<DtoRoom> getAllRooms();
}
