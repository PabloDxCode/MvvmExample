package com.pablogd.mvvmexample.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * TestingResponse
 * Created by pablogutierrez on 20/12/18.
 */
public class TestingResponse {

    /**
     * Method to get response to test
     *
     * @return map
     */
    public static Map<String, String> getTestResponse() {
        final Map<String, String> simulationResponse = new HashMap<>();
        simulationResponse.put("1", "{\n" +
                "  \"args\": {}, \n" +
                "  \"headers\": {\n" +
                "    \"Accept\": \"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8\", \n" +
                "    \"Accept-Encoding\": \"gzip, deflate, br\", \n" +
                "    \"Accept-Language\": \"es-ES,es;q=0.9,en;q=0.8\", \n" +
                "    \"Connection\": \"close\", \n" +
                "    \"Host\": \"httpbin.org\", \n" +
                "    \"Upgrade-Insecure-Requests\": \"1\", \n" +
                "    \"User-Agent\": \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36\"\n" +
                "  }, \n" +
                "  \"origin\": \"177.231.48.206\", \n" +
                "  \"url\": \"https://httpbin.org/get\"\n" +
                "}");
        return simulationResponse;
    }

    /**
     * Method to get response to test
     *
     * @return map
     */
    public static Map<String, String> getTestResponseError() {
        final Map<String, String> simulationResponseError = new HashMap<>();
        simulationResponseError.put("1", "");
        return simulationResponseError;
    }

}
