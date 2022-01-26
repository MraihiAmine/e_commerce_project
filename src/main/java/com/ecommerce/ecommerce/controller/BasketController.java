package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class BasketController {
    @Autowired
    private CategoryService categoryService;

/*    @GetMapping("categories/7")
    public int getCode(){
        System.out.println("Get numbers");
        int x = categoryService.nbre();
        System.out.println(x);
    }*/
}
