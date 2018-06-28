/**
 * 
 */
package com.brijinc.config.utils.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class returns the Service Details List to the caller.
 * 
 * @author rkhanna
 * @since V 1.0
 * @version 1.0
 *
 */
public class ServiceDetailList implements Serializable {

	/**
	 * Generated serial version ID
	 */
	private static final long serialVersionUID = 453325556585799578L;

	private List<ServiceDetails> serviceList = new ArrayList<>();

	public int getTotalElements() {
		return this.serviceList.size();
	}
	
	/**
	 * @return the serviceList
	 */
	public List<ServiceDetails> getServiceList() {
		return serviceList;
	}

	/**
	 * @param serviceList the serviceList to set
	 */
	public void setServiceList(List<ServiceDetails> serviceList) {
		this.serviceList = serviceList;
	}
}
