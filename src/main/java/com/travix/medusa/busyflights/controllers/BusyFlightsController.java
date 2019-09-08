package com.travix.medusa.busyflights.controllers;

import com.travix.medusa.busyflights.services.BusyFlightsService;
import com.travix.medusa.busyflights.swagger.api.FlightsApi;
import com.travix.medusa.busyflights.swagger.model.BusyFlightsRequest;
import com.travix.medusa.busyflights.swagger.model.BusyFlightsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
public class BusyFlightsController implements FlightsApi {
    private  BusyFlightsService busyFlightsService;

    @Autowired
    public BusyFlightsController(BusyFlightsService busyFlightsService) {
        this.busyFlightsService = busyFlightsService;
    }



    @Override
    public ResponseEntity<BusyFlightsResponse> getFlights(final @Valid @RequestBody BusyFlightsRequest busyFlightsRequest) {
        final BusyFlightsResponse busyFlightsResponse = busyFlightsService.getBusyFlightsService(busyFlightsRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(busyFlightsResponse);
    }
}
