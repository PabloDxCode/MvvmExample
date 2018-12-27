package com.pablogd.mvvmexample.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.pablogd.mvvmexample.data.service.ConstantsService;
import com.pablogd.mvvmexample.domain.utils.LogUtils;

import java.io.IOException;
import java.io.Serializable;

import okhttp3.ResponseBody;

/**
 * CommonResponse
 * Created by pablogutierrez on 06/09/18.
 */
public class CommonResponse implements Serializable {

    private static final long serialVersionUID = 5668931730077541633L;

    /**
     * Value code Response
     */
    @SerializedName("code")
    @Expose
    private String code;

    /**
     * Value messageResponse
     */
    @SerializedName("message")
    @Expose
    private String message;

    /**
     * No args constructor for use in serialization
     */
    public CommonResponse() {
        //No args constructor for use in serialization
    }

    /**
     * Method that chooses the response code of the server
     *
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * Method that sets the response code of the server
     *
     * @param code code
     */
    public void setCode(final String code) {
        this.code = code;
    }

    /**
     * Method that gets the response message from the server
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Method that sets the response message of the server
     *
     * @param message message app
     */
    public void setMessage(final String message) {
        this.message = message;
    }

    /**
     * response constructor
     *
     * @param responseBody body response
     */
    public CommonResponse(final ResponseBody responseBody) {
        String json;
        try {
            json = responseBody.string();
            LogUtils.build(ConstantsService.TAG_RESPONSE, json).i();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Class builder method
     *
     * @param code    server response code
     * @param message message from server
     */
    public CommonResponse(final String code, final String message) {
        super();
        this.code = code;
        this.message = message;
    }

}
