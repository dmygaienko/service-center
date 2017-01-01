package com.mygaienko.service;

import com.mygaienko.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by enda1n on 01.01.2017.
 */
@Service
public class PhotoScheduler {

    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    @Autowired
    private PhotoService photoService;

    @Autowired
    private RequestService requestService;

    public void startPhotoShooting(long requestId){
        scheduledExecutorService.schedule(new PhotoTask(photoService, requestService, requestId), 15, TimeUnit.MINUTES);
    }

    static class PhotoTask implements Runnable {

        private final PhotoService photoService;
        private final RequestService requestService;
        private final long requestId;

        public PhotoTask(PhotoService photoService, RequestService requestService, long requestId) {
            this.photoService = photoService;
            this.requestService = requestService;
            this.requestId = requestId;
        }

        @Override
        public void run() {
           if (requestService.statusIsStarted(requestId)) {
               byte[] content = photoService.shoot(requestId);
               photoService.save(new Image(content));
           }
        }
    }
}
