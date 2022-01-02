package com.codegym.furama.repositories.employee;

import com.codegym.furama.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepositories extends JpaRepository<Position,Integer> {
}
