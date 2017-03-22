package io.reactivesw.customer.info.domain.service.update;

import io.reactivesw.customer.info.application.model.action.DeleteAddress;
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

@Service(value = UpdateActionUtils.DELETE_ADDRESS)
public class DeleteAddressService implements Updater<Customer, UpdateAction> {

  /**
   * logger.
   */
  private final static Logger LOGGER = LoggerFactory.getLogger(DeleteAddressService.class);

  @Override
  public void handle(Customer customer, UpdateAction updateAction) {
    LOGGER.debug("Enter: customer: {}, action: {}", customer, updateAction);

    DeleteAddress deleteAddress = (DeleteAddress) updateAction;
    String addressId = deleteAddress.getId();
    List<Address> addresses = customer.getAddresses();

    Address delAddress = addresses.stream().filter(
        address -> address.getId().equals(addressId)
    ).findFirst().orElse(null);

    if (delAddress == null) {
      LOGGER.debug("Address not exist. addressId: {}, customer: {}", addressId, customer);
      throw new NotExistException("Address not exist. addressId: " + addressId);
    }
    addresses.remove(delAddress);

    LOGGER.debug("Exit: customer: {}, action: {}", customer, updateAction);
  }
}
