package io.reactivesw.customer.info.application.model.mapper.update;

import io.reactivesw.customer.info.application.model.AddressView;
import io.reactivesw.customer.info.application.model.mapper.AddressMapper;
import io.reactivesw.customer.info.domain.model.Address;
import io.reactivesw.customer.info.domain.model.Customer;
import io.reactivesw.customer.info.infrastructure.update.UpdateAction;
import io.reactivesw.exception.NotExistException;
import io.reactivesw.model.Updater;

/**
 * Created by umasuo on 17/3/15.
 */
public class UpdateAddressMapper implements Updater<Customer, UpdateAction> {

  @Override
  public void handle(Customer customer, UpdateAction updateAction) {
    AddressView addressView = (AddressView) updateAction;
    Address address = AddressMapper.viewToModel(addressView);
    if (!customer.getAddresses().contains(address)) {
      throw new NotExistException("Address not exist. address: " + address.toString());
    }

    customer.getAddresses().remove(address);
  }
}
