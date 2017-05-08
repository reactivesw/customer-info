package io.reactivesw.customer.info.application.model.mapper;


import io.reactivesw.customer.info.application.model.AddressView;
import io.reactivesw.customer.info.application.model.CustomerView;
import io.reactivesw.customer.info.domain.model.Address;
import io.reactivesw.customer.info.domain.model.Customer;
import io.reactivesw.customer.info.infrastructure.util.CreateTimeComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Customer mapper.
 */
public final class CustomerMapper {


  /**
   * Create time comparator.
   */
  private static CreateTimeComparator comparator = new CreateTimeComparator();

  /**
   * Default private constructor.
   */
  private CustomerMapper() {
  }

  /**
   * Entity to model.
   *
   * @param entity CustomerEntity
   * @return Customer
   */
  public static CustomerView toView(Customer entity) {
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
      List<Address> addressValueList = entity.getAddresses();
      if (addressValueList != null) {
        addressValueList.stream().forEach(
            addressValue -> addressList.add(AddressMapper.toView(addressValue))
        );
      }
      // sort the address with create time.
      Collections.sort(addressList, comparator);
      model.setAddresses(addressList);

      model.setDefaultAddressId(entity.getDefaultAddressId());

      model.setLocale(entity.getLocale());

      model.setCreatedAt(entity.getCreatedAt());
    }

    return model;
  }


}
