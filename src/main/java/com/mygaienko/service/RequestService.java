package com.mygaienko.service;

import com.mygaienko.dao.RequestDao;
import com.mygaienko.dao.UserDao;
import com.mygaienko.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by enda1n on 09.11.2016.
 */
@Service
public class RequestService {

    @Autowired
    private RequestDao requestDao;

    @Autowired
    private UserDao userDao;

    public void createRequest(Request request, long cliendId) {
        request.setClient(userDao.load(cliendId));
        requestDao.createRequest(request);
    }

    public Request findById(long requestId) {
        return requestDao.findById(requestId);
    }

    public List<Request> findByAttributes(Request request) {
        return requestDao.findByAttributes(request);
    }

    public List<Request> getAll() {
        return requestDao.getAll();
    }
}
