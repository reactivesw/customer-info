package io.reactivesw.customer.info.application.model.mapper;

import io.reactivesw.customer.info.application.model.AddressView;
import io.reactivesw.customer.info.domain.model.Address;

/**
 * address mapper.
 */
public final class AddressMapper {

  /**
   * default private constructor.
   */
  private AddressMapper() {
  }

  /**
   * entity to model.
   *
   * @param entity AddressValue
   * @return Address
   */
  public static AddressView toView(Address entity) {
    AddressView address = null;
    if (entity != null) {
      address = new AddressView();
      address.setId(entity.getId());

      address.setFullName(entity.getFullName());

      address.setPhone(entity.getPhone());

      address.setZip(entity.getZip());

      address.setFirstLine(entity.getFirstLine());

      address.setSecondLine(entity.getSecondLine());

      address.setCountry(entity.getCountry());

      address.setState(entity.getState());

      address.setCity(entity.getCity());

      address.setCreatedAt(entity.getCreatedAt());

      address.setLastModifiedAt(entity.getLastModifiedAt());

    }
    return address;
  }

  /**
   * model to entity.
   *
   * @param view Address
   * @return AddressValue
   */
  public static Address toEntity(AddressView view) {
    Address address = null;
    if (view != null) {
      address = new Address();
      address.setId(view.getId());

      address.setFullName(view.getFullName());

      address.setPhone(view.getPhone());

      address.setZip(view.getZip());

      address.setFirstLine(view.getFirstLine());

      address.setSecondLine(view.getSecondLine());

      address.setCountry(view.getCountry());

      address.setState(view.getState());

      address.setCity(view.getCity());

    }
    return address;
  }
}
