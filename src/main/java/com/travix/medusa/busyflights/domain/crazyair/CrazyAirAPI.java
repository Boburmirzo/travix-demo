package com.travix.medusa.busyflights.domain.crazyair;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
@Component
@FeignClient(
        name = "crazy-air-service-feign",
        url = "${crazy-air-service.host}",
        path = "${crazy-air-service.path}")
public interface CrazyAirAPI {

    /**
     * Makes HTTP POST request
     * .
     *
     * @param crazyAirRequest the oracle gateway request
     * @return Response from service
     */
    @PostMapping(consumes = "application/json")
    CrazyAirResponse sendRequest(CrazyAirRequest crazyAirRequest);
}
