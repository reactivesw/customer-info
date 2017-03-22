package io.reactivesw.customer.info.application.model;

import lombok.Data;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
public class AddressView implements Serializable, Comparable<AddressView> {

  private String id;

  private ZonedDateTime createdAt;

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
