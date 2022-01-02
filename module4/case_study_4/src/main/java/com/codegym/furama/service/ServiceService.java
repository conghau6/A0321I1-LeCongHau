package com.codegym.furama.service;

import com.codegym.furama.entity.RentType;
import com.codegym.furama.entity.ServiceType;
import com.codegym.furama.repositories.service.IRentTypeRepositories;
import com.codegym.furama.repositories.service.IServiceRepositories;
import com.codegym.furama.repositories.service.IServiceTypeRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService implements IServiceService {

    @Autowired
    IServiceRepositories serviceRepositories;

    @Autowired
    IServiceTypeRepositories serviceTypeRepositories;

    @Autowired
    IRentTypeRepositories rentTypeRepositories;

    @Override
    public List<com.codegym.furama.entity.Service> findAll() {
        return serviceRepositories.findAll();
    }

    @Override
    public Page<com.codegym.furama.entity.Service> findAll(Pageable pageable) {
        return serviceRepositories.findAll(pageable);
    }

    @Override
    public com.codegym.furama.entity.Service save(com.codegym.furama.entity.Service service) {
        return serviceRepositories.save(service);
    }

    @Override
    public List<RentType> findAllRentType() {
        return rentTypeRepositories.findAll();
    }

    @Override
    public List<ServiceType> findAllServiceType() {
        return serviceTypeRepositories.findAll();
    }
}
