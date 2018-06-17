
package com.brijinc.config.utils.exception;

/**
 * This exception is used when resources are not found.
 * 
 * @author rkhanna
 * @since V 1.0
 * @version 1.0
 */
public class ResourceNotFoundException extends RuntimeException {


    /**
	 * Generated Serial Version ID
	 */
	private static final long serialVersionUID = 1959890681723079721L;
	
	final Long id;

    public ResourceNotFoundException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
