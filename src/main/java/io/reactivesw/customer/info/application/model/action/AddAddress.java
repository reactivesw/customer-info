package io.reactivesw.customer.info.application.model.action;

import io.reactivesw.customer.info.application.model.AddressView;
import io.reactivesw.customer.info.infrastructure.update.UpdateAction;
import io.reactivesw.customer.info.infrastructure.util.UpdateActionUtils;

public class AddAddress extends AddressView implements UpdateAction {
  @Override
  public String getActionName() {
    return UpdateActionUtils.ADD_ADDRESS;
  }
}
