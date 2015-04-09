package com.thisismap.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Class <tt>ApplicationConfiguration</tt>
 *
 * This class exists to perform @PostConstruct methods for beans
 * which need to be in all profiles but methods that execute only
 * in particular profiles, specifically by @PostConstruct.
 *
 * Spring should handle making sure the dependant beans are already available.
 */

@Profile("container")
@Component
public class PostConstructInitializersForProfiles {

    @Autowired
    private Environment environment;

}