package com.codegym.furama.service;

import com.codegym.furama.entity.Promotion;
import com.codegym.furama.repositories.PromotionRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService implements IPromotionService {

    @Autowired
    PromotionRepositories promotionRepositories;

    @Override
    public List<Promotion> findAll() {
        return promotionRepositories.findAll();
    }

    @Override
    public Promotion findById(Integer id) {
        return promotionRepositories.findById(id).orElse(null);
    }

    @Override
    public void save(Promotion promotion) {
        promotionRepositories.save(promotion);
    }

    @Override
    public void remove(Integer id) {
        promotionRepositories.deleteById(id);
    }

    @Override
    public List<Promotion> findAllByDiscount(Double discount) {
        return promotionRepositories.findAllByDiscount(discount);
    }

    @Override
    public List<Promotion> findAllByStartDate(String startDate) {
        return promotionRepositories.findAllByStartDate(startDate);
    }

    @Override
    public List<Promotion> findAllByEndDate(String endDate) {
        return promotionRepositories.findAllByEndDate(endDate);
    }

    @Override
    public List<Promotion> findAllByDiscountAndStartDateAndEndDate(Double discount, String startDate, String endDate) {
        return promotionRepositories.findAllByDiscountAndStartDateAndEndDate(discount,startDate,endDate);
    }
}
