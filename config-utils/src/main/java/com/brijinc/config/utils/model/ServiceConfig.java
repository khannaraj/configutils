package com.brijinc.config.utils.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class contains the service config details.
 * 
 * @author rkhanna
 * @since V 1.0
 * @version 1.0
 *
 */
public class ServiceConfig {

	@JsonProperty
	private String name;
	
    @JsonProperty
    private Map<String, String> envs;

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
	 * @return the envs
	 */
	public Map<String, String> getEnvs() {
		return envs;
	}

	/**
	 * @param envs the envs to set
	 */
	public void setEnvs(Map<String, String> envs) {
		this.envs = envs;
	}


}
