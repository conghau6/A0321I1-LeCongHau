package model.service;

import model.bean.service.Service;

import java.util.List;

public interface ServiceService {
    List<Service> findAll();
    List<String> findAllStandardRoom ();
    void save(Service service);
    void delete(int id);
    void update(Service service);
    Service findById(int id);
}
