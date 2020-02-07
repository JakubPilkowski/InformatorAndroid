package pl.android.informator.models;

public class Offer {
    private String brand;
    private String title;
    private String descTitle;
    private String imgUrl;
    private String brandLogoUrl;
    private String desc;
    private String siteUri;


    public Offer(String brand, String title, String descTitle, String imgUrl, String brandLogoUrl, String desc, String siteUri) {
        this.brand = brand;
        this.title = title;
        this.descTitle = descTitle;
        this.imgUrl = imgUrl;
        this.brandLogoUrl = brandLogoUrl;
        this.desc = desc;
        this.siteUri = siteUri;
    }

    public String getBrand() {
        return brand;
    }

    public String getTitle() {
        return title;
    }

    public String getDescTitle() {
        return descTitle;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getBrandLogoUrl() {
        return brandLogoUrl;
    }

    public String getDesc() {
        return desc;
    }

    public String getSiteUri() {
        return siteUri;
    }
}
