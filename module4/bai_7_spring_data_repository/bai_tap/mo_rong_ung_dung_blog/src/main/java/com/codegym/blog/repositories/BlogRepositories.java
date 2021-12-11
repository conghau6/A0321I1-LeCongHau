package com.codegym.blog.repositories;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BlogRepositories extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog where header like %:c%", nativeQuery = true)
    Page<Blog> searchByCharacter(@Param("c") String c, Pageable p);

    Page<Blog> findBlogByCategory_Id(Integer id, Pageable p);
}
