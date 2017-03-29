package io.reactivesw.customer.info.application.model.action;

import io.reactivesw.customer.info.infrastructure.update.UpdateAction;
import io.reactivesw.customer.info.infrastructure.util.UpdateActionUtils;
import lombok.Data;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * update address.
 */
@Data
public class UpdateAddress implements UpdateAction, Serializable {

  /**
   * auto generated serial version id.
   */
  private static final long serialVersionUID = -8594613430362125743L;

  /**
   * uuid.
   */
  @NotNull
  private String id;

  /**
   * full name.
   */
  private String fullName;

  /**
   * zi code.
   */
  @NotNull
  private String zip;

  /**
   * phone.
   */
  @NotNull
  private String phone;

  /**
   * first line.
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

  /**
   * get action name.
   *
   * @return String.
   */
  @Override
  public String getActionName() {
    return UpdateActionUtils.UPDATE_ADDRESS;
  }
}
