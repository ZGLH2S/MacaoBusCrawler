package com.albez.bus.task;

import com.albez.bus.service.BusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class BusTask {
    private final BusService busService;

    @Scheduled(cron = "0 * * * * ?")
    public void refreshBusInfo() {
        busService.refreshBusInfo();
        log.info("更新完成");
    }
}
