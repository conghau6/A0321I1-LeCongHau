package com.codegym.repositories.impl;

import com.codegym.model.Customer;
import com.codegym.repositories.CustomerRepositories;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CustomerRepositoriesImpl implements CustomerRepositories {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("select c from Customer c", Customer.class).getResultList();
    }

    @Override
    public Customer findById(Long id) {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c where c.id = :id", Customer.class);
        query.setParameter("id",id);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void save(Customer model) {
        if(model.getId()!=null){
            entityManager.merge(model);
        } else {
            entityManager.persist(model);
        }
    }

    @Override
    public void remove(Long id) {
        Customer customer = findById(id);
        if(customer!=null) {
            entityManager.remove(customer);
        }
    }
}
