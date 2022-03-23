package com.codegym.busmanagement.service;

import com.codegym.busmanagement.model.Bus;

import java.util.List;

public interface BusService {
    List<Bus> findAll();
    Bus findById(Integer id);
    void save(Bus bus);
    void delete(Integer id);
    void update(Bus bus);
}
