package com.pablogd.mvvmexample.data.service;

import com.pablogd.mvvmexample.data.models.CommonResponse;

/**
 * Interfaz que esta a la escucha de la respuesta de los servicios
 * Created by evaltierrah on 20/08/17.
 */

public interface ResponseListener<T> {

    /**
     * Method that is executed when the answer is correct
     *
     * @param responseObject Response object type
     */
    void onRequestSuccessObj(final T responseObject);

    /**
     * Method that is executed when the request fails
     *
     * @param error response error
     */
    void onRequestFail(final CommonResponse error);

    /**
     * Method that makes the call to the request
     */
    void invokeNetwork();

    /**
     * Method to get class type
     *
     * @return class
     */
    Class getTypeClass();

}
