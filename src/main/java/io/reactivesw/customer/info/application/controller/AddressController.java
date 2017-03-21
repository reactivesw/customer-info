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
import org.springframework.web.bind.annotation.PathVariable;
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
   * LOGGER.
   */
  private final static Logger LOGGER = LoggerFactory.getLogger(AddressController.class);

  /**
   * address service.
   */
  @Autowired
  public transient AddressService addressService;

  @GetMapping(value = Router.ADDRESS_WITH_ID)
  public AddressView getById(@PathVariable @Valid @NotNull String addressId) {
    LOGGER.info("Enter: id: {}", addressId);

    Address address = addressService.getById(addressId);

    AddressView addressView = AddressMapper.modelToView(address);

    LOGGER.info("Exit: addressView: {}", addressView);
    return addressView;
  }

}
