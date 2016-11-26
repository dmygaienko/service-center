package com.mygaienko.controller;

import com.mygaienko.model.Request;
import com.mygaienko.model.dto.RequestDescription;
import com.mygaienko.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by enda1n on 09.11.2016.
 */
@RestController
@RequestMapping("/request")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @RequestMapping(value = "/create/{cliendId}", method = RequestMethod.POST)
    public void createRequest(@RequestBody Request request, @PathVariable("cliendId") long cliendId) {
        requestService.createRequest(request, cliendId);
    }

    @RequestMapping(value = "/update/{cliendId}", method = RequestMethod.POST)
    public void updateRequest(@RequestBody Request request, @PathVariable("cliendId") long cliendId) {
        requestService.updateRequest(request, cliendId);
    }

    @RequestMapping(value = "/byId/{requestId}", method = RequestMethod.GET)
    public Request findById(@PathVariable("requestId") long requestId) {
        return requestService.findById(requestId);
    }

    @RequestMapping(value = "/byAttributes", method = RequestMethod.POST)
    public List<RequestDescription> findByAttributes(@RequestBody Request request) {
        return requestService.findByAttributes(request);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<RequestDescription> getAll() {
        return requestService.getAll();
    }

}
