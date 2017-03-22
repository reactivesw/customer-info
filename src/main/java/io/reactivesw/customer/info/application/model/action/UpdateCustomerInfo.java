package io.reactivesw.customer.info.application.model.action;

import io.reactivesw.customer.info.application.model.AddressView;
import io.reactivesw.customer.info.infrastructure.update.UpdateAction;
import io.reactivesw.customer.info.infrastructure.util.UpdateActionUtils;
import lombok.Data;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

@Data
public class UpdateCustomerInfo implements UpdateAction, Serializable {

  private String customerName;

  private String firstName;

  private String lastName;

  private String middleName;

  private ZonedDateTime dateOfBirth;

  private List<AddressView> addresses;

  private String defaultAddressId;

  private String locale;

  @Override
  public String getActionName() {
    return UpdateActionUtils.UPDATE_CUSTOMER_INFO;
  }
}
