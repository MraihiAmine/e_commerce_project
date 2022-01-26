package com.ecommerce.ecommerce.service;
import com.ecommerce.ecommerce.entity.Category;
import com.ecommerce.ecommerce.entity.SubCategory;
import com.ecommerce.ecommerce.repository.SubCategoryRepository;
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
public class SubCategoryService {
    @Autowired
    SubCategoryRepository subCategoryRepository;
    public List<SubCategory> getAll(){
        System.out.println("Get all Categories");
        return subCategoryRepository.findAll(Sort.by("label").ascending());
    }
    public Optional<SubCategory> findByCode(String code){
        return subCategoryRepository.findByCode(code);
    }
    public Long save(SubCategory subCategory){
        System.out.println("save all subcategories");
        SubCategory subCategory1 = new SubCategory();
        subCategory1.setCode(subCategory.getCode());
        subCategory1.setCodeCategory(subCategory.getCodeCategory());
        subCategory1.setLabel(subCategory.getLabel());
        return subCategoryRepository.save(subCategory1).getId();
    }
    public void update(String code, SubCategory subCategory){
        Optional<SubCategory> subCategory1 =
                subCategoryRepository.findByCode(code);
        if (subCategory1.isPresent()){
            SubCategory subCategory2 = subCategory1.get();
            subCategory2.setLabel(subCategory.getLabel());
            subCategoryRepository.save(subCategory2);
        }
    }
    public List<SubCategory> findByLabel(String label){
        return subCategoryRepository.findAllByLabelContaining(label);
    }
    public void delete(String code) {
        Optional<SubCategory> subCategory = subCategoryRepository.
                findByCode(code);
        subCategory.ifPresent(subCategoryRepository::delete);
    }
    public List<SubCategory> findByCodeCategory(String label){
        return subCategoryRepository.
                findAllByCodeCategory(label);
    }
}
