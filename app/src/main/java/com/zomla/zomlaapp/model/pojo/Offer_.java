
package com.zomla.zomlaapp.model.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Offer_ {

    @SerializedName("offer_id")
    @Expose
    private Integer offerId;
    @SerializedName("voucher_id")
    @Expose
    private Integer voucherId;
    @SerializedName("offer_text")
    @Expose
    private String offerText;
    @SerializedName("date_added")
    @Expose
    private String dateAdded;
    @SerializedName("added_by")
    @Expose
    private Integer addedBy;
    @SerializedName("is_active")
    @Expose
    private Integer isActive;
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("end_date")
    @Expose
    private String endDate;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("disclaimer")
    @Expose
    private String disclaimer;
    @SerializedName("restaurants")
    @Expose
    private List<String> restaurants = null;
    @SerializedName("restaurant_list")
    @Expose
    private List<Object> restaurantList = null;
    @SerializedName("share_url")
    @Expose
    private String shareUrl;
    @SerializedName("is_valid")
    @Expose
    private Integer isValid;
    @SerializedName("impressions")
    @Expose
    private Integer impressions;
    @SerializedName("type_code")
    @Expose
    private Integer typeCode;
    @SerializedName("is_editable")
    @Expose
    private Integer isEditable;
    @SerializedName("friendly_start_date")
    @Expose
    private String friendlyStartDate;
    @SerializedName("friendly_end_date")
    @Expose
    private String friendlyEndDate;
    @SerializedName("applicable_on")
    @Expose
    private Integer applicableOn;
    @SerializedName("offer_type")
    @Expose
    private String offerType;

    public Integer getOfferId() {
        return offerId;
    }

    public void setOfferId(Integer offerId) {
        this.offerId = offerId;
    }

    public Integer getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Integer voucherId) {
        this.voucherId = voucherId;
    }

    public String getOfferText() {
        return offerText;
    }

    public void setOfferText(String offerText) {
        this.offerText = offerText;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Integer getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(Integer addedBy) {
        this.addedBy = addedBy;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public List<String> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<String> restaurants) {
        this.restaurants = restaurants;
    }

    public List<Object> getRestaurantList() {
        return restaurantList;
    }

    public void setRestaurantList(List<Object> restaurantList) {
        this.restaurantList = restaurantList;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public Integer getImpressions() {
        return impressions;
    }

    public void setImpressions(Integer impressions) {
        this.impressions = impressions;
    }

    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    public Integer getIsEditable() {
        return isEditable;
    }

    public void setIsEditable(Integer isEditable) {
        this.isEditable = isEditable;
    }

    public String getFriendlyStartDate() {
        return friendlyStartDate;
    }

    public void setFriendlyStartDate(String friendlyStartDate) {
        this.friendlyStartDate = friendlyStartDate;
    }

    public String getFriendlyEndDate() {
        return friendlyEndDate;
    }

    public void setFriendlyEndDate(String friendlyEndDate) {
        this.friendlyEndDate = friendlyEndDate;
    }

    public Integer getApplicableOn() {
        return applicableOn;
    }

    public void setApplicableOn(Integer applicableOn) {
        this.applicableOn = applicableOn;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

}
