package com.mygaienko.controller;

import com.mygaienko.model.dto.WorkDto;
import com.mygaienko.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by enda1n on 09.01.2017.
 */
@RestController
@RequestMapping("/works")
public class WorkController {

    @Autowired
    private WorkService workService;

    public void create(WorkDto dto) {
        workService.create(dto);
    }

}
