package net.gustavohenrique.tutorial.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserConnection")
public class UserConnection implements Serializable {

    private static final long serialVersionUID = -4890719852592623160L;

    @Id
    @Column(name="userId")
    private String userId;
    
    @Id
    @Column(name="providerId", nullable=false)
    private String providerId;
    
    @Id
    @Column(name="providerUserId")
    private String providerUserId;
    
    @Column(name="rank", nullable=false)
    private Integer rank;
    
    @Column(name="displayName")
    private String displayName;
    
    @Column(name="profileUrl")
    private String profileUrl;
    
    @Column(name="imageUrl")
    private String imageUrl;
    
    @Column(name="accessToken", nullable=false)
    private String accessToken;
    
    @Column(name="secret")
    private String secret;
    
    @Column(name="refreshToken")
    private String refreshToken;
    
    @Column(name="expireTime")
    private Long expireTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProviderUserId() {
        return providerUserId;
    }

    public void setProviderUserId(String providerUserId) {
        this.providerUserId = providerUserId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }
    
}
