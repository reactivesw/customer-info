package io.reactivesw.customer.info.application.model;

import lombok.Data;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
public class AddressView implements Serializable {

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

}
