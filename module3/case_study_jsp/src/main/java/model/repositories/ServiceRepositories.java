package model.repositories;

import model.bean.service.Service;

import java.util.List;

public interface ServiceRepositories {
    List<Service> findAll();
    void save(Service service);
    void delete(int id);
    void update(Service service);
    Service findById(int id);
}
