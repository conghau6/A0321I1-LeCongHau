package com.codegym.repositories;

import java.util.List;

public interface Repositories<T> {
    List<T> findAll();
    T findById(Long id);
    void save(T model);
    void remove(Long id);
}
