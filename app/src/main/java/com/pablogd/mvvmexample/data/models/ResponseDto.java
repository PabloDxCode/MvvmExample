package com.pablogd.mvvmexample.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * ResponseDto
 * Created by pablogutierrez on 17/12/18.
 */
public class ResponseDto {

    @SerializedName("args")
    @Expose
    private Args args;
    @SerializedName("headers")
    @Expose
    private Headers headers;
    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("url")
    @Expose
    private String url;

    public Args getArgs() {
        return args;
    }

    public void setArgs(Args args) {
        this.args = args;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
