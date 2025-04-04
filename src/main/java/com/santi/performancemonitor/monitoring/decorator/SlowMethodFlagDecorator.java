package com.santi.performancemonitor.monitoring.decorator;

import com.santi.performancemonitor.monitoring.service.PerformanceMonitor;

public class SlowMethodFlagDecorator extends PerformanceDecorator {

    public SlowMethodFlagDecorator(PerformanceMonitor monitor) {
        super(monitor);
    }

    @Override
    public Object monitor() throws Throwable {
        long start = System.currentTimeMillis();
        Object result = monitor.monitor();
        long end = System.currentTimeMillis();

        if ((end - start) > 1000) {
            System.out.println("Método identificado como LENTO (>1s)");
        }

        return result;
    }
}
