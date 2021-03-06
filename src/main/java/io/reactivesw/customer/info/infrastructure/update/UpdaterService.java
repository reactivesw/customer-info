package io.reactivesw.customer.info.infrastructure.update;

import io.reactivesw.customer.info.domain.model.Customer;
import io.reactivesw.model.Updater;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * updater service.
 */
@Service
public class UpdaterService implements Updater<Customer, UpdateAction> {

  /**
   * ApplicationContext for get update services.
   */
  private transient ApplicationContext context;

  /**
   * constructor.
   *
   * @param context ApplicationContext
   */
  public UpdaterService(ApplicationContext context) {
    this.context = context;
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
    return (Updater) context.getBean(action.getActionName());
  }

}
