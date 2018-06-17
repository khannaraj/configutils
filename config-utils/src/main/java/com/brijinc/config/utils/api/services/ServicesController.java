package com.brijinc.config.utils.api.services;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brijinc.config.utils.ServiceConstants;
import com.brijinc.config.utils.model.ServiceDetailList;
import com.brijinc.config.utils.model.ServiceDetails;
import com.brijinc.config.utils.service.ConfigService;

/**
 * This controller returns the list of services.
 * 
 * @author rkhanna
 * @since V 1.0
 * @version 1.0
 *
 */
@RestController
@RequestMapping(value = ServiceConstants.URI_API + ServiceConstants.URI_SERVICES)
public class ServicesController {

	private static final Logger log = LoggerFactory.getLogger(ServicesController.class);

	private ConfigService configService;

	@Inject
	public ServicesController(ConfigService configService) {
		this.configService = configService;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ServiceDetailList> getAllServices() {
		log.debug("get all services of page");

		ServiceDetailList services = configService.getAllServices();

		return new ResponseEntity<>(services, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ServiceDetails> getService(@PathVariable("id") Long id) {

		log.debug("get service info by id @");

		ServiceDetails service = configService.findServiceById(id);

		return new ResponseEntity<>(service, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/{type}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ServiceDetails> getServiceProperties(@PathVariable("id") Long id,
			@PathVariable("type") String type) {

		log.debug("get service info by id and type @");

		ServiceDetails service = configService.findServiceProperties(id, type);

		return new ResponseEntity<>(service, HttpStatus.OK);
	}

}
