package io.reactivesw.customer.info.domain.service.update;

import io.reactivesw.customer.info.application.model.action.AddAddress;
import io.reactivesw.customer.info.domain.model.Address;
import io.reactivesw.customer.info.domain.model.Customer;
import io.reactivesw.customer.info.infrastructure.update.UpdateAction;
import io.reactivesw.customer.info.infrastructure.util.UpdateActionUtils;
import io.reactivesw.model.Updater;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * add address service.
 */
@Service(value = UpdateActionUtils.ADD_ADDRESS)
public class AddAddressService implements Updater<Customer, UpdateAction> {

  /**
   * logger.
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(AddAddressService.class);

  /**
   * handler.
   *
   * @param customer     customer entity
   * @param updateAction action
   */
  @Override
  public void handle(Customer customer, UpdateAction updateAction) {
    LOGGER.debug("Enter: customer: {}, action: {}", customer, updateAction);

    AddAddress action = (AddAddress) updateAction;

    List<Address> addresses = customer.getAddresses();
    if (addresses == null) {
      LOGGER.debug("Address not exist, create a list.");
      addresses = new ArrayList<>();
    }

    addresses.add(actionToAddress(action));
    customer.setAddresses(addresses);

    LOGGER.debug("Enter: customer: {}, action: {}", customer, updateAction);
  }

  /**
   * convert action's data to address.
   *
   * @param action AddAddress
   * @return Address
   */
  private Address actionToAddress(AddAddress action) {
    Address address = new Address();
    address.setFullName(action.getFullName());
    address.setZip(action.getZip());
    address.setPhone(action.getPhone());
    address.setFirstLine(action.getFirstLine());
    address.setSecondLine(action.getSecondLine());
    address.setCountry(action.getCountry());
    address.setState(action.getState());
    address.setCity(action.getCity());
    return address;
  }
}