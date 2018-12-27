package com.pablogd.mvvmexample.data.service;

import android.content.Context;

import com.pablogd.mvvmexample.env.Environment;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * EnvironmentConfig
 * Created by pablogutierrez on 17/12/18.
 */
public final class EnvironmentConfig {

    private static EnvironmentConfig ourInstance;

    private Map<String, String> mSimulationResponse;

    private EnvironmentConfig() {
        mSimulationResponse = new HashMap<>();
    }

    public static EnvironmentConfig getInstance(){
        if(ourInstance == null){
            ourInstance = new EnvironmentConfig();
        }
        return ourInstance;
    }

    public void initSimulation(final Context context){
        if(Environment.SIMULATION) {
            final Properties properties = SimulationUtils.getInstance().init(context);
            for (final String item : properties.stringPropertyNames()) {
                mSimulationResponse.put(item, properties.getProperty(item));
            }
        }
    }

    public void initSimulation(Map<String, String> simulationResponse){
        mSimulationResponse = simulationResponse;
    }

    public String getResponse(final String id){
        return mSimulationResponse.get(id);
    }

}
