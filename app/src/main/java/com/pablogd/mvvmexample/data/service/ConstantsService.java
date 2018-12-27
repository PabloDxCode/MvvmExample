package com.pablogd.mvvmexample.data.service;

/**
 * ConstantService
 * Created by pablogutierrez on 06/09/18.
 */
public final class ConstantsService {

    /**
     * Constant for the request
     */
    public static final String TAG_REQUEST = "Request";
    /**
     * Constant for the response
     */
    public static final String TAG_RESPONSE = "Response";
    /**
     * Base URL of the application
     */
    static final String CODE_TIMEOUT = "320";
    /**
     * Code for response success
     */
    public static final String CODE_200 = "200";
    /**
     * Base URL of the application
     */
    static final String MESSAGE_TIMEOUT = "Se ha excedido el tiempo de conexión, vuelve a intentarlo.";
    /**
     * Base URL of the application
     */
    static final String MESSAGE_GENERIC = "Error en el servicio, vuelve a intentarlo.";
    /**
     * Read time out request
     */
    public static final int READ_TIME_OUT = 60;
    /**
     * Connection time out request
     */
    public static final int CONECTION_TIME_OUT = 60;
    /**
     * Constant for request simulation delay
     */
    public static final int REQUEST_SIMULATION_DELAY = 500;

    //---------------HEADERS--------------------//
    /**
     * header content type name
     */
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    /**
     * header authorization name
     */
    public static final String HEADER_AUTHORIZATION = "Authorization";
    /**
     * header application value
     */
    public static final String HEADER_APPLICATION = "application/json";
    /**
     * header key value
     */
    public static final String HEADER_KEY_VALUE = "Bearer ";

    //--------------- Operation id --------------------//

    /**
     * Operation id to register token
     */
    public static final String OPERATION_ID_REGISTER_TOKEN = "registerToken";
    /**
     * Operation id to get channels
     */
    public static final String OPERATION_ID_GET_CHANNELS = "getChannels";
    /**
     * Operation id to get last global notice
     */
    public static final String OPERATION_ID_GET_LAST_GLOBAL_NOTICE = "getLastGlobalNotice";
    /**
     * Operation id to get global notice
     */
    public static final String OPERATION_ID_GET_GLOBAL_NOTICE = "getGlobalNotices";
    /**
     * Operation id to get incidence types
     */
    public static final String OPERATION_ID_GET_INCIDENCE_TYPES = "getIncidenceTypes";
    /**
     * Operation id to get custom fields by channel
     */
    public static final String OPERATION_ID_GET_CUSTOM_FIELDS_BY_CHANNEL = "getCustomFieldsByChannel";
    /**
     * Operation id to insert incident
     */
    public static final String OPERATION_ID_INSERT_INCIDENT = "insertIncident";
    /**
     * Operation id to get notice by channel
     */
    public static final String OPERATION_ID_GET_NOTICE_BY_CHANNEL = "getNoticeByChannel";
    /**
     * Operation id to get incidents by channel
     */
    public static final String OPERATION_ID_GET_INCIDENTS_BY_CHANNEL = "getIncidentsByChannel";
    /**
     * Operation id to get my incidents by channel
     */
    public static final String OPERATION_ID_GET_MY_INCIDENTS_BY_CHANNEL = "getMyIncidentsByChannel";
    /**
     * Operation id to join incident
     */
    public static final String OPERATION_ID_JOIN_INCIDENT = "joinIncident";
    /**
     * Operation id to get incident
     */
    public static final String OPERATION_ID_GET_INCIDENT = "getIncident";
    /**
     * Operation id to get notifications
     */
    public static final String OPERATION_ID_GET_NOTIFICATIONS = "getNotifications";
    /**
     * Operation id to get incidents by user
     */
    public static final String OPERATION_ID_GET_INCIDENTS_BY_USER = "getIncidentsByUser";

}
