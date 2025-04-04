package com.santi.performancemonitor.monitoring.decorator;

import com.santi.performancemonitor.monitoring.service.PerformanceMonitor;

public abstract class PerformanceDecorator implements PerformanceMonitor {

    protected final PerformanceMonitor monitor;

    public PerformanceDecorator(PerformanceMonitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public abstract Object monitor() throws Throwable;
}
