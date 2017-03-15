package io.reactivesw.customer.info.application.model.mapper.update;

import io.reactivesw.customer.info.application.model.action.DeleteAddress;
import io.reactivesw.customer.info.domain.model.Address;
import io.reactivesw.customer.info.domain.model.Customer;
import io.reactivesw.customer.info.infrastructure.update.UpdateAction;
import io.reactivesw.exception.NotExistException;
import io.reactivesw.model.Updater;

import java.util.Set;

/**
 * Created by umasuo on 17/3/15.
 */
public class DeleteAddressMapper implements Updater<Customer, UpdateAction> {

  @Override
  public void handle(Customer customer, UpdateAction updateAction) {
    DeleteAddress deleteAddress = (DeleteAddress) updateAction;
    String addressId = deleteAddress.getAddressId();
    Set<Address> addresses = customer.getAddresses();

    Address delAddress = addresses.stream().filter(
        address -> {
          return address.getId().equals(addressId);
        }
    ).findFirst().orElse(null);

    if (delAddress == null) {
      throw new NotExistException("Address not exist. addressId: " + addressId);
    }
    addresses.remove(delAddress);
  }
}
