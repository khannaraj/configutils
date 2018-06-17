package com.brijinc.config.utils.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

import com.brijinc.config.utils.ServiceConstants;

/**
 * This class load the application properties.
 * 
 * @author rkhanna
 * @since V 1.0
 * @version 1.0
 *
 */
@Configuration
@ComponentScan(
    basePackageClasses = {ServiceConstants.class},
    excludeFilters = {
        @Filter(
            type = FilterType.ANNOTATION,
            value = {
                RestController.class,
                ControllerAdvice.class,
                Configuration.class
            }
        )
    }
)
@PropertySource("classpath:/app.properties")
@PropertySource(value = "classpath:/database.properties", ignoreResourceNotFound = true)
public class AppConfig {

}
