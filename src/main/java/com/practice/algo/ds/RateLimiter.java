package com.practice.algo.ds;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 *
 */
public class RateLimiter {
    private final int capacity;
    private final long windowSizeInMillis;
    private final Map<String, Window> map;

    public RateLimiter(int capacity, long windowSizeInMillis) {
        this.capacity = capacity;
        this.windowSizeInMillis = windowSizeInMillis;
        this.map = new ConcurrentHashMap<>();
    }

    public boolean allowRequest(String userId) {
        long currTime = System.currentTimeMillis();
        Window currWindow = map.computeIfAbsent(userId, x -> new Window());
        synchronized (currWindow) {
            if (currTime >= currWindow.getWindowStartTime() + windowSizeInMillis) {
                currWindow.setWindowStartTime(currTime);
                int credit = currWindow.getRequestCount().get() - capacity;
                System.out.println("Credited to " + userId + " credits: " + credit);
                currWindow.getRequestCount().set(credit);
                map.put(userId, currWindow);
            }
            if (currWindow.getRequestCount().get() < capacity) {
                currWindow.getRequestCount().incrementAndGet();
                return true;
            }
            return false;
        }
    }

    public static class Window {
        private final AtomicInteger requestCount;
        private long windowStartTime;

        public Window() {
            this.requestCount = new AtomicInteger(0);
            this.windowStartTime = System.currentTimeMillis();
        }

        public AtomicInteger getRequestCount() {
            return requestCount;
        }

        public long getWindowStartTime() {
            return windowStartTime;
        }

        public void setWindowStartTime(long windowStartTime) {
            this.windowStartTime = windowStartTime;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(5, 1000); // 10 req/secong
        for (int i = 0; i < 3; i++) {
            boolean allowed = rateLimiter.allowRequest("pushpendra");
            if (allowed) {
                System.out.println("Allowed request " + (i + 1) + " for pushpendra");
            } else {
                System.out.println("Disallowed request " + (i + 1) + " for pushpendra");
            }
            Thread.sleep(10);
        }
        Thread.sleep(1500);
        for (int i = 0; i < 7; i++) {
            boolean allowed = rateLimiter.allowRequest("pushpendra");
            if (allowed) {
                System.out.println("Allowed request " + (i + 1) + " for pushpendra");
            } else {
                System.out.println("Disallowed request " + (i + 1) + " for pushpendra");
            }
            Thread.sleep(10);
        }
        Thread.sleep(1500);
        boolean allowed = rateLimiter.allowRequest("pushpendra");
        if (allowed) {
            System.out.println("Allowed request for pushpendra");
        }
    }
}
