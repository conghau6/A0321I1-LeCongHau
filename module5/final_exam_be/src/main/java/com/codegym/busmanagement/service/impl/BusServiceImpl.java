package com.codegym.busmanagement.service.impl;

import com.codegym.busmanagement.model.Bus;
import com.codegym.busmanagement.repositories.BusRepositories;
import com.codegym.busmanagement.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    BusRepositories busRepositories;

    @Override
    public List<Bus> findAll() {
        return busRepositories.findAll();
    }

    @Override
    public Bus findById(Integer id) {
        return busRepositories.findById(id).orElse(null);
    }

    @Override
    public void save(Bus bus) {
        busRepositories.save(bus);
    }

    @Override
    public void delete(Integer id) {
        busRepositories.deleteById(id);
    }

    @Override
    public void update(Bus bus) {
        busRepositories.save(bus);
    }
}
