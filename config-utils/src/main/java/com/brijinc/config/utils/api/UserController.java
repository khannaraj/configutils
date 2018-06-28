package com.brijinc.config.utils.api;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brijinc.config.utils.ServiceConstants;

/**
 * This controller returns the authenticated user information.
 * 
 * @author rkhanna
 * @since V1.0
 * @version 1.0
 */
@RestController
@RequestMapping(value = ServiceConstants.URI_API)
public class UserController {
    
    /**
     * Get the authenticated user info.
     * 
     * @param principal
     * @return 
     */
    @RequestMapping("/login")
    public ResponseEntity<Map<String, Object>> user(Principal principal) {
        
        Map<String, Object> map = new HashMap<>();
        map.put("username", principal.getName());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    
   
}
