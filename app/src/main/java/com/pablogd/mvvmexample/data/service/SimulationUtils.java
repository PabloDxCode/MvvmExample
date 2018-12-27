package com.pablogd.mvvmexample.data.service;

import android.content.Context;
import android.content.res.AssetManager;

import com.pablogd.mvvmexample.domain.utils.LogUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * SimulationUtils
 * Created by pablogutierrez on 17/12/18.
 */
public class SimulationUtils {

    /**
     * Tag for class
     */
    private final String TAG = SimulationUtils.class.getSimpleName();
    /**
     * Actual instance
     */
    private static SimulationUtils ourInstance;
    /**
     * Name of properties to load
     */
    private static final String NAME_PROPERTIES_SIMULATION = "simulation.properties";
    /**
     * Instance to properties
     */
    private final Properties properties = new Properties();
    /**
     * Instance to assetManager
     */
    private AssetManager assetManager;

    /**
     * Return actual instance
     *
     * @return actual instance
     */
    public static SimulationUtils getInstance() {
        if(ourInstance == null){
            ourInstance = new SimulationUtils();
        }
        return ourInstance;
    }

    /**
     * Private constructor
     */
    private SimulationUtils() {
        //Empty constructor
    }

    /**
     * Method to init properties reader
     */
    public Properties init(final Context context) {
        if (assetManager == null) {
            try {
                assetManager = context.getAssets();
                final InputStream inputStream = assetManager.open(NAME_PROPERTIES_SIMULATION);
                properties.load(inputStream);
            } catch (final IOException e) {
                LogUtils.build(TAG, e.getMessage()).e(e);
            }
        }
        return properties;
    }

}
