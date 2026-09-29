package com.albez.bus.task;

import com.albez.bus.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StationTask {
    private final StationService stationService;

    @Scheduled(cron = "0 0 0,12 * * ?")
    public void refreshStationInfo() {
        stationService.refreshStationInfo();
    }
}
