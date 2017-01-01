package com.mygaienko.controller;

import com.mygaienko.model.Manual;
import com.mygaienko.service.ManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by enda1n on 01.01.2017.
 */
@Controller
public class ManualController {

    @Autowired
    private ManualService manualService;

    public void createManual(Manual manual){}

    public void deleteManual(Manual manual){}
}
