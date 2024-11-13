package com.springdatajpa.springdatajpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "adress")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Adress {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "description")
    private String description;

    @OneToOne(mappedBy = "adress")
    private Customer customer;
}
