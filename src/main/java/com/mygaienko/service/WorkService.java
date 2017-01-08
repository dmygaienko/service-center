package com.mygaienko.service;

import com.mygaienko.dao.UserDao;
import com.mygaienko.dao.WorkDao;
import com.mygaienko.model.Work;
import com.mygaienko.model.dto.WorkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by enda1n on 09.01.2017.
 */
@Service
public class WorkService {

    @Autowired
    private WorkDao workDao;

    @Autowired
    private UserDao userDao;

    public void create(WorkDto dto) {
        workDao.create(toEntity(dto));
    }

    public Work toEntity(WorkDto dto) {
        Work work = new Work();
        work.setDescription(dto.getDescription());
        work.setPrice(dto.getPrice());
        work.setStatus(dto.getStatus());
        work.setMaster(userDao.load(dto.getMaster().getId()));
        return work;
    }
}
