package com.codegym.furama.service;

import com.codegym.furama.entity.Promotion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPromotionService {
    List<Promotion> findAll();

    Promotion findById(Integer id);

    void save(Promotion promotion);

    void remove(Integer id);

    List<Promotion> findAllByDiscount(Double discount);
    List<Promotion> findAllByStartDate(String startDate);
    List<Promotion> findAllByEndDate(String endDate);
    List<Promotion> findAllByDiscountAndStartDateAndEndDate(Double discount, String startDate, String endDate);
}
