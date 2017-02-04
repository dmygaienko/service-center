package com.mygaienko.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import redis.embedded.RedisExecProvider;
import redis.embedded.RedisServer;

import static redis.embedded.util.Architecture.x86_64;
import static redis.embedded.util.OS.WINDOWS;

/**
 * Created by enda1n on 04.02.2017.
 */
public class RedisServerBean implements InitializingBean, DisposableBean, BeanDefinitionRegistryPostProcessor {

    private RedisServer redisServer;


    @Override
    public void afterPropertiesSet() throws Exception {
       /* redisServer = new RedisServer(new File("C:\\installs\\redis64-2.8.19\\redis-server.exe"), 6379);*/
        redisServer = RedisServer.builder()
                .redisExecProvider(RedisExecProvider.defaultProvider().override(WINDOWS, x86_64,
                        "C:\\installs\\redis-latest\\redis-server.exe"))
                /*.setting("--maxheap 1gb")*/
                .build();
        redisServer.start();
    }

    @Override
    public void destroy() throws Exception {
        if (redisServer != null) {
            redisServer.stop();
        }
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
