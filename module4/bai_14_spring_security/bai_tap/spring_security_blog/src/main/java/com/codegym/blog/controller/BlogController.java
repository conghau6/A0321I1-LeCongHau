package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.BlogService;
import com.codegym.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @ModelAttribute("listCategory")
    public List<Category> listCategory(){
        return categoryService.findAll();
    }

    @GetMapping("")
    public String showListBlog(Model model, @PageableDefault(size = 2) Pageable pageable,
                              Optional<String> search, Optional<String> sort,
                               Optional<Integer> category_filter){
        if(sort.isPresent()) {
            if (sort.get().equals("ASC")) {
                model.addAttribute("blogList", blogService.findAll(PageRequest.of(pageable.getPageSize(), 2, Sort.by(Sort.Direction.ASC, "date"))));
            } else if (sort.get().equals("DESC")) {
                model.addAttribute("blogList", blogService.findAll(PageRequest.of(pageable.getPageSize(), 2, Sort.by(Sort.Direction.DESC, "date"))));
            }
        } else if (search.isPresent()) {
            model.addAttribute("blogList", blogService.searchByTitle(search.get(), pageable));
        } else {
            if(category_filter.isPresent()) {
                model.addAttribute("category_filter", category_filter.get());
                model.addAttribute("blogList", blogService.findBlogByCategory_Id(category_filter.get(), pageable));
            } else
            model.addAttribute("blogList", blogService.findAll(pageable));
        }
        return "blog/list";
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("blog/create","blog", new Blog());
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        return "redirect:/blog/";
    }
}
