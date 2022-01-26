package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByCode(String code);
    List<Category> findAllByLabelContaining(String label);
    @Query(value = "SELECT count(code) FROM Category")
    public int number();
    @Query(value = "SELECT max(code) FROM Category")
    public int max();

    Optional<Category> findAllByCode(String code);
}
