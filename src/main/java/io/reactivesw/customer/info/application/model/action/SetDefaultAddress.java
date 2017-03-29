package io.reactivesw.customer.info.application.model.action;

import io.reactivesw.customer.info.infrastructure.update.UpdateAction;
import io.reactivesw.customer.info.infrastructure.util.UpdateActionUtils;
import lombok.Data;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * set default address.
 */
@Data
public class SetDefaultAddress implements UpdateAction, Serializable {

  /**
   * auto generated serial version id.
   */
  private static final long serialVersionUID = -6226537119290493436L;

  /**
   * address id that must exist in address list.
   */
  @NotNull
  private String addressId;

  /**
   * get action name.
   *
   * @return String
   */
  @Override
  public String getActionName() {
    return UpdateActionUtils.SET_DEFAULT_ADDRESS;
  }
}
