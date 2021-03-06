package io.reactivesw.customer.info.domain.service.update;

import io.reactivesw.customer.info.application.model.action.UpdateCustomerInfo;
import io.reactivesw.customer.info.domain.model.Address;
import io.reactivesw.customer.info.domain.model.Customer;
import io.reactivesw.customer.info.infrastructure.update.UpdateAction;
import io.reactivesw.customer.info.infrastructure.util.UpdateActionUtils;
import io.reactivesw.exception.NotExistException;
import io.reactivesw.model.Updater;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * update customer info service.
 */
@Service(value = UpdateActionUtils.UPDATE_CUSTOMER_INFO)
public class UpdateCustomerInfoService implements Updater<Customer, UpdateAction> {

  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UpdateCustomerInfoService.class);

  /**
   * handler.
   *
   * @param customer     customer entity
   * @param updateAction update action
   */
  @Override
  public void handle(Customer customer, UpdateAction updateAction) {
    LOG.debug("Enter: customer: {}, Action: {}", customer, updateAction);

    UpdateCustomerInfo customerView = (UpdateCustomerInfo) updateAction;
    copyValue(customer, customerView);

    LOG.debug("Exit: customer: {}", customer);
  }


  /**
   * copy value.
   *
   * @param view CustomerEntity
   * @return Customer
   */
  private void copyValue(Customer customer, UpdateCustomerInfo view) {
    if (view != null && customer != null) {
      customer.setCustomerName(view.getCustomerName());
      customer.setFirstName(view.getFirstName());
      customer.setLastName(view.getLastName());
      customer.setMiddleName(view.getMiddleName());
      customer.setDateOfBirth(view.getDateOfBirth());

      setDefaultAddress(customer, view.getDefaultAddressId());
      customer.setLocale(view.getLocale());
    }
  }

  /**
   * set the default address, before set, check if the address exist.
   *
   * @param customer  customer entity
   * @param addressId address id
   */
  private void setDefaultAddress(Customer customer, String addressId) {
    List<Address> addresses = customer.getAddresses();

    Address addressExist = addresses.stream().filter(
        address -> address.getId().equals(addressId)
    ).findAny().orElse(null);

    if (addressExist == null && addressId != null) {
      LOG.warn("The address set as default not exist. AddressId: {}, customer: {}", addressId,
          customer);
      throw new NotExistException("The address set as default not exist.");
    }

    customer.setDefaultAddressId(addressId);
  }
}