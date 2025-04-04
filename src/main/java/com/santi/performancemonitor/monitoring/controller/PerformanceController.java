package com.santi.performancemonitor.monitoring.controller;

import com.santi.performancemonitor.monitoring.model.PerformanceData;
import com.santi.performancemonitor.monitoring.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/performance")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @GetMapping
    public List<PerformanceData> getAllData() {
        return performanceService.getAllPerformanceData();
    }

    @PostMapping
    public PerformanceData createPerformanceData(@RequestBody PerformanceData data) {
        return performanceService.savePerformanceData(data);
    }

    @PutMapping("/{id}")
    public PerformanceData updatePerformanceData(@PathVariable Long id, @RequestBody PerformanceData updatedData) {
        return performanceService.updatePerformanceData(id, updatedData);
    }

    @PatchMapping("/{id}")
    public PerformanceData patchPerformanceData(@PathVariable Long id, @RequestBody PerformanceData partialData) {
        return performanceService.patchPerformanceData(id, partialData);
    }

    @DeleteMapping("/{id}")
    public void deletePerformanceData(@PathVariable Long id) {
        performanceService.deletePerformanceData(id);
    }
}


