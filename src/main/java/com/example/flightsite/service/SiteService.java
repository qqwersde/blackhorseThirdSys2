package com.example.flightsite.service;

import com.example.flightsite.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class SiteService {

    public List<FlightSite> getFlightSite(String fId){
        if(fId.equals( "CS2345")){
            throw new BusinessException("已停飞", HttpStatus.BAD_REQUEST);
        }
        HashMap<String, List<FlightSite>> stringListHashMap = getStringListHashMap();
        return stringListHashMap.get(fId);
    }

    public boolean bookSite(String fId, String siteType) {
        List<FlightSite> flightSite = getFlightSite(fId);
        FlightSite site = flightSite.stream().filter(item -> item.getSiteType().name().equals(siteType)).findAny().get();
        return site.getAmount() != 0;
    }


    private HashMap<String, List<FlightSite>> getStringListHashMap() {
        FlightSite flightSite = FlightSite.builder().amount(10).siteType(SiteType.ECONOMY).price(500.23).build();
        FlightSite flightSite1 = FlightSite.builder().amount(5).siteType(SiteType.BUSINESS).price(1000.23).build();
        FlightSite flightSite2 = FlightSite.builder().amount(0).siteType(SiteType.FIRST).price(1500.23).build();
        List<FlightSite> flightSites = List.of(flightSite, flightSite1, flightSite2);
        HashMap<String, List<FlightSite>> stringListHashMap = new HashMap<>();
        stringListHashMap.put("CS2311",flightSites);
        return stringListHashMap;
    }

}
