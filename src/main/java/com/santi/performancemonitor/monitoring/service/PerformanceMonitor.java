package com.santi.performancemonitor.monitoring.service;

public interface PerformanceMonitor {
    Object monitor() throws Throwable; // Cambiado a retornar Object
}
