package io.reactivesw.customer.info.application.model.action;

import io.reactivesw.customer.info.infrastructure.update.UpdateAction;
import io.reactivesw.customer.info.infrastructure.util.UpdateActionUtils;
import lombok.Data;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

@Data
public class SetDefaultAddress implements UpdateAction, Serializable {

  /**
   * address id that must exist in address list.
   */
  @NotNull
  private String addressId;

  @Override
  public String getActionName() {
    return UpdateActionUtils.SET_DEFAULT_ADDRESS;
  }
}
