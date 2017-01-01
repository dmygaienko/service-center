package com.mygaienko.service;

import com.mygaienko.dao.RequestDao;
import com.mygaienko.dao.UserDao;
import com.mygaienko.model.Request;
import com.mygaienko.model.RequestStatus;
import com.mygaienko.model.dto.RequestDescription;
import com.mygaienko.model.dto.RequestDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
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
    private PhotoScheduler photoScheduler;

    @Autowired
    private UserDao userDao;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void createRequest(Request request, long cliendId) {
        request.setClient(userDao.load(cliendId));
        requestDao.createRequest(request);
    }

    @PostAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MASTER') OR " +
            "(hasRole('ROLE_CLIENT') AND returnObject.client.email == authentication.name)")
    public RequestDetails findById(long requestId) {
        return new RequestDetails(requestDao.findById(requestId));
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MASTER')")
    public List<RequestDescription> findByAttributes(Request request) {
        return toDescriptionDto(requestDao.findByAttributes(request));
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MASTER')")
    public List<RequestDescription> getAll() {
        return toDescriptionDto(requestDao.getAll());
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MASTER')")
    public void startWork(long requestId) {
        photoScheduler.startPhotoShooting(requestId);
        updateStatus(requestId, RequestStatus.STARTED);
    }

    private void updateStatus(long requestId, RequestStatus started) {
        Request request = requestDao.findById(requestId);
        request.setStatus(started);
        requestDao.update(request);
    }

    private List<RequestDescription> toDescriptionDto(List<Request> list) {
        return list.stream()
                .map(product -> new RequestDescription(product))
                .collect(Collectors.toList());
    }

    public void updateRequest(Request request, long cliendId) {
        requestDao.update(request);
    }

    public boolean statusIsStarted(long requestId) {
        Request request = requestDao.findById(requestId);
        return request.getStatus().equals(RequestStatus.STARTED);
    }
}
