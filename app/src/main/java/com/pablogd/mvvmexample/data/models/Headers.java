package com.pablogd.mvvmexample.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Headers
 * Created by pablogutierrez on 17/12/18.
 */
public class Headers {

    @SerializedName("Accept")
    @Expose
    private String accept;
    @SerializedName("Accept-Encoding")
    @Expose
    private String acceptEncoding;
    @SerializedName("Accept-Language")
    @Expose
    private String acceptLanguage;
    @SerializedName("Connection")
    @Expose
    private String connection;
    @SerializedName("Host")
    @Expose
    private String host;
    @SerializedName("Upgrade-Insecure-Requests")
    @Expose
    private String upgradeInsecureRequests;
    @SerializedName("User-Agent")
    @Expose
    private String userAgent;

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    public void setAcceptEncoding(String acceptEncoding) {
        this.acceptEncoding = acceptEncoding;
    }

    public String getAcceptLanguage() {
        return acceptLanguage;
    }

    public void setAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUpgradeInsecureRequests() {
        return upgradeInsecureRequests;
    }

    public void setUpgradeInsecureRequests(String upgradeInsecureRequests) {
        this.upgradeInsecureRequests = upgradeInsecureRequests;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

}
