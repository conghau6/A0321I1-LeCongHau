package model.repositories;

import model.bean.service.ServiceType;

import java.util.List;

public interface ServiceTypeRepositories {
    List<ServiceType> findAll();
}
