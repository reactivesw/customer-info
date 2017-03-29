package io.reactivesw.customer.info.application.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.validation.constraints.NotNull;

/**
 * address view.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressView implements Serializable {

  /**
   * auto generated serial version id.
   */
  private static final long serialVersionUID = -1632982979062241956L;

  /**
   * id.
   */
  private String id;

  /**
   * created time.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime createdAt;

  /**
   * last modified time.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime lastModifiedAt;

  /**
   * full name.
   */
  private String fullName;

  /**
   * zip.
   */
  private String zip;

  /**
   * phone.
   */
  private String phone;

  /**
   * fist line.
   */
  @NotNull
  private String firstLine;

  /**
   * second line.
   */
  private String secondLine;

  /**
   * country.
   */
  @NotNull
  private String country;

  /**
   * state.
   */
  private String state;

  /**
   * city.
   */
  @NotNull
  protected String city;

}
