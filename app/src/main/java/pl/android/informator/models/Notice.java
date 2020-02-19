package pl.android.informator.models;

import java.util.List;

public class Notice {
    private String title;
    private String price;
    private String mainImgUrl;
    private List<String> imgUrls;
    private String description;
    private int phoneNumber;

    public Notice(String title, String price, String mainImgUrl, List<String> imgUrls, String description, int phoneNumber) {
        this.title = title;
        this.price = price;
        this.mainImgUrl = mainImgUrl;
        this.imgUrls = imgUrls;
        this.description = description;
        this.phoneNumber = phoneNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getMainImgUrl() {
        return mainImgUrl;
    }

    public List<String> getImgUrls() {
        return imgUrls;
    }

    public String getDescription() {
        return description;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

}
