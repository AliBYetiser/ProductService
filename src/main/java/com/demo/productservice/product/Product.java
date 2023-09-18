package com.demo.productservice.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table
@Data
@AllArgsConstructor
public class Product {
    @Id
    private Long id;

    private String name;
    private String code;
    private String description;
    private String brand;
    private String currency;
    private double price;
    private Boolean availability;

    public Product() {
    }
    public Product(String name,
                   String code,
                   String description,
                   String brand,
                   String currency,
                   double price,
                   Boolean availability) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.brand = brand;
        this.currency = currency;
        this.price = price;
        this.availability = availability;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", brand='" + brand + '\'' +
                ", currency='" + currency + '\'' +
                ", price=" + price +
                ", availability=" + availability +
                '}';
    }
}
