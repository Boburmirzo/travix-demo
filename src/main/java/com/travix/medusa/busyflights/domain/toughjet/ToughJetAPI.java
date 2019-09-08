package com.travix.medusa.busyflights.domain.toughjet;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(
        name = "tough-jet-service-feign",
        url = "${tough-jet-service.host}",
        path = "${tough-jet-service.path}")
public interface ToughJetAPI {

    /**
     * Makes HTTP POST request
     * .
     *
     * @param toughJetRequest to toughJetRequest
     * @return response from service
     */
    @PostMapping(consumes = "application/json")
    ToughJetResponse sendRequest(ToughJetRequest toughJetRequest);
}
