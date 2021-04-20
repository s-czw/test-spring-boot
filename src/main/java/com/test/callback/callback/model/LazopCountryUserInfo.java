package com.test.callback.callback.model;

public class LazopCountryUserInfo {

    public String country;

    public String userId;

    public String sellerId;

    public String shortCode;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    @Override
    public String toString() {
        return "LazopCountryUserInfo{" +
                "country='" + country + '\'' +
                ", userId='" + userId + '\'' +
                ", sellerId='" + sellerId + '\'' +
                ", shortCode='" + shortCode + '\'' +
                '}';
    }
}
