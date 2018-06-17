package com.brijinc.config.utils.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class contains the service config details info.
 * 
 * @author rkhanna
 * @since V 1.0
 * @version 1.0
 *
 */
public class ServiceConfigDetails {
	
    @JsonProperty
    private List<ServiceConfigGroup> configs;

	/**
	 * @return the configs
	 */
	public List<ServiceConfigGroup> getConfigs() {
		return configs;
	}

	/**
	 * @param configs the configs to set
	 */
	public void setConfigs(List<ServiceConfigGroup> configs) {
		this.configs = configs;
	}
	
}
