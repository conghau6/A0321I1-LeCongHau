package com.codegym.furama.service;
import com.codegym.furama.model.RentType;
import com.codegym.furama.model.Service;
import com.codegym.furama.model.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {
    List<Service> findAll();

    Page<Service> findAll(Pageable pageable);

    Service save(Service service);

    List<ServiceType> getServiceTypes();

    List<RentType> getRentTypes();
}
