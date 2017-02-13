package io.reactivesw.customer.info.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by umasuo on 17/2/13.
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "address")
public class Address {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  protected String id;

  /**
   * The Created at.
   */
  @CreatedDate
  @Column(name = "created_at")
  protected ZonedDateTime createdAt;

  /**
   * The Last modified at.
   */
  @LastModifiedDate
  @Column(name = "last_modified_at")
  protected ZonedDateTime lastModifiedAt;

  /**
   * title.
   */
  @Column
  private String title;

  /**
   * salutation.
   */
  @Column
  private String salutation;

  /**
   * first name.
   */
  @Column(name = "first_name")
  private String firstName;

  /**
   * last name.
   */
  @Column(name = "last_name")
  private String lastName;

  /**
   * street name.
   */
  @Column(name = "street_name")
  private String streetName;

  /**
   * street number.
   */
  @Column(name = "street_number")
  private String streetNumber;

  /**
   * additional street info.
   */
  @Column(name = "additional_street_info")
  private String additionalStreetInfo;

  /**
   * postal code.
   */
  @Column(name = "postal_code")
  private String postalCode;

  /**
   * city.
   */
  @Column
  private String city;

  /**
   * region.
   */
  @Column
  private String region;

  /**
   * state.
   */
  @Column
  private String state;

  /**
   * country.
   */
  @Column
  private String country;

  /**
   * company.
   */
  @Column
  private String company;

  /**
   * department.
   */
  @Column
  private String department;

  /**
   * building.
   */
  @Column
  private String building;

  /**
   * apartment.
   */
  @Column
  private String apartment;

  /**
   * phone.
   */
  @Column
  private String phone;

  /**
   * mobile.
   */
  @Column
  private String mobile;

  /**
   * email.
   */
  @Column
  private String email;

  /**
   * fax.
   */
  @Column
  private String fax;

  /**
   * additional address info.
   */
  @Column(name = "additional_address_info")
  private String additionalAddressInfo;

  /**
   * external id.
   */
  @Column(name = "external_id")
  private String externalId;
}
