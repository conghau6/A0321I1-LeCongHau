package com.codegym.service.impl;

import com.codegym.model.Province;
import com.codegym.repositories.ProvinceRepositories;
import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    ProvinceRepositories provinceRepositories;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepositories.findAll();
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
