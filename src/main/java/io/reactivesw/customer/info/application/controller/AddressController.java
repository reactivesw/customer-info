package io.reactivesw.customer.info.application.controller;

import io.reactivesw.customer.info.application.model.AddressView;
import io.reactivesw.customer.info.application.model.mapper.AddressMapper;
import io.reactivesw.customer.info.domain.model.Address;
import io.reactivesw.customer.info.domain.service.AddressService;
import io.reactivesw.customer.info.infrastructure.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * address controller.
 */
@RestController
@CrossOrigin
public class AddressController {

  /**
   * LOG.
   */
  private static final Logger LOG = LoggerFactory.getLogger(AddressController.class);

  /**
   * address service.
   */
  @Autowired
  public transient AddressService addressService;

  /**
   * get by id.
   *
   * @param addressId String
   * @return address view.
   */
  @GetMapping(value = Router.ADDRESS_WITH_ID)
  public AddressView getById(@PathVariable @Valid @NotNull String addressId) {
    LOG.info("enter. id: {}", addressId);

    Address address = addressService.getById(addressId);

    AddressView addressView = AddressMapper.toView(address);

    LOG.info("exit. addressView: {}", addressView);
    return addressView;
  }

}
