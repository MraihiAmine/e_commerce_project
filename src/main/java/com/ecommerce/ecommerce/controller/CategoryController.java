package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.entity.Category;
import com.ecommerce.ecommerce.exception.RessourceNotFoundException;
import com.ecommerce.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        System.out.println("Get all categories");
        List<Category> categories = new ArrayList<>();
        //:: Method references allow you to call
        // a method by mentioning its name.
        categoryRepository.findAll().forEach(categories::add);
        return categories;
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> geCategoryById(
            @PathVariable(value = "id") Long categoryId) throws
            RessourceNotFoundException {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RessourceNotFoundException(
                "Category for this id : " + categoryId  + "is not found"));
        return ResponseEntity.ok().body(category);
    }

    @PostMapping("/categories")
    public Category createCategory(@Valid @RequestBody Category category){
        return categoryRepository.save(category);
    }

    @DeleteMapping("/caltegories/{id}")
    public Map<String, Boolean> deleteCategory(@PathVariable(value = "id") Long categoryId)
        throws RessourceNotFoundException{
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RessourceNotFoundException(
                "Category for this id : " + categoryId  + "is not found"));
        categoryRepository.delete(category);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
