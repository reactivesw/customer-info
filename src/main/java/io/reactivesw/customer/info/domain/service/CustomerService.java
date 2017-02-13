package io.reactivesw.customer.info.domain.service;

import io.reactivesw.customer.info.domain.model.Customer;
import io.reactivesw.customer.info.infrastructure.repository.CustomerRepository;
import io.reactivesw.customer.info.infrastructure.util.Updater;
import io.reactivesw.customer.info.infrastructure.util.UpdateAction;
import io.reactivesw.exception.ConflictException;
import io.reactivesw.exception.NotExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by umasuo on 16/12/26.
 */
@Service
public class CustomerService {

  /**
   * logger.
   */
  private final static Logger LOG = LoggerFactory.getLogger(CustomerService.class);

  /**
   * customer repository.
   */
  @Autowired
  private transient CustomerRepository customerRepository;

  /**
   * update service.
   */
  @Autowired
  private transient Updater updateService;

  /**
   * get customer by id.
   *
   * @param id String
   * @return CustomerEntity
   */
  public Customer getById(String id) {
    LOG.debug("enter: id:{}", id);
    Customer entity = this.customerRepository.findOne(id);
    if (entity == null) {
      LOG.warn("customer not exist: id:{}", id);
      throw new NotExistException("customer not exist. id:" + id);
    }
    LOG.debug("exit: id:{}, customer:{}", id, entity);
    return entity;
  }


  /**
   * update customer with with update actions.
   *
   * @param id      customer id.
   * @param version current version
   * @param actions update actions
   * @return Customer entity
   */
  public Customer updateCustomer(String id, Integer version, List<UpdateAction> actions) {
    LOG.debug("enter: id: {}, version: {}, actions: {}", id, version, actions);

    Customer valueInDb = this.getById(id);
    LOG.debug("data in db: {}", valueInDb);
    checkVersion(version, valueInDb.getVersion());

    actions.parallelStream().forEach(
        action -> updateService.handle(valueInDb, action)
    );

    LOG.debug("data updated: {}", valueInDb);
    return this.customerRepository.save(valueInDb);
  }

  /**
   * check the version.
   *
   * @param inputVersion Integer
   * @param existVersion Integer
   */
  private void checkVersion(Integer inputVersion, Integer existVersion) {
    if (!inputVersion.equals(existVersion)) {
      LOG.debug("Customer version is not correct.");
      throw new ConflictException("Customer version is not correct.");
    }
  }

}
