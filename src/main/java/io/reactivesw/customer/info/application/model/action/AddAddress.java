package io.reactivesw.customer.info.application.model.action;

import io.reactivesw.customer.info.infrastructure.update.UpdateAction;
import io.reactivesw.customer.info.infrastructure.util.UpdateActionUtils;
import lombok.Data;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * add address action.
 */
@Data
public class AddAddress implements UpdateAction, Serializable {

  /**
   * auto generated serial version id.
   */
  private static final long serialVersionUID = 1597898734365622271L;

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
   * @return String
   */
  @Override
  public String getActionName() {
    return UpdateActionUtils.ADD_ADDRESS;
  }
}
