package com.brijinc.config.utils.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class contains the service config Group info.
 * 
 * @author rkhanna
 * @since V 1.0
 * @version 1.0
 *
 */
public class ServiceConfigGroup {

	@JsonProperty
	private String name;

	@JsonProperty
	private String code;

	@JsonProperty
	private Long id;
	
    @JsonProperty
    private List<ServiceConfig> configs;

	/**
	 * @return the configs
	 */
	public List<ServiceConfig> getConfigs() {
		return configs;
	}

	/**
	 * @param configs the configs to set
	 */
	public void setConfigs(List<ServiceConfig> configs) {
		this.configs = configs;
	}

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
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

}
