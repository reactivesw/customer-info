package io.reactivesw.customer.info.application.controller;

import io.reactivesw.customer.info.application.model.AddressView;
import io.reactivesw.customer.info.application.model.mapper.AddressMapper;
import io.reactivesw.customer.info.domain.model.Address;
import io.reactivesw.customer.info.domain.service.AddressService;
import io.reactivesw.customer.info.infrastructure.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by umasuo on 17/3/17.
 */
@RestController
public class AddressController {

  /**
   * logger.
   */
  private final static Logger logger = LoggerFactory.getLogger(AddressController.class);

  /**
   * address service.
   */
  @Autowired
  public transient AddressService addressService;

  @GetMapping(value = Router.ADDRESS_WITH_ID)
  public AddressView getById(@RequestParam @Valid @NotNull String id) {
    logger.info("Enter: id: {}", id);

    Address address = addressService.getById(id);

    AddressView addressView = AddressMapper.modelToView(address);

    logger.info("Exit: addressView: {}", addressView);
    return addressView;
  }

}
