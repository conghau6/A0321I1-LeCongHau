package model.service.impl;

import model.bean.service.RentType;
import model.repositories.RenTypeRepositories;
import model.repositories.impl.RentTypeRepositoriesImpl;
import model.service.RentTypeService;

import java.util.List;

public class RentTypeServiceImpl implements RentTypeService {
    RenTypeRepositories renTypeRepositories = new RentTypeRepositoriesImpl();
    @Override
    public List<RentType> findAll() {
        return renTypeRepositories.findAll();
    }
}
