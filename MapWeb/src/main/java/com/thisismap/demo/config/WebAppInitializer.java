package com.thisismap.demo.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * Class <tt>ApplicationConfiguration</tt>
 */
public class WebAppInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext container) {

        //Load Annotation Based Configs
    	AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();

        // Manage the lifecycle of the root application context
        container.addListener(new ContextLoaderListener(rootContext));
        rootContext.scan("com.thisismap");
        rootContext.register(ApplicationConfiguration.class);

        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.scan("com.thisismap");
        dispatcherContext.register(MvcConfiguration.class);

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher =
                container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
        dispatcher.setInitParameter("spring.profiles.active", "container");

        // set cache controls?
        WebContentInterceptor webContentInterceptor = new WebContentInterceptor();
        webContentInterceptor.setCacheSeconds(24*60*60);
        webContentInterceptor.setUseCacheControlHeader(false);
        webContentInterceptor.setUseExpiresHeader(false);
    }
 }