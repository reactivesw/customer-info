package io.reactivesw.customer.info.application.controller;

import io.reactivesw.customer.info.application.model.CustomerView;
import io.reactivesw.customer.info.application.model.mapper.CustomerMapper;
import io.reactivesw.customer.info.domain.model.Customer;
import io.reactivesw.customer.info.domain.service.CustomerService;
import io.reactivesw.customer.info.infrastructure.Router;
import io.reactivesw.customer.info.infrastructure.util.UpdateRequest;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
   * update Customer.
   *
   * @param id            customer id String
   * @param updateRequest update request
   * @return updated Customer
   */
  @ApiOperation("update customer")
  @PostMapping(Router.CUSTOMER_WITH_ID)
  public Customer updateCustomer(@PathVariable String id,
                                 @RequestBody UpdateRequest updateRequest) {
    LOG.info("enter: id: {}, UpdateRequest: {}", id, updateRequest);

    Customer entity = customerService.updateCustomer(id, updateRequest.getVersion(),
        updateRequest.getActions());

    CustomerView customer = CustomerMapper.entityToModel(entity);

    LOG.info(EXIT_LOG_INFO, customer);
    return null;
  }


}
