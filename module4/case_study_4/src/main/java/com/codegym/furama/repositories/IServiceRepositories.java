package com.codegym.furama.repositories;

import com.codegym.furama.model.RentType;
import com.codegym.furama.model.Service;
import com.codegym.furama.model.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IServiceRepositories extends JpaRepository<Service,Integer> {

    @Query(nativeQuery = true, value="select * from service_type")
    List<ServiceType> getServiceTypes();

    @Query(nativeQuery = true, value="select * from rent_type")
    List<RentType> getRentTypes();
}
