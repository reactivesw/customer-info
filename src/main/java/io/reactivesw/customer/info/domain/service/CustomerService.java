package io.reactivesw.customer.info.domain.service;

import io.reactivesw.customer.info.domain.model.Customer;
import io.reactivesw.customer.info.infrastructure.repository.AddressRepository;
import io.reactivesw.customer.info.infrastructure.repository.CustomerRepository;
import io.reactivesw.customer.info.infrastructure.update.UpdateAction;
import io.reactivesw.customer.info.infrastructure.update.UpdaterService;
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
  private transient UpdaterService updateService;

  /**
   * get customer by id.
   *
   * @param id String
   * @return CustomerEntity
   */
  public Customer getById(String id) {
    LOG.debug("Enter: id:{}", id);
    Customer entity = customerRepository.findOne(id);
    if (entity == null) {
      LOG.warn("customer not exist: id:{}", id);
      throw new NotExistException("customer not exist. id:" + id);
    }
    LOG.debug("Exit: id:{}, customer:{}", id, entity);
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
    LOG.debug("Enter: id: {}, version: {}, actions: {}", id, version, actions);

    Customer valueInDb = getOrCreateCustomer(id);
    LOG.debug("data in db: {}", valueInDb);
    checkVersion(version, valueInDb.getVersion());

    actions.stream().forEach(
        action -> updateService.handle(valueInDb, action)
    );

    LOG.debug("Exit: data updated: {}", valueInDb);
    return customerRepository.save(valueInDb);
  }

  /**
   * get an existing or create an new customer.
   *
   * @param id customer id.
   * @return Customer
   */
  private Customer getOrCreateCustomer(String id) {
    LOG.debug("Enter: id:{}", id);

    Customer customer = customerRepository.findOne(id);
    if (customer == null) {
      customer = new Customer();
      customer.setId(id);
      customer = customerRepository.save(customer);
    }
    return customer;
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
