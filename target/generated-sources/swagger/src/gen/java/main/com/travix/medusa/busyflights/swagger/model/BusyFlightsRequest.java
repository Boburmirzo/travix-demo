package com.travix.medusa.busyflights.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BusyFlightsRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-08T12:00:02.765+03:00")

public class BusyFlightsRequest   {
  @JsonProperty("origin")
  private String origin = null;

  @JsonProperty("destination")
  private String destination = null;

  @JsonProperty("departureDate")
  private LocalDate departureDate = null;

  @JsonProperty("returnDate")
  private LocalDate returnDate = null;

  @JsonProperty("numberOfPassengers")
  private Integer numberOfPassengers = null;

  public BusyFlightsRequest origin(String origin) {
    this.origin = origin;
    return this;
  }

  /**
   * Get origin
   * @return origin
  **/
  @ApiModelProperty(value = "")


  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public BusyFlightsRequest destination(String destination) {
    this.destination = destination;
    return this;
  }

  /**
   * Get destination
   * @return destination
  **/
  @ApiModelProperty(value = "")


  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public BusyFlightsRequest departureDate(LocalDate departureDate) {
    this.departureDate = departureDate;
    return this;
  }

  /**
   * Get departureDate
   * @return departureDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(LocalDate departureDate) {
    this.departureDate = departureDate;
  }

  public BusyFlightsRequest returnDate(LocalDate returnDate) {
    this.returnDate = returnDate;
    return this;
  }

  /**
   * Get returnDate
   * @return returnDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(LocalDate returnDate) {
    this.returnDate = returnDate;
  }

  public BusyFlightsRequest numberOfPassengers(Integer numberOfPassengers) {
    this.numberOfPassengers = numberOfPassengers;
    return this;
  }

  /**
   * Get numberOfPassengers
   * @return numberOfPassengers
  **/
  @ApiModelProperty(value = "")


  public Integer getNumberOfPassengers() {
    return numberOfPassengers;
  }

  public void setNumberOfPassengers(Integer numberOfPassengers) {
    this.numberOfPassengers = numberOfPassengers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BusyFlightsRequest busyFlightsRequest = (BusyFlightsRequest) o;
    return Objects.equals(this.origin, busyFlightsRequest.origin) &&
        Objects.equals(this.destination, busyFlightsRequest.destination) &&
        Objects.equals(this.departureDate, busyFlightsRequest.departureDate) &&
        Objects.equals(this.returnDate, busyFlightsRequest.returnDate) &&
        Objects.equals(this.numberOfPassengers, busyFlightsRequest.numberOfPassengers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(origin, destination, departureDate, returnDate, numberOfPassengers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BusyFlightsRequest {\n");
    
    sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
    sb.append("    destination: ").append(toIndentedString(destination)).append("\n");
    sb.append("    departureDate: ").append(toIndentedString(departureDate)).append("\n");
    sb.append("    returnDate: ").append(toIndentedString(returnDate)).append("\n");
    sb.append("    numberOfPassengers: ").append(toIndentedString(numberOfPassengers)).append("\n");
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

