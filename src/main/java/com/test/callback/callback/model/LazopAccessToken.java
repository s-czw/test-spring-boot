package com.test.callback.callback.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LazopAccessToken {

    @Id
    public String storer;

    // json response parameters
    public String code;

    public String country;

    public String account;

    @JsonProperty("request_id")
    public String requestId;

    @JsonProperty("account_platform")
    public String accountPlatform;

    @JsonProperty("access_token")
    public String accessToken;

    @JsonProperty("refresh_token")
    public String refreshToken;

    @JsonProperty("expires_in")
    public long expiresIn;

    @JsonProperty("refresh_expires_in")
    public long refreshExpiresIn;

    @JsonProperty("country_user_info")
    public List<LazopCountryUserInfo> countryUserInfo;

    // self-defined parameters
    public Date scheduledRefreshDate;

    public Date createdOn;

    public Date updatedOn;

    public boolean isError;

    public String errorMessage;

    public String getStorer() {
        return storer;
    }

    public void setStorer(String storer) {
        this.storer = storer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getAccountPlatform() {
        return accountPlatform;
    }

    public void setAccountPlatform(String accountPlatform) {
        this.accountPlatform = accountPlatform;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public long getRefreshExpiresIn() {
        return refreshExpiresIn;
    }

    public void setRefreshExpiresIn(long refreshExpiresIn) {
        this.refreshExpiresIn = refreshExpiresIn;
    }

    public List<LazopCountryUserInfo> getCountryUserInfo() {
        if (countryUserInfo == null) {
            countryUserInfo = new ArrayList<>();
        }
        return countryUserInfo;
    }

    public void setCountryUserInfo(List<LazopCountryUserInfo> countryUserInfo) {
        this.countryUserInfo = countryUserInfo;
    }

    public Date getScheduledRefreshDate() {
        return scheduledRefreshDate;
    }

    public void setScheduledRefreshDate(Date scheduledRefreshDate) {
        this.scheduledRefreshDate = scheduledRefreshDate;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "LazopAccessToken{" +
                "storer='" + storer + '\'' +
                ", code='" + code + '\'' +
                ", country='" + country + '\'' +
                ", account='" + account + '\'' +
                ", requestId='" + requestId + '\'' +
                ", accountPlatform='" + accountPlatform + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", expiresIn=" + expiresIn +
                ", refreshExpiresIn=" + refreshExpiresIn +
                ", countryUserInfo=" + countryUserInfo +
                ", scheduledRefreshDate=" + scheduledRefreshDate +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", isError=" + isError +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
