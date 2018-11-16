
package skipcreative.com.depop.Model.bean;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Object {

    @SerializedName("price_currency")
    @Expose
    private String priceCurrency;
    @SerializedName("variant_set")
    @Expose
    private int variantSet;
    @SerializedName("pictures_data")
    @Expose
    private List<PicturesDatum> picturesData = null;
    @SerializedName("quantity")
    @Expose
    private int quantity;
    @SerializedName("created_date")
    @Expose
    private String createdDate;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("brand_id")
    @Expose
    private java.lang.Object brandId;
    @SerializedName("active_status")
    @Expose
    private String activeStatus;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("pub_date")
    @Expose
    private String pubDate;
    @SerializedName("national_shipping_cost")
    @Expose
    private String nationalShippingCost;
    @SerializedName("user_id")
    @Expose
    private int userId;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("hand_delivery")
    @Expose
    private boolean handDelivery;
    @SerializedName("international_shipping_cost")
    @Expose
    private String internationalShippingCost;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("purchase_via_paypal")
    @Expose
    private boolean purchaseViaPaypal;
    @SerializedName("categories")
    @Expose
    private List<Integer> categories = null;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("videos")
    @Expose
    private java.lang.Object videos;
    @SerializedName("user_data")
    @Expose
    private UserData userData;
    @SerializedName("variants")
    @Expose
    private Variants variants;
    @SerializedName("price_amount")
    @Expose
    private String priceAmount;

    public String getPriceCurrency() {
        return priceCurrency;
    }

    public void setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
    }

    public int getVariantSet() {
        return variantSet;
    }

    public void setVariantSet(int variantSet) {
        this.variantSet = variantSet;
    }

    public List<PicturesDatum> getPicturesData() {
        return picturesData;
    }

    public void setPicturesData(List<PicturesDatum> picturesData) {
        this.picturesData = picturesData;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public java.lang.Object getBrandId() {
        return brandId;
    }

    public void setBrandId(java.lang.Object brandId) {
        this.brandId = brandId;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getNationalShippingCost() {
        return nationalShippingCost;
    }

    public void setNationalShippingCost(String nationalShippingCost) {
        this.nationalShippingCost = nationalShippingCost;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isHandDelivery() {
        return handDelivery;
    }

    public void setHandDelivery(boolean handDelivery) {
        this.handDelivery = handDelivery;
    }

    public String getInternationalShippingCost() {
        return internationalShippingCost;
    }

    public void setInternationalShippingCost(String internationalShippingCost) {
        this.internationalShippingCost = internationalShippingCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isPurchaseViaPaypal() {
        return purchaseViaPaypal;
    }

    public void setPurchaseViaPaypal(boolean purchaseViaPaypal) {
        this.purchaseViaPaypal = purchaseViaPaypal;
    }

    public List<Integer> getCategories() {
        return categories;
    }

    public void setCategories(List<Integer> categories) {
        this.categories = categories;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public java.lang.Object getVideos() {
        return videos;
    }

    public void setVideos(java.lang.Object videos) {
        this.videos = videos;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public Variants getVariants() {
        return variants;
    }

    public void setVariants(Variants variants) {
        this.variants = variants;
    }

    public String getPriceAmount() {
        return priceAmount;
    }

    public void setPriceAmount(String priceAmount) {
        this.priceAmount = priceAmount;
    }

}
