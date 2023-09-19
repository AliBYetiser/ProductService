package com.demo.productservice.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository underTest;
    @Test
    void findById() {
        //given
        Product product = new Product(
                999L,
                "Redmi",
                "RXAO1",
                "a smartphone",
                "Xiaomi",
                "TRY",
                10.1,
                true);
        underTest.save(product);
        //when
        Optional<Product> result = underTest.findById(product.getId());
        //then
        assertThat(result).isNotNull();
    }
}