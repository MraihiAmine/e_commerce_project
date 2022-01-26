package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubCategoryRepository
        extends JpaRepository<SubCategory, Long> {
    Optional<SubCategory> findByCode(String code);

    List<SubCategory> findAllByLabelContaining(String label);

    List<SubCategory> findAllByCodeCategory(String label);
}
