package com.cg.phonemanager.service;

import com.cg.phonemanager.model.SmartPhone;
import com.cg.phonemanager.repositories.SmartPhoneRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartPhoneServiceImpl implements SmartPhoneService {

    @Autowired
    SmartPhoneRepositories smartPhoneRepositories;
    @Override
    public List<SmartPhone> findAll() {
        return smartPhoneRepositories.findAll();
    }

    @Override
    public SmartPhone findById(Integer id) {
        return smartPhoneRepositories.findById(id).orElse(null);
    }

    @Override
    public SmartPhone save(SmartPhone phone) {
        return smartPhoneRepositories.save(phone);
    }

    @Override
    public SmartPhone remove(Integer id) {
        SmartPhone smartPhone = findById(id);
        smartPhoneRepositories.deleteById(id);
        return smartPhone;
    }
}
