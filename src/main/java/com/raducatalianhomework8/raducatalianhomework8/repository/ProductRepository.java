package com.raducatalianhomework8.raducatalianhomework8.repository;

import com.raducatalianhomework8.raducatalianhomework8.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAll();
    Optional<Product> findByCode(Integer code);
    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.deleted = true WHERE p.code = :code")
    void deleteProductByCode(Integer code);

    @Query("SELECT p FROM Product p WHERE p.deleted = false")
    List<Product> getRemainingProducts();

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.stock = :stock WHERE p.code = :code")
    void update(Integer code, Integer stock);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.stock = p.stock - 1 WHERE p.code = :code")
    void decrement(Integer code);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.stock = p.stock + 1 WHERE p.code = :code")
    void increment(Integer code);
}
