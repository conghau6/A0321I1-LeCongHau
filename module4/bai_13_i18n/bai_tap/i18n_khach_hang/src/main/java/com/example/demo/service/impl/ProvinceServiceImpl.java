package com.example.demo.service.impl;

import com.example.demo.model.Province;
import com.example.demo.repositories.ProvinceRepositories;
import com.example.demo.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    ProvinceRepositories provinceRepositories;

    @Override
    public List<Province> findAll() {
        return provinceRepositories.findAll();
    }

    @Override
    public Page<Province> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Province findById(Long id) {
        return provinceRepositories.findById(id).orElse(null);
    }

    @Override
    public void save(Province province) {
        provinceRepositories.save(province);
    }

    @Override
    public void remove(Long id) {
        provinceRepositories.deleteById(id);
    }
}
