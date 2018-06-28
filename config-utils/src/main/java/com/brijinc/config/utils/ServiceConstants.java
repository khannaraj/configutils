package com.brijinc.config.utils;

/**
 * This class contains the constants used in the Application Service COnfiguration Utility.
 * 
 * @author rkhanna
 * @since V 1.0
 * @version 1.0
 * 
 */
public final class ServiceConstants {

    /**
     * prefix of REST API
     */
    public static final String URI_API = "/api";

    public static final String URI_DATA = "/data";

    public static final String URI_SERVICES = "/services";

    private static final String PREFIX = "errors.";

    public static final String INVALID_REQUEST = PREFIX + "INVALID_REQUEST";

    public static final String HEALTH_CHECK_OK = "Server is Up!";
    /**
     * This is a utility class, it must not be instantiated.
     * 
     */
    private ServiceConstants() {
        throw new InstantiationError( "Must not instantiate this class" );
    }
    
}
