package io.reactivesw.customer.info.application.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * customer view.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerView implements Serializable {

  /**
   * auto generated serial version id.
   */
  private static final long serialVersionUID = -5578159442550944417L;

  /**
   * customer id, use uuid.
   */
  @JsonProperty
  private String id;

  /**
   * version.
   */
  @JsonProperty
  private Integer version;

  /**
   * The customer number can be used to create a more human-readable (in contrast to ID) identifier
   * for the customer. It should be unique across a merchant. Once the field was set it cannot be
   * changed anymore.
   */
  @JsonProperty
  private String customerName;

  /**
   * create time.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime createdAt;

  /**
   * modify time.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime lastModifiedAt;

  /**
   * first name.
   */
  @JsonProperty
  private String firstName;

  /**
   * last name.
   */
  @JsonProperty
  private String lastName;

  /**
   * middle name.
   */
  @JsonProperty
  private String middleName;

  /**
   * date of birth.
   */
  @JsonProperty
  private ZonedDateTime dateOfBirth;

  /**
   * The addresses have unique IDs in the addresses list.
   */
  @JsonProperty
  private List<AddressView> addresses;

  /**
   * The address ID in the addresses list.
   */
  @JsonProperty
  private String defaultAddressId;

  /**
   * locale.
   */
  @JsonProperty
  private String locale;

}
