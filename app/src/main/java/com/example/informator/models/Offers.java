package com.example.informator.models;

public class Offers {
    private String brand;
    private String title;
    private String subTitle;
    private String imgUrl;
    private String brandLogoUrl;
    public Offers(String brand, String title, String subTitle, String imgUrl, String brandLogoUrl) {
        this.brand = brand;
        this.title = title;
        this.subTitle = subTitle;
        this.imgUrl = imgUrl;
        this.brandLogoUrl = brandLogoUrl;
    }

    public String getBrand() {
        return brand;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getBrandLogoUrl() {
        return brandLogoUrl;
    }

}
