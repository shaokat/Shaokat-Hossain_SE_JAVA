package com.shaokat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public  class  Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private double productPrice;

    private ProductType productType;
    @NotNull
    private String productName;

    private double profitPercentage;
    private ProductType pType;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProductType getpType() {
        return pType;
    }

    public void setpType(ProductType pType) {
        this.pType = pType;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProfitPercentage() {
        return profitPercentage;
    }

    public void setProfitPercentage(double profitPercentage) {
        this.profitPercentage = profitPercentage;
    }
}
