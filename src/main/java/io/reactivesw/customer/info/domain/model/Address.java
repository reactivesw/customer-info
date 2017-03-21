package io.reactivesw.customer.info.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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
@EntityListeners(AuditingEntityListener.class)
public class Address {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id")
  private String id;

  /**
   * The Created at.
   */
  @CreatedDate
  @Column(name = "created_at")
  private ZonedDateTime createdAt;

  /**
   * The Last modified at.
   */
  @LastModifiedDate
  @Column(name = "last_modified_at")
  private ZonedDateTime lastModifiedAt;

  /**
   * name of this address.
   */
  @Column
  private String fullName;

  /**
   * postal code.
   */
  @Column
  private String zip;

  /**
   * phone.
   */
  @Column
  private String phone;

  /**
   * additional address info.
   */
  @Column
  private String firstLine;

  /**
   * external id.
   */
  @Column
  private String secondLine;

  @Column
  private String country;

  @Column
  private String state;

  @Column
  protected String city;
}
