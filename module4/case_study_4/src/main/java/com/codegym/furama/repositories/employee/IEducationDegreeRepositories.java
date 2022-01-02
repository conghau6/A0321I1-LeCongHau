package com.codegym.furama.repositories.employee;

import com.codegym.furama.entity.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationDegreeRepositories extends JpaRepository<EducationDegree,Integer> {
}
