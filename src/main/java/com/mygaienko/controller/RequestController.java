package com.mygaienko.controller;

import com.mygaienko.model.RequestEntity;
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
    public void createRequest(@RequestBody RequestEntity request, @PathVariable("cliendId") long cliendId) {
        requestService.createRequest(request, cliendId);
    }

    @ResponseBody
    @RequestMapping("/find?requestId={requestId}")
    public RequestEntity findById(@PathVariable("requestId") long requestId) {
        return requestService.findById(requestId);
    }

    @ResponseBody
    @RequestMapping("/find")
    public List<RequestEntity> findByAttributes(@RequestBody RequestEntity request) {
        return requestService.findByAttributes(request);
    }

    @ResponseBody
    @RequestMapping("/getAll")
    public List<RequestEntity> getAll() {
        return requestService.getAll();
    }

}
