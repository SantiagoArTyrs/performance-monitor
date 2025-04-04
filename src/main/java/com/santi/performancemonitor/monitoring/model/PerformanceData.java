package com.santi.performancemonitor.monitoring.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PerformanceData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String methodName;
    private long executionTimeMs;
    private long memoryUsageKb;
    private int requestCount;
    private boolean slowMethod;
    private LocalDateTime timestamp;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public long getExecutionTimeMs() {
        return executionTimeMs;
    }

    public void setExecutionTimeMs(long executionTimeMs) {
        this.executionTimeMs = executionTimeMs;
    }

    public long getMemoryUsageKb() {
        return memoryUsageKb;
    }

    public void setMemoryUsageKb(long memoryUsageKb) {
        this.memoryUsageKb = memoryUsageKb;
    }

    public int getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(int requestCount) {
        this.requestCount = requestCount;
    }

    public boolean isSlowMethod() {
        return slowMethod;
    }

    public void setSlowMethod(boolean slowMethod) {
        this.slowMethod = slowMethod;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public PerformanceData() {
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
