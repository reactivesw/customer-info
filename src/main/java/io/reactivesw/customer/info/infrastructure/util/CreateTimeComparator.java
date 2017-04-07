package io.reactivesw.customer.info.infrastructure.util;

import io.reactivesw.customer.info.application.model.AddressView;

import java.io.Serializable;
import java.util.Comparator;

/**
 * compare address with create time.
 */
public class CreateTimeComparator implements Comparator<AddressView>, Serializable {

  /**
   * auto generated serial version id.
   */
  private static final long serialVersionUID = -79751054479830991L;

  /**
   * compare  two address with create time.
   */
  @Override
  public int compare(AddressView o1, AddressView o2) {
    return o1.getCreatedAt().compareTo(o2.getCreatedAt());
  }
}
