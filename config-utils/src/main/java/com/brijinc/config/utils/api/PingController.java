package com.brijinc.config.utils.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brijinc.config.utils.ServiceConstants;
import com.brijinc.config.utils.model.ResponseMessage;

/**
 * This is a ping controller, tests the health of the web server.
 * 
 * @author rkhanna
 * @since V 1.0
 * @version 1.0
 * 
 */
@RestController
@RequestMapping(value = ServiceConstants.URI_API)
public class PingController{
   
    /**
     * check if the network connecting is ok.
     * @return 
     */
    @RequestMapping("/ping")
    public ResponseEntity<ResponseMessage> ping() {    
        return new ResponseEntity<>(ResponseMessage.info(ServiceConstants.HEALTH_CHECK_OK), HttpStatus.OK);
    }
    
}
