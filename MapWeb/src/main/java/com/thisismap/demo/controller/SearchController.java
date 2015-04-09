package com.thisismap.demo.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thisismap.demo.domain.Patient;
import com.thisismap.demo.model.ApiRequest;
import com.thisismap.demo.model.ApiResponse;
import com.thisismap.demo.model.ResponseType;
import com.thisismap.demo.service.DemoService;

/**
 * Class <tt>SearchController</tt>
 */
@Controller
@RequestMapping(value="/web/search")
public class SearchController {

    @Autowired
    private DemoService demoService;
    
    @Autowired
    private DataSource dataSource;

    @RequestMapping(value="/patient", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ApiResponse search(@RequestParam String query) {
    	
		Patient patient = demoService.getPatientInfo(Integer.valueOf(query));
        return new ApiResponse(ResponseType.SUCCESS, null, patient);
    }

    @RequestMapping(value="/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ApiResponse find(@RequestParam String query) {
    	
		Patient patient = demoService.getUserInfo(Integer.valueOf(query));    
        return new ApiResponse(ResponseType.SUCCESS, null, patient);
    }

    @RequestMapping(value="/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ApiResponse update(@RequestBody ApiRequest anApiRequest) {
    	
		String id = anApiRequest.getRequestObject().get("id").toString();
		String firstName = anApiRequest.getRequestObject().get("firstName").toString();
		String lastName = anApiRequest.getRequestObject().get("lastName").toString();
    	
		demoService.updateUser(Integer.parseInt(id), firstName, lastName);
    	
        return new ApiResponse(ResponseType.SUCCESS, null, null);
    }
    
}