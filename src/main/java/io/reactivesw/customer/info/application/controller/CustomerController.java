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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * customer controller.
 */
@RestController
@CrossOrigin
public class CustomerController {

  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

  /**
   * customer service.
   */
  @Autowired
  private transient CustomerService customerService;

  /**
   * get customer by id.
   *
   * @param id String
   * @return CustomerEntity
   */
  @GetMapping(Router.CUSTOMER_WITH_ID)
  public CustomerView getById(@PathVariable String id) {
    LOG.debug("enter. id:{}.", id);

    Customer customer = customerService.getById(id);

    CustomerView result = CustomerMapper.toView(customer);
    LOG.debug("exit. customer: {}.", result);
    return result;
  }

  /**
   * update Customer.
   *
   * @param id            customer id String
   * @param updateRequest update request
   * @return updated Customer
   */
  @PutMapping(Router.CUSTOMER_WITH_ID)
  public CustomerView updateCustomer(@PathVariable String id,
                                     @RequestBody @Valid UpdateRequest updateRequest) {
    LOG.info("enter. id: {}, UpdateRequest: {}.", id, updateRequest);

    Customer entity = customerService.updateCustomer(id, updateRequest.getVersion(),
        updateRequest.getActions());

    CustomerView customer = CustomerMapper.toView(entity);

    LOG.info("exit. customer: {}.", customer);
    return customer;
  }
}
