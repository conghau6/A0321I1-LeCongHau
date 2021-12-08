package com.example.demo.repositories;


import com.example.demo.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinceRepositories extends JpaRepository<Province,Long> {
}
