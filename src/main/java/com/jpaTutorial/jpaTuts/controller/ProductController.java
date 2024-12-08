package com.jpaTutorial.jpaTuts.controller;


import com.jpaTutorial.jpaTuts.entities.ProductEntity;
import com.jpaTutorial.jpaTuts.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/products")
public class ProductController {


    final private int PAGE_SIZE=3;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<ProductEntity> getAllProduct(@RequestParam(defaultValue = "") String title,@RequestParam(defaultValue = "id") String sortBy, @RequestParam(defaultValue = "0") Integer pageNumber){
//        List<ProductEntity> one = productRepository.findBytitleOrderByPrice("parle biscuita");
//        List<ProductEntity> two=productRepository.findByOrderByPrice();
//         one.addAll(two);
//        Sort sort=Sort.by(Sort.Direction.DESC,sortBy,"price","quantity");
            Sort sort=Sort.by(Sort.Order.asc(sortBy),Sort.Order.desc("price"));

//        List<ProductEntity> three=productRepository.findBy(sort);
        Pageable pageable= PageRequest.of(pageNumber,PAGE_SIZE,sort);
//        return productRepository.findAll(pageable).getContent();
        return productRepository.findByTitleContainingIgnoreCase(title,pageable);

    }
}
