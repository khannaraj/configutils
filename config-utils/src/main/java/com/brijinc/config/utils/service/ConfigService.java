package com.brijinc.config.utils.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.brijinc.config.utils.exception.SystemConfigException;
import com.brijinc.config.utils.model.ServiceConfig;
import com.brijinc.config.utils.model.ServiceConfigDetails;
import com.brijinc.config.utils.model.ServiceConfigGroup;
import com.brijinc.config.utils.model.ServiceDetailList;
import com.brijinc.config.utils.model.ServiceDetails;
import com.brijinc.config.utils.model.ServiceProperty;
import com.brijinc.config.utils.utils.ConfigFileParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

/**
 * This class returns the service config data to the caller.
 * 
 * @author rkhanna
 * @since V 1.0
 * @version 1.0
 *
 */
@Service
public class ConfigService {

	public ServiceConfigDetails readServiceConfigDetails() {
		ServiceConfigDetails configs = null;
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		InputStream is = ConfigService.class.getClassLoader().getResourceAsStream("services.yaml");
		try {
			configs = mapper.readValue(is, ServiceConfigDetails.class);
		} catch (IOException e) {
			throw new SystemConfigException("Unexpected error occured", e);
		}
		return configs;
	}

	public ServiceDetailList getAllServices() {
		ServiceDetailList list = new ServiceDetailList();
		list.setServiceList(new ArrayList<ServiceDetails>());

		ServiceConfigDetails details = readServiceConfigDetails();
		for (ServiceConfigGroup group : details.getConfigs()) {
			ServiceDetails svc = constructServiceConfigDetails(group);
			list.getServiceList().add(svc);
		}
		return list;
	}

	private ServiceDetails constructServiceConfigDetails(ServiceConfigGroup group) {
		ServiceDetails svc = new ServiceDetails();
		svc.setId(group.getId());
		svc.setName(group.getName());
		svc.setCode(group.getCode());

		// This Code Need to be changed
		svc.setCreatedDate(new Date());
		svc.setStatus("COMPLETED");

		String[] svcCfgList = new String[group.getConfigs().size()];
		int idx = 0;
		for (ServiceConfig svcCfg : group.getConfigs()) {
			svcCfgList[idx++] = svcCfg.getName();
		}
		svc.setConfigGroups(svcCfgList);
		return svc;
	}

	public ServiceDetails findServiceById(Long id) {
		ServiceDetails serviceDetails = null;
		ServiceConfigDetails details = readServiceConfigDetails();
		for (ServiceConfigGroup group : details.getConfigs()) {
			if (group.getId() == id) {
				serviceDetails = constructServiceConfigDetails(group);
			}
		}
		return serviceDetails;
	}

	public ServiceDetails findServiceProperties(Long id, String type) {
		ServiceDetails serviceDetails = null;
		ServiceConfigDetails details = readServiceConfigDetails();
		for (ServiceConfigGroup group : details.getConfigs()) {
			if (group.getId() == id) {
				serviceDetails = constructServiceConfigDetails(group);
				setServiceProperties(serviceDetails, group, type);
			}
		}
		return serviceDetails;
	}

	private void setServiceProperties(ServiceDetails serviceDetails, ServiceConfigGroup group, String type) {
		for (ServiceConfig cfg : group.getConfigs()) {
			if (cfg.getName().equals(type)) {
				int size = cfg.getEnvs().size();
				int idx = 0;
				String[] envs = new String[size];

				Map<?, ?>[] allConfig = new Map[size];
				for (String key : cfg.getEnvs().keySet()) {
					String value = cfg.getEnvs().get(key);
					envs[idx] = key;
					allConfig[idx++] = ConfigFileParser.getConfigProperties(value);
				}
				serviceDetails.setEnvironments(envs);

				if (size > 0) {
					constructServiceProperties(serviceDetails, size, allConfig);
				} // end if
			}
		}
	}

	private void constructServiceProperties(ServiceDetails serviceDetails, int size, Map<?, ?>[] allConfig) {
		List<ServiceProperty> properties = new ArrayList<>();
		Map<String, String>firstConfig = (Map<String, String>)allConfig[0];
		for (Object currKey : firstConfig.keySet()) {
			String[] valuesArr = new String[size];
			for (int i = 0; i < size; i++) {
				Map<String, String>currentConfig = (Map<String, String>)allConfig[i];
				String value = currentConfig.get(currKey);
				valuesArr[i] = value;
			}
			ServiceProperty prop = new ServiceProperty();
			prop.setName((String)currKey);
			prop.setValues(valuesArr);
			properties.add(prop);
		} // end for
		ServiceProperty[] svcPropertyArr = new ServiceProperty[properties.size()];
		serviceDetails.setProperties(properties.toArray(svcPropertyArr));
	}
}
