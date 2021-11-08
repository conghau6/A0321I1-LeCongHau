package model.service;

import model.bean.BenhAn;

import java.util.List;
import java.util.Map;

public interface BenhAnService {
    List<BenhAn> findAll();
    BenhAn findById(String id);
    Map<String,String> update(BenhAn benhAn);
    void delete(String id);
}
