package io.reactivesw.customer.info.application.model.action;

import io.reactivesw.customer.info.infrastructure.update.UpdateAction;
import io.reactivesw.customer.info.infrastructure.util.UpdateActionUtils;
import lombok.Data;

/**
 * Created by umasuo on 17/3/15.
 */
@Data
public class DeleteAddress implements UpdateAction {

  private String addressId;

  @Override
  public String getActionName() {
    return UpdateActionUtils.DELETE_ADDRESS;
  }
}
