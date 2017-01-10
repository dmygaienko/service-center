package com.mygaienko.controller;

import com.mygaienko.model.dto.ComponentDto;
import com.mygaienko.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by enda1n on 09.01.2017.
 */
@RestController
@RequestMapping("/api/components")
public class ComponentController {

    @Autowired
    private ComponentService componentService;

    public void create(ComponentDto dto) {
    }
}
