package io.reactivesw.customer.info.application.controller;

import io.reactivesw.customer.info.application.model.CustomerView;
import io.reactivesw.customer.info.application.model.mapper.CustomerMapper;
import io.reactivesw.customer.info.domain.model.Customer;
import io.reactivesw.customer.info.domain.service.CustomerService;
import io.reactivesw.customer.info.infrastructure.Router;
import io.reactivesw.customer.info.infrastructure.update.UpdateRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by umasuo on 16/12/27.
 */
@RestController
public class CustomerController {

  /**
   * logger.
   */
  private final static Logger LOG = LoggerFactory.getLogger(CustomerController.class);

  /**
   * customer service.
   */
  @Autowired
  private transient CustomerService customerService;

  /**
   * EXIT LOGGER INFO.
   */
  private static final String EXIT_LOG_INFO = "exit: customer: {}";


  /**
   * get customer by id.
   *
   * @param id String
   * @return CustomerEntity
   */
  @GetMapping(Router.CUSTOMER_WITH_ID)
  public CustomerView getById(@PathVariable String id) {
    LOG.debug("Enter: id:{}", id);

    Customer customer = customerService.getById(id);

    LOG.debug("Exit: customer:{}", id, customer);
    return CustomerMapper.entityToModel(customer);
  }

  /**
   * update Customer.
   *
   * @param id            customer id String
   * @param updateRequest update request
   * @return updated Customer
   */
  @PostMapping(Router.CUSTOMER_WITH_ID)
  public Customer updateCustomer(@PathVariable String id,
                                 @RequestBody UpdateRequest updateRequest) {
    LOG.info("Enter: id: {}, UpdateRequest: {}", id, updateRequest);

    Customer entity = customerService.updateCustomer(id, updateRequest.getVersion(),
        updateRequest.getActions());

    CustomerView customer = CustomerMapper.entityToModel(entity);

    LOG.info(EXIT_LOG_INFO, customer);
    return null;
  }
}
