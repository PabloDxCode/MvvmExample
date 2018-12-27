package com.pablogd.mvvmexample.data.service;

import android.annotation.SuppressLint;
import android.support.annotation.VisibleForTesting;

import com.google.gson.Gson;
import com.pablogd.mvvmexample.app.utils.CustomRuntimeException;
import com.pablogd.mvvmexample.data.models.CommonResponse;
import com.pablogd.mvvmexample.domain.utils.LogUtils;

/**
 * class responsible for simulating server response
 * <p>
 * Created by mavila on 13/02/18.
 */
public final class SimulationServices<T> {

    /**
     * respon simulation
     */
    private static final String RESPONSE_SIMULATION_RAW = "RESPONSE SIMULATION RAW";
    /**
     * response simulation parse object
     */
    private static final String RESPONSE_SIMULATION_PARSE_OBJECT = "RESPONSE SIMULATION OBJECT";
    /**
     * final parse error
     */
    private static final String ERROR_PARSE = "ERROR PARSE";
    /**
     * response error
     */
    private static final String ERROR_PARSE_MESSAGE = "El objeto %object% no coincide con la respuesta \"%response%\"";
    /**
     * error
     */
    private static final String TAG_OBJECT = "%object%";
    /**
     * Error
     */
    private static final String TAG_RESPONSE = "%response%";
    /**
     * final string
     */
    private static final String TAG_ERROR_OUT = "Error OUT";
    /**
     * operation identifier
     */
    private final String idOperation;
    /**
     * repository listener
     */
    private final ResponseListener responseListener;
    /**
     * Gson
     */
    private final Gson gson;

    /**
     * class builder
     *
     * @param idOperation      operation identifier
     * @param responseListener repository listener
     */
    public SimulationServices(final String idOperation, final ResponseListener responseListener) {
        this.idOperation = idOperation;
        this.responseListener = responseListener;
        gson = new Gson();
    }

    /**
     * method to set the corresponding simulated response
     */
    @SuppressLint("LongLogTag")
    @VisibleForTesting
    @SuppressWarnings("unchecked")
    public void simulationResponse() {
        final String simulationResponse = EnvironmentConfig.getInstance().getResponse(idOperation);
        try {
            final T objectResult = (T) gson.fromJson(simulationResponse, responseListener.getTypeClass());
            if (objectResult == null) {
                throw new CustomRuntimeException();
            }
            LogUtils.build(RESPONSE_SIMULATION_RAW, simulationResponse).i();
            LogUtils.build(RESPONSE_SIMULATION_PARSE_OBJECT, objectResult.getClass().getCanonicalName()).i();
            responseListener.onRequestSuccessObj(objectResult);
        } catch (final CustomRuntimeException e) {
            LogUtils.build(ERROR_PARSE, responseListener.getTypeClass().getName() + TAG_ERROR_OUT + simulationResponse).e();
            LogUtils.build(ERROR_PARSE, e.getMessage()).e(e);

            final CommonResponse response = new CommonResponse();
            response.setCode(ConstantsService.CODE_TIMEOUT);
            response.setMessage(ERROR_PARSE_MESSAGE.replace(TAG_OBJECT, responseListener.getTypeClass().getCanonicalName()).replace(TAG_RESPONSE, simulationResponse));
            responseListener.onRequestFail(response);
        }
    }

}
