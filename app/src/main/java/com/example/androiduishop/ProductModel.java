package com.example.androiduishop;

public class ProductModel {

    String appName, appPrice, appImgLink;

    public ProductModel() {
    }

    public ProductModel(String appName, String appPrice, String appImgLink) {
        this.appName = appName;
        this.appPrice = appPrice;
        this.appImgLink = appImgLink;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppPrice() {
        return appPrice;
    }

    public void setAppPrice(String appPrice) {
        this.appPrice = appPrice;
    }

    public String getAppImgLink() {
        return appImgLink;
    }

    public void setAppImgLink(String appImgLink) {
        this.appImgLink = appImgLink;
    }
}
