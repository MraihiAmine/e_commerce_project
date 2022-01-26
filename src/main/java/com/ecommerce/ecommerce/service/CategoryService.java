package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.entity.Category;
import com.ecommerce.ecommerce.entity.SubCategory;
import com.ecommerce.ecommerce.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public List<Category> getAll(){
        System.out.println("Get all categories ...");
        return categoryRepository.findAll(Sort.by("label").ascending());
    }
    public int number() {
        return categoryRepository.number();
    }
    public Optional<Category> findByCode(String code){
        return categoryRepository.findAllByCode(code);
    }
    public int max() {
        return categoryRepository.max();
    }
    public Long save(Category category){
        System.out.println("Save all categories");
        Category category1 = new Category();
        category1.setCode(category.getCode());
        category1.setLabel(category.getLabel());
        return categoryRepository.save(category1).getId();
    }
    public void update(String code, Category category){
        Optional<Category> category1
                = categoryRepository.findByCode(code);
    }

    public void delete(String code) {
        Optional<Category> category = categoryRepository.
                findByCode(code);
        category.ifPresent(categoryRepository::delete);
    }
}
