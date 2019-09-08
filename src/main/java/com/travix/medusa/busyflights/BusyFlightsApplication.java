package com.travix.medusa.busyflights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BusyFlightsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusyFlightsApplication.class, args);

    }
}
