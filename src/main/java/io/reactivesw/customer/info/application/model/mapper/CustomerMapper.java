package io.reactivesw.customer.info.application.model.mapper;


import io.reactivesw.customer.info.application.model.AddressView;
import io.reactivesw.customer.info.application.model.CustomerView;
import io.reactivesw.customer.info.domain.model.Address;
import io.reactivesw.customer.info.domain.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
      model.setPassword(entity.getPassword());
      model.setCustomerName(entity.getCustomerName());
      model.setVersion(entity.getVersion());
      model.setFirstName(entity.getFirstName());
      model.setLastName(entity.getLastName());
      model.setMiddleName(entity.getMiddleName());
      model.setTitle(entity.getTitle());
      model.setDateOfBirth(entity.getDateOfBirth());
      model.setCompanyName(entity.getCompanyName());
      model.setVatId(entity.getVatId());

      List<AddressView> addressList = new ArrayList<>();
      Set<Address> addressValueSet = entity.getAddresses();
      if (addressValueSet != null) {
        addressValueSet.parallelStream().forEach(
            addressValue -> addressList.add(AddressMapper.modelToView(addressValue))
        );
      }
      model.setAddresses(addressList);

      model.setDefaultShippingAddressId(entity.getDefaultShippingAddressId());
      model.setDefaultBillingAddressId(entity.getDefaultBillingAddressId());
      model.setIsEmailVerified(entity.getIsEmailVerified());

      model.setLocale(entity.getLocale());
    }

    return model;
  }


  /**
   * copy value.
   *
   * @param value CustomerEntity
   * @return Customer
   */
  public static void copyValue(Customer model, CustomerView value) {
    if (value != null && model != null) {
      model.setId(value.getId());
      model.setPassword(value.getPassword());
      model.setCustomerName(value.getCustomerName());
      model.setVersion(value.getVersion());
      model.setFirstName(value.getFirstName());
      model.setLastName(value.getLastName());
      model.setMiddleName(value.getMiddleName());
      model.setTitle(value.getTitle());
      model.setDateOfBirth(value.getDateOfBirth());
      model.setCompanyName(value.getCompanyName());
      model.setVatId(value.getVatId());
      model.setDefaultShippingAddressId(value.getDefaultShippingAddressId());
      model.setDefaultBillingAddressId(value.getDefaultBillingAddressId());
      model.setIsEmailVerified(value.getIsEmailVerified());

      model.setLocale(value.getLocale());
    }
  }

}
