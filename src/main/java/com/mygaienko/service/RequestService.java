package com.mygaienko.service;

import com.mygaienko.dao.RequestDao;
import com.mygaienko.dao.UserDao;
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

    @Autowired
    private UserDao userDao;

    public void createRequest(RequestEntity request, long cliendId) {
        request.setClient(userDao.load(cliendId));
        requestDao.createRequest(request);
    }

    public RequestEntity findById(long requestId) {
        return requestDao.findById(requestId);
    }

    public RequestEntity findByAttributes(RequestEntity request) {
        return requestDao.findByAttributes(request);
    }
}
