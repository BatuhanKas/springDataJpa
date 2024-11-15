package com.springdatajpa.springdatajpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoHome {
    private int Id;
    private long price;
    private List<Integer> rooms_id = new ArrayList<>();
    private List<DtoRoom> rooms = new ArrayList<>();
}
