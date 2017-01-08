package com.mygaienko.service;

import com.mygaienko.dao.ComponentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by enda1n on 09.01.2017.
 */
@Service
public class ComponentService {

    @Autowired
    private ComponentDao componentDao;
}
