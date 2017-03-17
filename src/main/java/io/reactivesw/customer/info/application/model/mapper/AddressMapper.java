package io.reactivesw.customer.info.application.model.mapper;

import io.reactivesw.customer.info.application.model.AddressView;
import io.reactivesw.customer.info.domain.model.Address;

/**
 * Created by umasuo on 17/1/5.
 */
public class AddressMapper {

  /**
   * entity to model.
   *
   * @param entity AddressValue
   * @return Address
   */
  public static AddressView modelToView(Address entity) {
    AddressView address = null;
    if (entity != null) {
      address = new AddressView();
      address.setId(entity.getId());

      address.setName(entity.getName());

      address.setSalutation(entity.getSalutation());

      address.setFirstName(entity.getFirstName());

      address.setLastName(entity.getLastName());

      address.setPostalCode(entity.getPostalCode());

      address.setPhone(entity.getPhone());

      address.setEmail(entity.getEmail());

      address.setFirstLine(entity.getFirstLine());

      address.setSecondLine(entity.getSecondLine());

    }
    return address;
  }

  /**
   * model to entity.
   *
   * @param view Address
   * @return AddressValue
   */
  public static Address viewToModel(AddressView view) {
    Address address = null;
    if (view != null) {
      address = new Address();
      address.setId(view.getId());

      address.setName(view.getName());

      address.setSalutation(view.getSalutation());

      address.setFirstName(view.getFirstName());

      address.setLastName(view.getLastName());

      address.setPostalCode(view.getPostalCode());

      address.setPhone(view.getPhone());

      address.setEmail(view.getEmail());

      address.setFirstLine(view.getFirstLine());

      address.setSecondLine(view.getSecondLine());

    }
    return address;
  }
}
