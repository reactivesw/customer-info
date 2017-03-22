package io.reactivesw.customer.info.application.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
public class AddressView implements Serializable, Comparable<AddressView> {

  private String id;

  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime createdAt;

  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime lastModifiedAt;

  private String fullName;

  private String zip;

  private String phone;

  private String firstLine;

  private String secondLine;

  private String country;

  private String state;

  protected String city;

  @Override
  public int compareTo(AddressView compareAddress) {
    return this.createdAt.compareTo(((AddressView) compareAddress).getCreatedAt());
  }
}
