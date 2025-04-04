package com.santi.performancemonitor.monitoring.decorator;

import com.santi.performancemonitor.monitoring.service.PerformanceMonitor;

public class TimeLoggingDecorator extends PerformanceDecorator {

    public TimeLoggingDecorator(PerformanceMonitor monitor) {
        super(monitor);
    }

    @Override
    public Object monitor() throws Throwable {
        long start = System.currentTimeMillis();
        Object result = monitor.monitor();
        long end = System.currentTimeMillis();
        System.out.println("⏱ Tiempo de ejecución: " + (end - start) + " ms");
        return result;
    }
}
