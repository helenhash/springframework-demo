package com.helen.demo.service;

import com.hazelcast.core.HazelcastInstance;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

@RequiredArgsConstructor
@Slf4j
@Service
public class LockDemoService {
    private  final String LOCK_KEY = "my_gl_lock";
    private HazelcastInstance hazelcast;

    @Scheduled(cron = "0 0 0 ? * * *")
    public void lockTest() throws InterruptedException {
        log.info("Job Running ..... {}", LOCK_KEY);
        this.testLockedMethod();
    }
    private void testLockedMethod() throws InterruptedException {
        Lock lock = hazelcast.getCPSubsystem().getLock(LOCK_KEY);
        if (lock.tryLock(5, TimeUnit.SECONDS)) {
            try {
                log.debug("Locked [{}]", LOCK_KEY);
                // Do something
            } finally {
                log.debug("Unlock [{}]", LOCK_KEY);
                lock.unlock();
            }
        }
    }
}
