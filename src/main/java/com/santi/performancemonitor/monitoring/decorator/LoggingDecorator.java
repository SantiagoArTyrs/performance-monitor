package com.santi.performancemonitor.monitoring.decorator;

import com.santi.performancemonitor.monitoring.service.PerformanceMonitor;

public class LoggingDecorator implements PerformanceMonitor {

    private final PerformanceMonitor wrappedMonitor;

    public LoggingDecorator(PerformanceMonitor wrappedMonitor) {
        this.wrappedMonitor = wrappedMonitor;
    }

    @Override
    public Object monitor() throws Throwable {
        System.out.println("[LOG] Inicio del monitoreo...");

        Object result = wrappedMonitor.monitor();

        System.out.println("[LOG] Fin del monitoreo.");
        return result;
    }
}
