package com.mygaienko.controller;

import com.mygaienko.model.RequestEntity;
import com.mygaienko.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by enda1n on 09.11.2016.
 */
@RestController
@RequestMapping("/request")
public class RequestController {

    @Autowired
    private RequestService requestService;

    /*  @ResponseBody*/
    @RequestMapping("/create")
    public void createRequest(@RequestBody RequestEntity request) {
        requestService.createRequest(request);
    }

}
