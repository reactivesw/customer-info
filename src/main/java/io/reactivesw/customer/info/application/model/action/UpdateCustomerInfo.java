package io.reactivesw.customer.info.application.model.action;

import io.reactivesw.customer.info.application.model.CustomerView;
import io.reactivesw.customer.info.infrastructure.update.UpdateAction;
import io.reactivesw.customer.info.infrastructure.util.UpdateActionUtils;

/**
 * Created by umasuo on 17/3/15.
 */
public class UpdateCustomerInfo extends CustomerView implements UpdateAction {

  @Override
  public String getActionName() {
    return UpdateActionUtils.UPDATE_CUSTOMER_INFO;
  }
}
