package model.repositories;

import model.bean.BenhAn;

import java.util.List;

public interface BenhAnRepositories {
    List<BenhAn> findAll();
    BenhAn findById(String id);
    void update(BenhAn benhAn);
    void delete(String id);
}
