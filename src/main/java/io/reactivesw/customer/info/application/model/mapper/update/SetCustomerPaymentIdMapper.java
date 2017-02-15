package io.reactivesw.customer.info.application.model.mapper.update;

import io.reactivesw.customer.info.application.model.action.SetCustomerPaymentId;
import io.reactivesw.customer.info.domain.model.Customer;
import io.reactivesw.customer.info.infrastructure.update.UpdateAction;
import io.reactivesw.model.Updater;

/**
 * Created by umasuo on 16/12/8.
 */
public class SetCustomerPaymentIdMapper implements Updater<Customer, UpdateAction> {

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
