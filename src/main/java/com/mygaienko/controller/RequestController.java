package com.mygaienko.controller;

import com.mygaienko.model.Request;
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

    @RequestMapping("/create/{cliendId}")
    public void createRequest(@RequestBody Request request, @PathVariable("cliendId") long cliendId) {
        requestService.createRequest(request, cliendId);
    }

    @RequestMapping("/find?requestId={requestId}")
    public Request findById(@PathVariable("requestId") long requestId) {
        return requestService.findById(requestId);
    }

    @RequestMapping("/find")
    public List<Request> findByAttributes(@RequestBody Request request) {
        return requestService.findByAttributes(request);
    }

    @RequestMapping("/getAll")
    public List<Request> getAll() {
        return requestService.getAll();
    }

}
