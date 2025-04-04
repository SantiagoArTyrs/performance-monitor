package com.santi.performancemonitor.monitoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santi.performancemonitor.monitoring.model.PerformanceData;

public interface PerformanceRepository extends JpaRepository<PerformanceData, Long> {
    // Aquí podrías meter consultas personalizadas más adelante si se antoja
}
