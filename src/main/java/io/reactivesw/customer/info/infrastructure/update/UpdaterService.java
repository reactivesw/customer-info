package io.reactivesw.customer.info.infrastructure.update;

import com.google.common.collect.ImmutableMap;
import io.reactivesw.customer.info.application.model.mapper.update.AddAddressMapper;
import io.reactivesw.customer.info.application.model.mapper.update.DeleteAddressMapper;
import io.reactivesw.customer.info.application.model.mapper.update.UpdateAddressMapper;
import io.reactivesw.customer.info.application.model.mapper.update.UpdateCustomerInfoMapper;
import io.reactivesw.customer.info.domain.model.Customer;
import io.reactivesw.customer.info.infrastructure.util.UpdateActionUtils;
import io.reactivesw.model.Updater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * we may got two kind of update: just use the data in action, or still use data from other service.
 * if we just use the data in action, we can only use action mapper to set the data.
 * if we need get data from other palace, we should use update service.
 * Created by umasuo on 16/12/7.
 */
@Service
public class UpdaterService implements Updater<Customer, UpdateAction> {

  /**
   * ImmutableMap for discount code update mapper.
   */
  Map<String, Updater> updateMappers = ImmutableMap.of(
      UpdateActionUtils.ADD_ADDRESS, new AddAddressMapper(),
      UpdateActionUtils.DELETE_ADDRESS, new DeleteAddressMapper(),
      UpdateActionUtils.UPDATE_ADDRESS, new UpdateAddressMapper(),
      UpdateActionUtils.UPDATE_CUSTOMER_INFO, new UpdateCustomerInfoMapper()
  );

  /**
   * ApplicationContext for get update services.
   */
  @Autowired
  private transient ApplicationContext context;

  /**
   * put the value in action to entity.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(Customer entity, UpdateAction action) {
    Updater updater = getUpdateService(action);
    updater.handle(entity, action);
  }

  /**
   * get mapper.
   *
   * @param action UpdateAction class
   * @return ZoneUpdateMapper
   */
  private Updater getUpdateService(UpdateAction action) {
    Updater updater = updateMappers.get(action.getActionName());
    if (updater == null) {
      updater = (UpdaterService) context.getBean(action.getActionName());
    }
    return updater;
  }

}
