package com.shaokat.model;

public class ProductStatistics {
    private Product productTrack;
    private double unitSlod;
    private double profitPercentage;

    public Product getProductTrack() {
        return productTrack;
    }

    public void setProductTrack(Product productTrack) {
        this.productTrack = productTrack;
    }

    public double getUnitSlod() {
        return unitSlod;
    }

    public void setUnitSlod(double unitSlod) {
        this.unitSlod = unitSlod;
    }

    public double getProfitPercentage() {
        return profitPercentage;
    }

    public void setProfitPercentage(double profitPercentage) {
        this.profitPercentage = profitPercentage;
    }
}
