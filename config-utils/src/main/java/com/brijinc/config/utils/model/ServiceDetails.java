/**
 * 
 */
package com.brijinc.config.utils.model;

import java.io.Serializable;
import java.util.Date;

/**
 * The model object for the service details.
 * 
 * @author rkhanna
 * @since V 1.0
 * @version 1.0
 *
 */
public class ServiceDetails implements Serializable {

	/**
    * Generated Serial Version ID.
    */
	private static final long serialVersionUID = 5751093226726373180L;

    private Long id;

    private String code;

    private String name;

    private String status;

    private Date createdDate;

    private String[] configGroups;

    private String[] environments;
    
	private ServiceProperty[] properties;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getStatus() {
        return status;
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

	public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "PostDetails{" + "id=" + id + ", status=" + status + ", createdDate=" + createdDate + '}';
    }

	public String[] getEnvironments() {
		return environments;
	}

	public void setEnvironments(String[] environments) {
		this.environments = environments;
	}

	public ServiceProperty[] getProperties() {
		return properties;
	}

	public void setProperties(ServiceProperty[] properties) {
		this.properties = properties;
	}

	/**
	 * @return the configGroups
	 */
	public String[] getConfigGroups() {
		return configGroups;
	}

	/**
	 * @param configGroups the configGroups to set
	 */
	public void setConfigGroups(String[] configGroups) {
		this.configGroups = configGroups;
	}

}
