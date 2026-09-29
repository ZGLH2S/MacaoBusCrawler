package com.albez.bus.task;

import com.albez.bus.service.RouteAndCompanyService;
import com.albez.bus.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RouteAndCompanyTask {
    private final RouteAndCompanyService routeAndCompanyService;

    @Scheduled(cron = "0 0 0/12 * * ?")
    public void refreshRouteAndCompanyInfo() {
        routeAndCompanyService.refreshRouteAndCompanyInfo();
    }
}
