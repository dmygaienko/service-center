package com.mygaienko.service;

import com.mygaienko.dao.ImageDao;
import com.mygaienko.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by enda1n on 01.01.2017.
 */
@Service
public class PhotoService {

    @Autowired
    private ImageDao imageDao;

    public byte[] shoot(long requestId) {
        return null;
    }

    public void save(Image image){
        imageDao.save(image);
    }
}
