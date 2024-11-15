package com.springdatajpa.springdatajpa.repository;

import com.springdatajpa.springdatajpa.entities.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Integer> {
}
