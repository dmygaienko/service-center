package com.mygaienko.dao;

import com.mygaienko.model.Request;
import com.mygaienko.model.dto.RequestDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.connection.RedisZSetCommands.Range;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Set;

/**
 * Created by enda1n on 09.11.2016.
 */
@Repository
public class RequestCachedDao {

    private static final String KEY = "REQUEST";

    private final RedisTemplate<String, RequestDescription> redisTemplate;
    public ZSetOperations<String, RequestDescription> zsetOps;

    @Autowired
    public RequestCachedDao(RedisTemplate<String, RequestDescription> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
       /* hashOps = redisTemplate.opsForHash();*/
        zsetOps = redisTemplate.opsForZSet();
    }

    public void saveRequest(RequestDescription request) {
        zsetOps.add(KEY, request, request.getDatetime().toEpochSecond(ZoneOffset.UTC));
    }
    public void saveRequests(List<RequestDescription> requests) {
        requests.forEach(request -> {
            LocalDateTime datetime = request.getDatetime();
            zsetOps.add(KEY, request, datetime != null ? datetime.toEpochSecond(ZoneOffset.UTC) : 0);
        });
    }

    public Set<RequestDescription> getLatest() {
        return zsetOps.reverseRangeByScore(KEY, 0, LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
    }

    public Set<RequestDescription> getRangedByScore() {
        return zsetOps.reverseRangeByScore("REQUEST", 1, 1999999999);
    }

    public void rangeRequestForThePastDay(RequestDescription request) {
        LocalDateTime localDateTime = LocalDateTime.now();
        long localDateTimeSecs = localDateTime.toEpochSecond(ZoneOffset.UTC);
        LocalDateTime yesterday = localDateTime.minusDays(1);
        long yesterdaySecs = yesterday.toEpochSecond(ZoneOffset.UTC);

        zsetOps.range(KEY, localDateTimeSecs, yesterdaySecs);
    }
}
