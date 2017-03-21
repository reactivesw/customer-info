package io.reactivesw.customer.info.infrastructure.update;

import io.reactivesw.customer.info.application.model.mapper.update.AddAddressMapper;
import io.reactivesw.customer.info.application.model.mapper.update.DeleteAddressMapper;
import io.reactivesw.customer.info.application.model.mapper.update.UpdateAddressMapper;
import io.reactivesw.customer.info.application.model.mapper.update.UpdateCustomerInfoMapper;
import io.reactivesw.customer.info.domain.model.Customer;
import io.reactivesw.customer.info.infrastructure.util.UpdateActionUtils;
import io.reactivesw.model.Updater;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * we may got two kind of update: just use the data in action, or still use data from other service.
 * if we just use the data in action, we can only use action mapper to set the data.
 * if we need get data from other palace, we should use update service.
 * Created by umasuo on 16/12/7.
 */
@Service
public class UpdaterService implements Updater<Customer, UpdateAction> {

  /**
   * ApplicationContext for get update services.
   */
  private transient ApplicationContext context;

  /**
   * ImmutableMap for discount code update mapper.
   */
  private transient Map<String, Updater> updateMappers = new ConcurrentHashMap();

  /**
   * constructor.
   *
   * @param context
   */
  public UpdaterService(ApplicationContext context) {
    this.context = context;

    updateMappers.put(UpdateActionUtils.ADD_ADDRESS, new AddAddressMapper());
    updateMappers.put(UpdateActionUtils.DELETE_ADDRESS, new DeleteAddressMapper());
    updateMappers.put(UpdateActionUtils.UPDATE_ADDRESS, new UpdateAddressMapper());
    updateMappers.put(UpdateActionUtils.UPDATE_CUSTOMER_INFO, new UpdateCustomerInfoMapper());
  }

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
