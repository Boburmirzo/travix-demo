package com.travix.medusa.busyflights.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Flight
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-09-08T12:00:02.765+03:00")

public class Flight   {
  @JsonProperty("airline")
  private String airline = null;

  @JsonProperty("supplier")
  private String supplier = null;

  @JsonProperty("fare")
  private Double fare = null;

  @JsonProperty("departureAirportCode")
  private String departureAirportCode = null;

  @JsonProperty("destinationAirportCode")
  private String destinationAirportCode = null;

  @JsonProperty("departureDate")
  private OffsetDateTime departureDate = null;

  @JsonProperty("arrivalDate")
  private OffsetDateTime arrivalDate = null;

  public Flight airline(String airline) {
    this.airline = airline;
    return this;
  }

  /**
   * Get airline
   * @return airline
  **/
  @ApiModelProperty(value = "")


  public String getAirline() {
    return airline;
  }

  public void setAirline(String airline) {
    this.airline = airline;
  }

  public Flight supplier(String supplier) {
    this.supplier = supplier;
    return this;
  }

  /**
   * Get supplier
   * @return supplier
  **/
  @ApiModelProperty(value = "")


  public String getSupplier() {
    return supplier;
  }

  public void setSupplier(String supplier) {
    this.supplier = supplier;
  }

  public Flight fare(Double fare) {
    this.fare = fare;
    return this;
  }

  /**
   * Get fare
   * @return fare
  **/
  @ApiModelProperty(value = "")


  public Double getFare() {
    return fare;
  }

  public void setFare(Double fare) {
    this.fare = fare;
  }

  public Flight departureAirportCode(String departureAirportCode) {
    this.departureAirportCode = departureAirportCode;
    return this;
  }

  /**
   * Get departureAirportCode
   * @return departureAirportCode
  **/
  @ApiModelProperty(value = "")


  public String getDepartureAirportCode() {
    return departureAirportCode;
  }

  public void setDepartureAirportCode(String departureAirportCode) {
    this.departureAirportCode = departureAirportCode;
  }

  public Flight destinationAirportCode(String destinationAirportCode) {
    this.destinationAirportCode = destinationAirportCode;
    return this;
  }

  /**
   * Get destinationAirportCode
   * @return destinationAirportCode
  **/
  @ApiModelProperty(value = "")


  public String getDestinationAirportCode() {
    return destinationAirportCode;
  }

  public void setDestinationAirportCode(String destinationAirportCode) {
    this.destinationAirportCode = destinationAirportCode;
  }

  public Flight departureDate(OffsetDateTime departureDate) {
    this.departureDate = departureDate;
    return this;
  }

  /**
   * Get departureDate
   * @return departureDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(OffsetDateTime departureDate) {
    this.departureDate = departureDate;
  }

  public Flight arrivalDate(OffsetDateTime arrivalDate) {
    this.arrivalDate = arrivalDate;
    return this;
  }

  /**
   * Get arrivalDate
   * @return arrivalDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getArrivalDate() {
    return arrivalDate;
  }

  public void setArrivalDate(OffsetDateTime arrivalDate) {
    this.arrivalDate = arrivalDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Flight flight = (Flight) o;
    return Objects.equals(this.airline, flight.airline) &&
        Objects.equals(this.supplier, flight.supplier) &&
        Objects.equals(this.fare, flight.fare) &&
        Objects.equals(this.departureAirportCode, flight.departureAirportCode) &&
        Objects.equals(this.destinationAirportCode, flight.destinationAirportCode) &&
        Objects.equals(this.departureDate, flight.departureDate) &&
        Objects.equals(this.arrivalDate, flight.arrivalDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(airline, supplier, fare, departureAirportCode, destinationAirportCode, departureDate, arrivalDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Flight {\n");
    
    sb.append("    airline: ").append(toIndentedString(airline)).append("\n");
    sb.append("    supplier: ").append(toIndentedString(supplier)).append("\n");
    sb.append("    fare: ").append(toIndentedString(fare)).append("\n");
    sb.append("    departureAirportCode: ").append(toIndentedString(departureAirportCode)).append("\n");
    sb.append("    destinationAirportCode: ").append(toIndentedString(destinationAirportCode)).append("\n");
    sb.append("    departureDate: ").append(toIndentedString(departureDate)).append("\n");
    sb.append("    arrivalDate: ").append(toIndentedString(arrivalDate)).append("\n");
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

