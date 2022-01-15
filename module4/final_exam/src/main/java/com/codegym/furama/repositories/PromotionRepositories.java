package com.codegym.furama.repositories;

import com.codegym.furama.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromotionRepositories extends JpaRepository<Promotion, Integer> {
    List<Promotion> findAllByDiscount(Double discount);
    List<Promotion> findAllByStartDate(String startDate);
    List<Promotion> findAllByEndDate(String endDate);
    List<Promotion> findAllByDiscountAndStartDateAndEndDate(Double discount, String startDate, String endDate);
}
