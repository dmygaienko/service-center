package com.mygaienko.service;

import com.mygaienko.dao.MakerDao;
import com.mygaienko.model.Maker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by enda1n on 01.01.2017.
 */
@Service
public class MakerService {

    @Autowired
    private MakerDao makerDao;

    public void createMaker(Maker maker){}

    public List<Maker> getAll(){
        return null;
    }
}
