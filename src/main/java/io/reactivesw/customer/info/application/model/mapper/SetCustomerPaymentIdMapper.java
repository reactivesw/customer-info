package io.reactivesw.customer.info.application.model.mapper;

import io.reactivesw.customer.info.application.model.action.SetCustomerPaymentId;
import io.reactivesw.customer.info.domain.model.Customer;
import io.reactivesw.customer.info.infrastructure.util.UpdateAction;
import io.reactivesw.customer.info.infrastructure.util.Updater;

/**
 * Created by umasuo on 16/12/8.
 */
public class SetCustomerPaymentIdMapper extends Updater {

  /**
   * set location.
   *
   * @param entity DiscountCodeEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(Customer entity, UpdateAction action) {
    SetCustomerPaymentId paymentIdAction = (SetCustomerPaymentId) action;
    entity.setPaymentId(paymentIdAction.getPaymentId());
  }

}
