package com.santi.performancemonitor.monitoring.service;


import com.santi.performancemonitor.monitoring.model.PerformanceData;

import java.util.List;

public interface PerformanceService {
    List<PerformanceData> getAllPerformanceData();

    PerformanceData patchPerformanceData(Long id, PerformanceData partialData);


    PerformanceData savePerformanceData(PerformanceData data);

    PerformanceData updatePerformanceData(Long id, PerformanceData data);

    void deletePerformanceData(Long id);
}