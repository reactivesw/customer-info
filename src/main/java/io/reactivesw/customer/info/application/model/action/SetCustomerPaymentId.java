package io.reactivesw.customer.info.application.model.action;

import io.reactivesw.customer.info.infrastructure.update.UpdateAction;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by umasuo on 16/12/8.
 */
@Getter
@Setter
public class SetCustomerPaymentId implements UpdateAction {

  /**
   * location.
   */
  private String paymentId;

  @Override
  public String getActionName() {
    return "SetCustomerPaymentId";
  }
}
