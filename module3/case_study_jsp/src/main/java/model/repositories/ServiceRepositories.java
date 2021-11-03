package model.repositories;

import model.bean.service.Service;

import java.util.List;

public interface ServiceRepositories {
    List<Service> findAll();
    List<String> findAllStandardRoom ();
    void save(Service service);
    void delete(String id);
    void update(Service service);
    Service findById(String id);
}
