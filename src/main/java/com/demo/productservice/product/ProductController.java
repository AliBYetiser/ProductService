package com.demo.productservice.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("get-all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("get-by-id")
    public Optional<Product> getProductsById(Long id){
        return productService.getById(id);
    }

    @GetMapping("get-by-name")
    public List<Product> getProductsByName(String name){
        return productService.getByName(name);
    }
    @GetMapping("get-by-code")
    public List<Product> getProductsByCode(String code){
        return productService.getByCode(code);
    }
    @GetMapping("get-by-brand")
    public List<Product> getProductsByBrand(String brand){
        return productService.getByBrand(brand);
    }
    @GetMapping("get-by-price-range")
    public List<Product> getProductsByPriceRange(double priceLessThan, double priceGreaterThan){
        return productService.getByPriceRange(priceLessThan, priceGreaterThan);
    }
    @PostMapping("create-product")
    public ResponseEntity<Product> createProduct(Product product){
        Product product1 = productService.createProduct(product);
        if (product1 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
    }


    @PutMapping("update-by-id")
    public ResponseEntity<Product> updateById(Product product){
        Product product1 = productService.updateProductById(product);
        if (product1 == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
    }
    @DeleteMapping("delete-by-id")
    public ResponseEntity<Long> deleteById(Long id){
        if (productService.existsById(id)){
            productService.deleteProductById(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
