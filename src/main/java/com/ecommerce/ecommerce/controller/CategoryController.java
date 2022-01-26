package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.entity.Category;
import com.ecommerce.ecommerce.exception.RessourceNotFoundException;
import com.ecommerce.ecommerce.repository.CategoryRepository;
import com.ecommerce.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories/code")
    public int getCode() {
        System.out.println("get numbers");
        int x = categoryService.number();
        return (x==0 ? 0 : categoryService.max());
    }
    @GetMapping("/categories")
    public List<Category> listCategories(){
        return categoryService.getAll();
    }
    @GetMapping("/categories/{code}")
    public ResponseEntity<Category>
    getCategoryById(@PathVariable String code) {
        Optional<Category> category = categoryService.findByCode(code);
        return category.map(ResponseEntity::ok).orElseGet(
                ()->ResponseEntity.notFound().build());
    }
    @PostMapping("/categories")
    public Long save(@RequestBody Category category) {
        return categoryService.save(category);
    }
    @PutMapping("/categories/{code}")
    public void update(@PathVariable String code, @RequestBody Category category){
        Optional<Category> category1 = categoryService.findByCode(code);
        if (category1.isPresent()){
            categoryService.update(code, category);
        }
        else {
            categoryService.save(category);
        }
    }
    @DeleteMapping("/categories/{code}")
    public void delete(@PathVariable String code){
        categoryService.delete(code);
    }

    /*@GetMapping("/users/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter =
                new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename = categories_"
                + currentDateTime + ".xlsx";
        response.setHeader(headerKey,headerValue);
        List<Category> categories = categoryService.getAll();
        CategoryExcel categoryExcel = new CategoryExcel(categories);
        categoryExcel.export(response);
    }*/
}
