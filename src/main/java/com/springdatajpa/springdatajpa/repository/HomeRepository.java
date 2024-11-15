package com.springdatajpa.springdatajpa.repository;

import com.springdatajpa.springdatajpa.entities.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends JpaRepository<Home, Integer> {
}
