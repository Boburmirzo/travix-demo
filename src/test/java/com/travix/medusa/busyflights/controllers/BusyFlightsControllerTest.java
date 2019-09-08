package com.travix.medusa.busyflights.controllers;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.travix.medusa.busyflights.services.BusyFlightsService;
import com.travix.medusa.busyflights.swagger.model.BusyFlightsResponse;
import com.travix.medusa.busyflights.util.JsonMapper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BusyFlightsControllerTest {

    private static final String CRAZY_AIR_PATH = "/crazyair/flights";
    private static final String TOUGH_JET_PATH = "/toughjet/flights";

    private static final String BUSY_FLIGHTS_PATH = "/flights";

    private BusyFlightsController busyFlightsController;

    @Mock
    private BusyFlightsService busyFlightsService;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;

    @Before
    public void setup() throws Exception {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        busyFlightsController = new BusyFlightsController(busyFlightsService);
    }

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8090);

    @Test
    public void getFlights() throws Exception {
        final String crazyAirResponseJson = JsonMapper.getResource("crazy-air-response.json");

        stubFor(WireMock.post(urlPathMatching(CRAZY_AIR_PATH))
                .willReturn(aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBody(crazyAirResponseJson)));

        final String toughJetResponseJson = JsonMapper.getResource("tough-jet-response.json");
        stubFor(WireMock.post(urlPathMatching(TOUGH_JET_PATH))
                .willReturn(aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBody(toughJetResponseJson)));

        final String requestJson = JsonMapper.getResource("busy-flights-request.json");
        final MockHttpServletResponse response = mvc.perform(
                post(BUSY_FLIGHTS_PATH)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(requestJson))
                .andExpect(status().is2xxSuccessful())
                .andReturn()
                .getResponse();


        final BusyFlightsResponse result = JsonMapper.fromJson(response.getContentAsString(), BusyFlightsResponse.class);

        assertThat(result.getFlight().get(0)).isNotNull();

    }


}