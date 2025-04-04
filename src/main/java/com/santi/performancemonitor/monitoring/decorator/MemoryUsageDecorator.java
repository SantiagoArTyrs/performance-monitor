package com.santi.performancemonitor.monitoring.decorator;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

import com.santi.performancemonitor.monitoring.service.PerformanceMonitor;

public class MemoryUsageDecorator extends PerformanceDecorator {

    private final MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

    public MemoryUsageDecorator(PerformanceMonitor monitor) {
        super(monitor);
    }

    @Override
    public Object monitor() throws Throwable {
        long beforeUsedMem = memoryMXBean.getHeapMemoryUsage().getUsed() / 1024;

        Object result = monitor.monitor();

        long afterUsedMem = memoryMXBean.getHeapMemoryUsage().getUsed() / 1024;

        System.out.println("Memoria usada: " + (afterUsedMem - beforeUsedMem) + " KB");

        return result;
    }
}
