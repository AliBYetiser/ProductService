package com.demo.productservice.product;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }
    public Optional<Product> getById(Long id){
        return productRepository.findById(id);
    }

    public List<Product> getByName(String name){
        return productRepository.findAllByNameContainingIgnoreCase(name);
    }
    public List<Product> getByCode(String code){
        return productRepository.findAllByCodeContainingIgnoreCase(code);
    }
    public List<Product> getByBrand(String brand){
        return productRepository.findAllByBrandContainingIgnoreCase(brand);
    }
    public List<Product> getByPriceRange(double priceLessThan, double priceGreaterThan){
        return productRepository.findAllByPriceLessThanEqualAndPriceGreaterThanEqual(priceLessThan, priceGreaterThan);
    }
    public Product createProduct(Product product){
        if (productRepository.findById(product.getId()).isPresent()){
            return null;
        }else {
            productRepository.save(product);
        }
        return product;
    }
    public Product updateProductById(Product product){
        Optional<Product> product1 = getById(product.getId());
        if (product1.isPresent()) {
            Product existingProduct = product1.get();
            existingProduct.setAvailability(product.getAvailability());
            existingProduct.setCode(product.getCode());
            existingProduct.setName(product.getName());
            existingProduct.setBrand(product.getBrand());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setCurrency(product.getCurrency());
            existingProduct.setPrice(product.getPrice());

            productRepository.save(existingProduct);
            return existingProduct;
        }
        return null;
    }

    @Modifying
    @Transactional
    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return productRepository.existsById(id);
    }
}
