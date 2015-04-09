package com.thisismap.demo.config;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.DeserializationFeature;

/**
 * Class <tt>ApplicationConfiguration</tt>
 *
 * This is here to
 * * make mvc a profile-driven element
 * * @EnableWebMvc
 * * Provide a hook if we need any custom mvc config.
 *
 */
@Profile("container")
@Import(ApplicationConfiguration.class)
@ComponentScan(basePackages= "com.thisismap")
@Configuration
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {

    @Resource(name="resourcesExcludedFromMVC")
    private Map<String, String> resourcesExcluded;


    /**
     * Handled this way instead of statically so that the above can be injected
     * into the SessionTimeoutFilter and used in the same way - for excluded urls.
     * Wanted to handle this in a common fashion in the event that new resource urls
     * are created.
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        for (String resourceMatcher : resourcesExcluded.keySet()) {
            registry.addResourceHandler(resourceMatcher).addResourceLocations(resourcesExcluded.get(resourceMatcher));
        }
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(customJackson2Converter());
    }

    @Bean
    MappingJackson2HttpMessageConverter customJackson2Converter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.getObjectMapper().configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        return converter;
    }

}
