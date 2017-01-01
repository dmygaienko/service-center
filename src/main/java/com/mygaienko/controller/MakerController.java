package com.mygaienko.controller;

import com.mygaienko.model.Maker;
import com.mygaienko.service.MakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by enda1n on 01.01.2017.
 */
@Controller
public class MakerController {

    @Autowired
    private MakerService makerService;

    public void createMaker(Maker maker){

    }

    public List<Maker> getAll(){
        return null;
    }

}
