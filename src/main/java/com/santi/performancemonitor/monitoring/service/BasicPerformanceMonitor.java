package com.santi.performancemonitor.monitoring.service;

import com.santi.performancemonitor.monitoring.model.PerformanceData;
import com.santi.performancemonitor.monitoring.repository.PerformanceRepository;
import org.aspectj.lang.ProceedingJoinPoint;

import java.time.LocalDateTime;

public class BasicPerformanceMonitor implements PerformanceMonitor {

    private final ProceedingJoinPoint joinPoint;
    private final PerformanceRepository repository;

    public BasicPerformanceMonitor(ProceedingJoinPoint joinPoint, PerformanceRepository repository) {
        this.joinPoint = joinPoint;
        this.repository = repository;
    }

    @Override
    public Object monitor() throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed(); // Se ejecuta una única vez aquí
        long end = System.currentTimeMillis();

        PerformanceData data = new PerformanceData();
        data.setMethodName(joinPoint.getSignature().toShortString());
        data.setExecutionTimeMs(end - start);
        data.setMemoryUsageKb(0); // Será modificado por otros decoradores
        data.setRequestCount(1);
        data.setSlowMethod(false); // También lo cambian los decoradores
        data.setTimestamp(LocalDateTime.now());

        repository.save(data);

        return result;
    }
}
