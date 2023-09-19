package com.demo.productservice.product;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    List<Product> findAllByNameContainingIgnoreCase(String name);
    List<Product> findAllByCodeContainingIgnoreCase(String code);
    List<Product> findAllByBrandContainingIgnoreCase(String brand);
    List<Product> findAllByPriceLessThanEqualAndPriceGreaterThanEqual(double priceLessThan, double priceGreaterThan);

    @Modifying
    @Transactional
    void deleteById(Long id);

    boolean existsById(Long id);

}
