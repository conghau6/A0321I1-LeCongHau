package model.service.impl;

import model.bean.BenhAn;
import model.repositories.BenhAnRepositories;
import model.repositories.impl.BenhAnRepositoriesImpl;
import model.service.BenhAnService;
import model.service.common.Validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BenhAnServiceImpl implements BenhAnService {
    BenhAnRepositories benhAnRepositories = new BenhAnRepositoriesImpl();
    @Override
    public List<BenhAn> findAll() {
        return benhAnRepositories.findAll();
    }

    @Override
    public BenhAn findById(String id) {
        return benhAnRepositories.findById(id);
    }

    @Override
    public Map<String,String> update(BenhAn benhAn) {
        Map<String, String> mapMessage = new HashMap<>();
        if(Validator.validateName(benhAn.getTenBenhNhan())!=null){
            mapMessage.put("errName",Validator.validateName(benhAn.getTenBenhNhan()));
        } else benhAnRepositories.update(benhAn);
        return mapMessage;
    }

    @Override
    public void delete(String id) {
        benhAnRepositories.delete(id);
    }
}
