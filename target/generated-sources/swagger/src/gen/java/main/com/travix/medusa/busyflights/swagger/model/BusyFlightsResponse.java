package com.travix.medusa.busyflights.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.travix.medusa.busyflights.swagger.model.Flight;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BusyFlightsResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-08T12:00:02.765+03:00")

public class BusyFlightsResponse   {
  @JsonProperty("flight")
  @Valid
  private List<Flight> flight = null;

  public BusyFlightsResponse flight(List<Flight> flight) {
    this.flight = flight;
    return this;
  }

  public BusyFlightsResponse addFlightItem(Flight flightItem) {
    if (this.flight == null) {
      this.flight = new ArrayList<>();
    }
    this.flight.add(flightItem);
    return this;
  }

  /**
   * Get flight
   * @return flight
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Flight> getFlight() {
    return flight;
  }

  public void setFlight(List<Flight> flight) {
    this.flight = flight;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BusyFlightsResponse busyFlightsResponse = (BusyFlightsResponse) o;
    return Objects.equals(this.flight, busyFlightsResponse.flight);
  }

  @Override
  public int hashCode() {
    return Objects.hash(flight);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BusyFlightsResponse {\n");
    
    sb.append("    flight: ").append(toIndentedString(flight)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

