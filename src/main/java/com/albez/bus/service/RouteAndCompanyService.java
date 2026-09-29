package com.albez.bus.service;

import com.albez.bus.domain.response.RouteAndCompanyRefreshResult;
import com.albez.bus.model.CompanyInfo;
import com.albez.bus.model.RouteInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteAndCompanyService {
    private final CompanyService companyService;
    private final RouteService routeService;

    /**
     * 同步刷新公司和线路信息。
     */
    @Transactional
    public RouteAndCompanyRefreshResult refreshRouteAndCompanyInfo() {
        List<CompanyInfo> companyInfoList = companyService.refreshCompanyInfo();
        List<RouteInfo> routeInfoList = routeService.refreshRouteInfo();

        RouteAndCompanyRefreshResult result = new RouteAndCompanyRefreshResult();
        result.setCompanyCount(companyInfoList.size());
        result.setRouteCount(routeInfoList.size());
        result.setStationCount(0);
        result.setRouteStationCount(0);
        result.setCompanyList(companyInfoList);
        result.setRouteList(routeInfoList);
        result.setStationList(List.of());
        result.setRouteStationList(List.of());
        return result;
    }
}
