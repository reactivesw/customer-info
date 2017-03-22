package io.reactivesw.customer.info.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Created by umasuo on 17/2/13.
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "customer")
@EntityListeners(AuditingEntityListener.class)
public class Customer {

  /**
   * customer id. create in customer authentication.
   */
  @Id
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
   * The customer number can be used to create a more human-readable (in contrast to ID) identifier
   * for the customer. It should be unique across a merchant. Once the field was set it cannot be
   * changed anymore.
   */
  @Column(name = "customer_name", unique = true)
  private String customerName;

  /**
   * version.
   */
  @Version
  @Column(name = "version")
  private Integer version;

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
   * middle name.
   */
  @Column(name = "middle_name")
  private String middleName;

  /**
   * date of birth.
   */
  @Column(name = "date_of_birth")
  private ZonedDateTime dateOfBirth;

  /**
   * The addresses have unique IDs in the addresses list.
   */
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private List<Address> addresses;

  /**
   * The address ID in the addresses list.
   */
  @Column(name = "default_address_id")
  private String defaultAddressId;

  /**
   * locale.
   */
  @Column(name = "locale")
  private String locale;
}
