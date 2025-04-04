package com.santi.performancemonitor.monitoring.service;

import com.santi.performancemonitor.monitoring.model.PerformanceData;
import com.santi.performancemonitor.monitoring.repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PerformanceServiceImpl implements PerformanceService {

    @Autowired
    private PerformanceRepository performanceRepository;

    @Override
    public List<PerformanceData> getAllPerformanceData() {
        return performanceRepository.findAll();
    }

    @Override
    public PerformanceData savePerformanceData(PerformanceData data) {
        return performanceRepository.save(data);
    }

    @Override
    public PerformanceData updatePerformanceData(Long id, PerformanceData data) {
        Optional<PerformanceData> existingDataOpt = performanceRepository.findById(id);
        if (existingDataOpt.isPresent()) {
            PerformanceData existingData = existingDataOpt.get();
            existingData.setMethodName(data.getMethodName());
            existingData.setExecutionTimeMs(data.getExecutionTimeMs());
            existingData.setMemoryUsageKb(data.getMemoryUsageKb());
            existingData.setRequestCount(data.getRequestCount());
            existingData.setSlowMethod(data.isSlowMethod());
            existingData.setTimestamp(data.getTimestamp());
            return performanceRepository.save(existingData);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "PerformanceData with id " + id + " not found");
        }
    }

    @Override
    public PerformanceData patchPerformanceData(Long id, PerformanceData partialData) {
        Optional<PerformanceData> existingDataOpt = performanceRepository.findById(id);
        if (existingDataOpt.isPresent()) {
            PerformanceData existing = existingDataOpt.get();

            if (partialData.getMethodName() != null) {
                existing.setMethodName(partialData.getMethodName());
            }
            if (partialData.getExecutionTimeMs() != 0) {
                existing.setExecutionTimeMs(partialData.getExecutionTimeMs());
            }
            if (partialData.getMemoryUsageKb() != 0) {
                existing.setMemoryUsageKb(partialData.getMemoryUsageKb());
            }
            if (partialData.getRequestCount() != 0) {
                existing.setRequestCount(partialData.getRequestCount());
            }
            existing.setSlowMethod(partialData.isSlowMethod());
            if (partialData.getTimestamp() != null) {
                existing.setTimestamp(partialData.getTimestamp());
            }

            return performanceRepository.save(existing);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "PerformanceData with id " + id + " not found");
        }
    }

    @Override
    public void deletePerformanceData(Long id) {
        if (!performanceRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "PerformanceData with id " + id + " not found");
        }
        performanceRepository.deleteById(id);
    }
}
