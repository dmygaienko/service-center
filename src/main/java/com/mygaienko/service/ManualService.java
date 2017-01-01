package com.mygaienko.service;

import com.mygaienko.dao.ManualDao;
import com.mygaienko.model.Manual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by enda1n on 01.01.2017.
 */
@Service
public class ManualService {

    @Autowired
    private ManualDao manualDao;

    public void createManual(Manual manual){}

    public void deleteManual(Manual manual){}

}
