package io.reactivesw.customer.info.application.model.mapper;


import io.reactivesw.customer.info.application.model.AddressView;
import io.reactivesw.customer.info.application.model.CustomerView;
import io.reactivesw.customer.info.domain.model.Address;
import io.reactivesw.customer.info.domain.model.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by umasuo on 17/1/9.
 */
public class CustomerMapper {

  /**
   * entity to model.
   *
   * @param entity CustomerEntity
   * @return Customer
   */
  public static CustomerView entityToModel(Customer entity) {
    CustomerView model = null;
    if (entity != null) {
      model = new CustomerView();
      model.setId(entity.getId());
      model.setCustomerName(entity.getCustomerName());
      model.setVersion(entity.getVersion());
      model.setFirstName(entity.getFirstName());
      model.setLastName(entity.getLastName());
      model.setMiddleName(entity.getMiddleName());
      model.setDateOfBirth(entity.getDateOfBirth());

      List<AddressView> addressList = new ArrayList<>();
      List<Address> addressValueSet = entity.getAddresses();
      if (addressValueSet != null) {
        addressValueSet.stream().forEach(
            addressValue -> addressList.add(AddressMapper.modelToView(addressValue))
        );
      }
      model.setAddresses(addressList);

      model.setDefaultAddressId(entity.getDefaultAddressId());

      model.setLocale(entity.getLocale());

      model.setCreatedAt(entity.getCreatedAt());
    }

    return model;
  }



}
