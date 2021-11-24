package com.codegym.repository.impl;

import com.codegym.model.Blog;
import com.codegym.repository.BlogRepositories;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BlogRepositoriesImpl implements BlogRepositories {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Blog getBlogById(int id) {
        return entityManager.find(Blog.class,id);
    }

    @Override
    public List<Blog> getList() {
        return entityManager.createQuery("select b from Blog b").getResultList();
    }

     /*
        pageNumber: số trang
        pageRecords: số record mỗi trang
     */

    @Override
    public List<Blog> getListWithPaging(int pageNumber, int pageRecords) {
        return entityManager.createQuery("select b from Blog b")
                .setFirstResult((pageNumber - 1) * pageRecords)
                .setMaxResults(pageRecords)
                .getResultList();
    }

    @Override
    public void save(Blog blog) {
        entityManager.persist(blog);
    }

    @Override
    public void update(Blog blog) {
        entityManager.merge(blog);
    }

    @Override
    public void deleteBlogById(int id) {
        Blog blog = entityManager.find(Blog.class, id);
        entityManager.remove(blog);
    }
}
