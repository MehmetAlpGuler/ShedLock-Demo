package com.jzwzz.jobdemo.jobdemo.job;

import net.javacrumbs.shedlock.core.SchedulerLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DemoJob {
    public static final String KEY = "KEY1";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Scheduled(cron = "*/1 * * * * ? ")
    @SchedulerLock(name = "hello")
    public void hello() throws InterruptedException {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String nowStr = now.format(format);


        String value = stringRedisTemplate.opsForValue().get(KEY);

        String result = increase(value, 9);

        stringRedisTemplate.opsForValue().set(KEY, result);

        System.out.println("DemoJob.hello at " + nowStr + " result = " + result);

    }

    protected String increase(String value, int sleepSecond) throws InterruptedException {

        if (!StringUtils.hasText(value)) {
            value = "0";
        }

        Integer i = NumberUtils.parseNumber(value, Integer.class);


        Thread.sleep(1000 * sleepSecond);

        i = i + 1;
        return String.valueOf(i);
    }

}
