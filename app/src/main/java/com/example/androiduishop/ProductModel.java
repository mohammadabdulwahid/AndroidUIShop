package com.example.androiduishop;

public class ProductModel {

    String id, appName, appPrice, appOldPrice, appDesc, download, appThumb,imageOne,imageTwo, imageThree, imageFour, imageFive, imageSix, imageSeven, imageEight, imageNine, sale, status;

    public ProductModel() {
    }

    public ProductModel(String id, String appName, String appPrice, String appOldPrice, String appDesc, String download, String appThumb, String imageOne, String imageTwo, String imageThree, String imageFour, String imageFive, String imageSix, String imageSeven, String imageEight, String imageNine, String sale, String status) {
        this.id = id;
        this.appName = appName;
        this.appPrice = appPrice;
        this.appOldPrice = appOldPrice;
        this.appDesc = appDesc;
        this.download = download;
        this.appThumb = appThumb;
        this.imageOne = imageOne;
        this.imageTwo = imageTwo;
        this.imageThree = imageThree;
        this.imageFour = imageFour;
        this.imageFive = imageFive;
        this.imageSix = imageSix;
        this.imageSeven = imageSeven;
        this.imageEight = imageEight;
        this.imageNine = imageNine;
        this.sale = sale;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getAppName() {
        return appName;
    }

    public String getAppPrice() {
        return appPrice;
    }

    public String getAppOldPrice() {
        return appOldPrice;
    }

    public String getAppDesc() {
        return appDesc;
    }

    public String getDownload() {
        return download;
    }

    public String getAppThumb() {
        return appThumb;
    }

    public String getImageOne() {
        return imageOne;
    }

    public String getImageTwo() {
        return imageTwo;
    }

    public String getImageThree() {
        return imageThree;
    }

    public String getImageFour() {
        return imageFour;
    }

    public String getImageFive() {
        return imageFive;
    }

    public String getImageSix() {
        return imageSix;
    }

    public String getImageSeven() {
        return imageSeven;
    }

    public String getImageEight() {
        return imageEight;
    }

    public String getImageNine() {
        return imageNine;
    }

    public String getSale() {
        return sale;
    }

    public String getStatus() {
        return status;
    }
}
