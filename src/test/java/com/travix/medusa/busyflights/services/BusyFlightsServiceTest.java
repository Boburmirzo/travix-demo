package com.travix.medusa.busyflights.services;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirAPI;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetAPI;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.swagger.model.BusyFlightsRequest;
import com.travix.medusa.busyflights.swagger.model.BusyFlightsResponse;
import com.travix.medusa.busyflights.util.JsonMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class BusyFlightsServiceTest {

    @Mock
    private CrazyAirAPI crazyAirAPI;

    @Mock
    private ToughJetAPI toughJetAPI;

    @Test
    public void getBusyFlightsService() throws Exception {

        final BusyFlightsRequest busyFlightsRequest = JsonMapper.getResource("busy-flights-request.json", BusyFlightsRequest.class);
        final CrazyAirResponse crazyAirResponse = JsonMapper.getResource("crazy-air-response.json", CrazyAirResponse.class);
        final ToughJetResponse toughJetResponse = JsonMapper.getResource("tough-jet-response.json", ToughJetResponse.class);

        when(crazyAirAPI.sendRequest(any())).thenReturn(crazyAirResponse);
        when(toughJetAPI.sendRequest(any())).thenReturn(toughJetResponse);
        BusyFlightsService busyFlightsService = new BusyFlightsService(crazyAirAPI, toughJetAPI);
        BusyFlightsResponse response = busyFlightsService.getBusyFlightsService(busyFlightsRequest);

        assertThat(response.getFlight().get(0)).isNotNull();
    }

}