package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.entity.Category;
import com.ecommerce.ecommerce.entity.SubCategory;
import com.ecommerce.ecommerce.repository.SubCategoryRepository;
import com.ecommerce.ecommerce.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SubCategoryController {
    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping("/subcategories")
    public List<SubCategory> getAllSubCategories(){
        System.out.println("GetAllSubCategories");
        return subCategoryService.getAll();
    }
    @GetMapping("/subcategory/{code}")
    public ResponseEntity<SubCategory>
    getSubCategoryByCode(@PathVariable String code){
        Optional<SubCategory> subCategory =
                subCategoryService.findByCode(code);
        return subCategory.map(ResponseEntity::ok).
                orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/subcategory")
    public Long saveSubCategory(@RequestBody SubCategory subCategory){
        return subCategoryService.save(subCategory);
    }
    @PutMapping("subcategory/{code}")
    public void update(@PathVariable String code, @RequestBody SubCategory subCategory){
        Optional<SubCategory> subCategory1 = subCategoryService.findByCode(code);
        if(subCategory1.isPresent()){
            subCategoryService.update(code,subCategory);
        }
        else {
            subCategoryService.save(subCategory);
        }
    }
    @DeleteMapping("/subcategories/{code}")
    public void delete(@PathVariable String code){
        subCategoryService.delete(code);
    }
    @GetMapping("/subcategory/{code}")
    public ResponseEntity<List<SubCategory>>
    listSubCategories(@PathVariable String code){
        List<SubCategory> subCategories =
                subCategoryService.findByCodeCategory(code);
        return new ResponseEntity<List<SubCategory>>
                (subCategories, HttpStatus.OK);
    }
}
