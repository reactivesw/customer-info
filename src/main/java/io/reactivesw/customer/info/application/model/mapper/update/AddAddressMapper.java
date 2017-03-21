package io.reactivesw.customer.info.application.model.mapper.update;

import io.reactivesw.customer.info.application.model.AddressView;
import io.reactivesw.customer.info.application.model.mapper.AddressMapper;
import io.reactivesw.customer.info.domain.model.Address;
import io.reactivesw.customer.info.domain.model.Customer;
import io.reactivesw.customer.info.infrastructure.update.UpdateAction;
import io.reactivesw.model.Updater;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by umasuo on 17/3/15.
 */
public class AddAddressMapper implements Updater<Customer, UpdateAction> {

  @Override
  public void handle(Customer customer, UpdateAction updateAction) {
    AddressView address = (AddressView) updateAction;
    Address addressValue = AddressMapper.viewToModel(address);
    addressValue.setId(null);// don't set id when add address
    Set<Address> addresses =  customer.getAddresses();
    if(addresses==null){
      addresses = new HashSet<>();
    }
    addresses.add(AddressMapper.viewToModel(address));
    customer.setAddresses(addresses);
  }
}
