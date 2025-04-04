package com.santi.performancemonitor.monitoring.aspect;

import com.santi.performancemonitor.monitoring.decorator.*;
import com.santi.performancemonitor.monitoring.repository.PerformanceRepository;
import com.santi.performancemonitor.monitoring.service.BasicPerformanceMonitor;
import com.santi.performancemonitor.monitoring.service.PerformanceMonitor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    private final PerformanceRepository repository;

    public PerformanceAspect(PerformanceRepository repository) {
        this.repository = repository;
    }

    @Around("@annotation(org.springframework.web.bind.annotation.GetMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.PostMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.PutMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public Object monitorDecorated(ProceedingJoinPoint joinPoint) throws Throwable {
        PerformanceMonitor monitor = new BasicPerformanceMonitor(joinPoint, repository);
        monitor = new TimeLoggingDecorator(monitor);
        monitor = new MemoryUsageDecorator(monitor);
        monitor = new SlowMethodFlagDecorator(monitor);
        monitor = new LoggingDecorator(monitor);

        return monitor.monitor(); // Retornamos el resultado de la cadena decorada
    }
}
