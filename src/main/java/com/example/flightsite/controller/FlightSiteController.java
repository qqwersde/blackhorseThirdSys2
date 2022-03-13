package com.example.flightsite.controller;

import com.example.flightsite.service.FlightSite;
import com.example.flightsite.service.SiteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightSiteController {


    private final SiteService siteService;


    public FlightSiteController(SiteService siteService) {
        this.siteService = siteService;
    }

    @GetMapping("/{fId}")
    public List<FlightSite> getFlightSite(@PathVariable("fId") String fId) {
        return siteService.getFlightSite(fId);
    }

    @PostMapping("/{fId}/bookSite")
    public boolean bookSite(@PathVariable("fId") String fId, @RequestParam("siteType") String siteType) {
        return siteService.bookSite(fId,siteType);
    }


}
