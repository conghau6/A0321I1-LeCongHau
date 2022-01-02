package com.codegym.furama.service;

import com.codegym.furama.model.RentType;
import com.codegym.furama.model.ServiceType;
import com.codegym.furama.repositories.IServiceRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService implements IServiceService {

    @Autowired
    IServiceRepositories serviceRepositories;

    @Override
    public List<com.codegym.furama.model.Service> findAll() {
        return serviceRepositories.findAll();
    }

    @Override
    public Page<com.codegym.furama.model.Service> findAll(Pageable pageable) {
        return serviceRepositories.findAll(pageable);
    }

    @Override
    public com.codegym.furama.model.Service save(com.codegym.furama.model.Service service) {
        return serviceRepositories.save(service);
    }

    @Override
    public List<ServiceType> getServiceTypes() {
        return serviceRepositories.getServiceTypes();
    }

    @Override
    public List<RentType> getRentTypes() {
        return serviceRepositories.getRentTypes();
    }
}
