package com.codegym.furama.service;
import com.codegym.furama.entity.RentType;
import com.codegym.furama.entity.Service;
import com.codegym.furama.entity.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {
    List<Service> findAll();

    Page<Service> findAll(Pageable pageable);

    Service save(Service service);

    List<RentType> findAllRentType();
    List<ServiceType> findAllServiceType();
}
