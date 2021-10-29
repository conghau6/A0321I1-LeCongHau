package model.service.impl;

import model.bean.service.ServiceType;
import model.repositories.ServiceTypeRepositories;
import model.repositories.impl.ServiceTypeRepositoriesImpl;
import model.service.ServiceTypeService;

import java.util.List;

public class ServiceTypeServiceImpl implements ServiceTypeService {
    ServiceTypeRepositories serviceTypeRepositories = new ServiceTypeRepositoriesImpl();
    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepositories.findAll();
    }
}
