package com.codegym.busmanagement.repositories;

import com.codegym.busmanagement.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusRepositories extends JpaRepository<Bus,Integer> {
    List<Bus> findAll();
}
