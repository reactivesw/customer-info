package io.reactivesw.customer.info.application.model.mapper.update;

import io.reactivesw.customer.info.application.model.AddressView;
import io.reactivesw.customer.info.application.model.action.AddAddress;
import io.reactivesw.customer.info.application.model.mapper.AddressMapper;
import io.reactivesw.customer.info.domain.model.Address;
import io.reactivesw.customer.info.domain.model.Customer;
import io.reactivesw.customer.info.infrastructure.update.UpdateAction;
import io.reactivesw.model.Updater;

/**
 * Created by umasuo on 17/3/15.
 */
public class AddAddressMapper implements Updater<Customer, UpdateAction> {

  @Override
  public void handle(Customer customer, UpdateAction updateAction) {
    AddressView address = (AddressView) updateAction;
    customer.getAddresses().add(AddressMapper.modelToEntity(address));
  }
}
