package com.example.jpatuts.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpatuts.entites.ProductEntity;
import com.repositories.ProductRepository;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
           private final   int PAGE_SIZE = 5;

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id") String sortBy,
                                              @RequestParam(defaultValue = "1") Integer pageNumber) {
        // return productRepository.findBy(org.springframework.data.domain.Sort.by(Sort.Direction.ASC, sortBy,"price"));
        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE);
       return productRepository.findAll(pageable).getContent();
       


    }



}
