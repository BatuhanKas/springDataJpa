package com.springdatajpa.springdatajpa.repository;

import com.springdatajpa.springdatajpa.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
}
