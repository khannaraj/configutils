package com.brijinc.config.utils.model;

import java.io.Serializable;

/**
 * The model object for the service details.
 * 
 * @author rkhanna
 * @since V 1.0
 * @version 1.0
 *
 */
public class ServiceProperty implements Serializable {

	/**
	 * Generated Seial Version ID
	 */
	private static final long serialVersionUID = 7013762677852306566L;

	private String name;
	
	private String[] values;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the values
	 */
	public String[] getValues() {
		return values;
	}

	/**
	 * @param values the values to set
	 */
	public void setValues(String[] values) {
		this.values = values;
	}
}
