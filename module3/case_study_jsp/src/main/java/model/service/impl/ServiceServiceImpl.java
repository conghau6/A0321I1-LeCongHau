package model.service.impl;

import model.bean.service.Service;
import model.repositories.ServiceRepositories;
import model.repositories.impl.ServiceRepositoriesImpl;
import model.service.ServiceService;

import java.util.List;

public class ServiceServiceImpl implements ServiceService {
    private ServiceRepositories serviceRepositories = new ServiceRepositoriesImpl();
    @Override
    public List<Service> findAll() {
        return serviceRepositories.findAll();
    }

    @Override
    public List<String> findAllStandardRoom() {
        return serviceRepositories.findAllStandardRoom();
    }

    @Override
    public void save(Service service) {
        serviceRepositories.save(service);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Service service) {

    }

    @Override
    public Service findById(int id) {
        return null;
    }
}
