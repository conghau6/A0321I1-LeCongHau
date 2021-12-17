package com.cg.phonemanager.repositories;

import com.cg.phonemanager.model.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartPhoneRepositories extends JpaRepository<SmartPhone,Integer> {
}
