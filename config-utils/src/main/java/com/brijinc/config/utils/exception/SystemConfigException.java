package com.brijinc.config.utils.exception;

import java.io.IOException;

/**
 * Exception used in the case of invalid request.
 * 
 * @author rkhanna
 * @since V 1.0
 * @version 1.0
 * 
 */
public class SystemConfigException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SystemConfigException(String msg, IOException e) {
    	super(msg, e);
	}

}
