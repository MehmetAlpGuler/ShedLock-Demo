package com.jzwzz.jobdemo.jobdemo;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")
public class JobdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobdemoApplication.class, args);
    }
}
