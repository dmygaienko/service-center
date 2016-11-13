package com.mygaienko.service;

import com.mygaienko.dao.RequestDao;
import com.mygaienko.dao.UserDao;
import com.mygaienko.model.Request;
import com.mygaienko.model.dto.RequestDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<RequestDescription> findByAttributes(Request request) {
        return toDescriptionDto(requestDao.findByAttributes(request));
    }

    public List<RequestDescription> getAll() {
        return toDescriptionDto(requestDao.getAll());
    }

    private List<RequestDescription> toDescriptionDto(List<Request> list) {
        return list.stream()
                .map(product -> new RequestDescription(product))
                .collect(Collectors.toList());
    }

    public void updateRequest(Request request, long cliendId) {
        requestDao.update(request);
    }
}
