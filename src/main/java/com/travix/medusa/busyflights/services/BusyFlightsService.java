package com.travix.medusa.busyflights.services;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirAPI;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetAPI;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.swagger.model.BusyFlightsRequest;
import com.travix.medusa.busyflights.swagger.model.BusyFlightsResponse;
import com.travix.medusa.busyflights.swagger.model.Flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Boburmirzo
 * @version 1.0
 * @since 2019-09-08
 */
@Service
public class BusyFlightsService {
	private CrazyAirAPI crazyAirAPI;
	private ToughJetAPI toughJetAPI;

	@Autowired
	public BusyFlightsService(CrazyAirAPI crazyAirAPI, ToughJetAPI toughJetAPI) {
		this.crazyAirAPI = crazyAirAPI;
		this.toughJetAPI = toughJetAPI;
	}

	public BusyFlightsResponse getBusyFlightsService(BusyFlightsRequest busyFlightsRequest) {
		Flight crazyAirResponse = crazyAir(busyFlightsRequest);
		Flight toughJetResponse = toughJet(busyFlightsRequest);

		BusyFlightsResponse busyFlightsResponse = new BusyFlightsResponse();
		busyFlightsResponse.addFlightItem(crazyAirResponse);
		busyFlightsResponse.addFlightItem(toughJetResponse);
		return busyFlightsResponse;
	}

	private Flight crazyAir(BusyFlightsRequest busyFlightsRequest) {
		CrazyAirRequest crazyAirRequest = new CrazyAirRequest();
		crazyAirRequest.setOrigin(busyFlightsRequest.getOrigin());
		crazyAirRequest.setDestination(busyFlightsRequest.getDestination());
		crazyAirRequest.setDepartureDate(busyFlightsRequest.getDepartureDate().toString());
		crazyAirRequest.setReturnDate(busyFlightsRequest.getReturnDate().toString());
		crazyAirRequest.setPassengerCount(busyFlightsRequest.getNumberOfPassengers());
		CrazyAirResponse crazyAirResponse = crazyAirAPI.sendRequest(crazyAirRequest);

		Flight crazyAirflight = new Flight();

		crazyAirflight.airline(crazyAirResponse.getAirline())
				.supplier(crazyAirResponse.toString())
				.fare(crazyAirResponse.getPrice())
				.departureAirportCode(crazyAirResponse.getDepartureAirportCode())
				.destinationAirportCode(crazyAirResponse.getDestinationAirportCode())
				.departureDate(OffsetDateTime.parse(crazyAirResponse.getDepartureDate(), DateTimeFormatter.ISO_DATE_TIME))
				.arrivalDate(OffsetDateTime.parse(crazyAirResponse.getArrivalDate(), DateTimeFormatter.ISO_DATE_TIME));
		return crazyAirflight;
	}

	private Flight toughJet(BusyFlightsRequest busyFlightsRequest) {
		ToughJetRequest toughJetRequest = new ToughJetRequest();
		toughJetRequest.setFrom(busyFlightsRequest.getOrigin());
		toughJetRequest.setTo(busyFlightsRequest.getDestination());
		toughJetRequest.setOutboundDate(busyFlightsRequest.getDepartureDate().toString());
		toughJetRequest.setInboundDate(busyFlightsRequest.getReturnDate().toString());
		toughJetRequest.setNumberOfAdults(busyFlightsRequest.getNumberOfPassengers());
		ToughJetResponse toughJetResponse = toughJetAPI.sendRequest(toughJetRequest);

		Flight toughJetflight = new Flight();

		toughJetflight.airline(toughJetResponse.getCarrier())
				.supplier(toughJetResponse.toString())
				.fare(toughJetResponse.getBasePrice())
				.departureAirportCode(toughJetResponse.getDepartureAirportName())
				.destinationAirportCode(toughJetResponse.getArrivalAirportName())
				.departureDate(OffsetDateTime.parse(toughJetResponse.getOutboundDateTime(), DateTimeFormatter.ISO_DATE_TIME))
				.arrivalDate(OffsetDateTime.parse(toughJetResponse.getInboundDateTime(), DateTimeFormatter.ISO_DATE_TIME));
		return toughJetflight;
	}

}
