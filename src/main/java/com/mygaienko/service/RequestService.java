package com.mygaienko.service;

import com.mygaienko.dao.RequestDao;
import com.mygaienko.model.RequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by enda1n on 09.11.2016.
 */
@Service
public class RequestService {

    @Autowired
    private RequestDao requestDao;

    public void createRequest(RequestEntity request) {
        requestDao.createRequest(request);
    }


}
