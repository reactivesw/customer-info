package io.reactivesw.customer.info.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

import javax.persistence.Id;

/**
 * Created by umasuo on 17/2/13.
 */
@Data
public class AddressView implements Serializable {

  @JsonProperty
  @Id
  private String id;

  @JsonProperty
  private String name;

  @JsonProperty
  private String salutation;

  @JsonProperty
  private String firstName;

  @JsonProperty
  private String lastName;

  @JsonProperty
  private String postalCode;

  @JsonProperty
  private String phone;

  @JsonProperty
  private String email;

  @JsonProperty
  private String firstLine;

  @JsonProperty
  private String secondLine;

}
