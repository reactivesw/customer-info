package io.reactivesw.customer.info.application.model.action;

import io.reactivesw.customer.info.application.model.AddressView;
import io.reactivesw.customer.info.infrastructure.update.UpdateAction;
import io.reactivesw.customer.info.infrastructure.util.UpdateActionUtils;
import lombok.Data;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * update customer info.
 */
@Data
public class UpdateCustomerInfo implements UpdateAction, Serializable {

  /**
   * auto generated serial version id.
   */
  private static final long serialVersionUID = 213285610016106156L;

  /**
   * customer name.
   */
  private String customerName;

  /**
   * first name.
   */
  private String firstName;

  /**
   * last name.
   */
  private String lastName;

  /**
   * middle name.
   */
  private String middleName;

  /**
   * date of birth.
   */
  private ZonedDateTime dateOfBirth;

  /**
   * addresses.
   */
  private List<AddressView> addresses;

  /**
   * default address id.
   */
  private String defaultAddressId;

  /**
   * locale.
   */
  private String locale;

  /**
   * get action name.
   *
   * @return String
   */
  @Override
  public String getActionName() {
    return UpdateActionUtils.UPDATE_CUSTOMER_INFO;
  }
}
