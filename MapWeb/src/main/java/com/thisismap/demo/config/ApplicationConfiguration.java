package com.thisismap.demo.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Class <tt>ApplicationConfiguration</tt>
 */
@Configuration
@PropertySource(value = {"classpath:project.properties"})
@ImportResource({
        "classpath:/spring/db.xml"
})
public class ApplicationConfiguration {

    @Autowired
    private Environment environment;

    public @Bean
    Map<String, String> resourcesExcludedFromMVC() {
        Map<String, String> resources = new HashMap<String, String>();
        resources.put("/*.html", "/");
        resources.put("/robots.txt", "/");
        resources.put("/favicon.ico", "/");
        resources.put("/js/**", "/js/");
        resources.put("/css/**", "/css/");
        resources.put("/img/**", "/img/");
        resources.put("/brands/**", "/brands/");
        resources.put("/static/**", "/static/");
        resources.put("/f/**", "/f/");
        resources.put("/templates/**", "/templates/");
        return resources;
    }

}