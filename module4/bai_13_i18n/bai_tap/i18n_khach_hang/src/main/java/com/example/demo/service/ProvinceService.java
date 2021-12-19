package com.example.demo.service;

import com.example.demo.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProvinceService {
    List<Province> findAll();

    Page<Province> findAll(Pageable pageable);

    Province findById(Long id);

    void save(Province province);

    void remove(Long id);

}
