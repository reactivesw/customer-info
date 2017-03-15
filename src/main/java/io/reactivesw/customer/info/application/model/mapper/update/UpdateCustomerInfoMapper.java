package io.reactivesw.customer.info.application.model.mapper.update;

import io.reactivesw.customer.info.application.model.CustomerView;
import io.reactivesw.customer.info.application.model.mapper.CustomerMapper;
import io.reactivesw.customer.info.domain.model.Address;
import io.reactivesw.customer.info.domain.model.Customer;
import io.reactivesw.customer.info.infrastructure.update.UpdateAction;
import io.reactivesw.model.Updater;

import java.util.Set;

/**
 * Created by umasuo on 17/3/15.
 */
public class UpdateCustomerInfoMapper implements Updater<Customer, UpdateAction> {

  @Override
  public void handle(Customer customer, UpdateAction updateAction) {
    CustomerView customerView = (CustomerView) updateAction;

    CustomerMapper.copyValue(customer, customerView);
  }
}
