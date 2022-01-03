package com.codegym.furama.repositories.contract;

import com.codegym.furama.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepositories extends JpaRepository<Contract, Integer> {
}
