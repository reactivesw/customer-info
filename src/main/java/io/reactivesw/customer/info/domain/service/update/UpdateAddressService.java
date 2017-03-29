package io.reactivesw.customer.info.domain.service.update;

import io.reactivesw.customer.info.application.model.action.UpdateAddress;
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
 * update address service.
 */
@Service(value = UpdateActionUtils.UPDATE_ADDRESS)
public class UpdateAddressService implements Updater<Customer, UpdateAction> {

  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UpdateAddressService.class);

  /**
   * handler.
   *
   * @param customer     customer entity
   * @param updateAction update action
   */
  @Override
  public void handle(Customer customer, UpdateAction updateAction) {
    LOG.debug("Enter: customer: {}, action: {}", customer, updateAction);
    UpdateAddress action = (UpdateAddress) updateAction;

    List<Address> addresses = customer.getAddresses();

    if (addresses == null || addresses.isEmpty()) {
      LOG.debug("Address not exist. address: {}, customer: {}", updateAction, customer);
      throw new NotExistException("Address not exist. address: " + action.toString());
    }

    Address addressInDb = addresses.stream().filter(
        address -> address.getId().equals(action.getId())
    ).findAny().orElse(null);

    if (addressInDb == null) {
      LOG.debug("Address not exist. address: {}, customer: {}", updateAction, customer);
      throw new NotExistException("Address not exist. address: " + action.toString());
    }

    //copy the value to the address stored.
    copyValue(addressInDb, action);
    LOG.debug("Exit: customer: {}, action: {}", customer, updateAction);
  }

  /**
   * convert action's data to address.
   *
   * @param action AddAddress
   * @return Address
   */
  private Address copyValue(Address address, UpdateAddress action) {
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
