package io.reactivesw.customer.info.domain.service;

import io.reactivesw.customer.info.domain.model.Address;
import io.reactivesw.customer.info.infrastructure.repository.AddressRepository;
import io.reactivesw.exception.NotExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by umasuo on 17/2/13.
 */
@Service
public class AddressService {

  /**
   * logger.
   */
  private final static Logger LOG = LoggerFactory.getLogger(AddressService.class);

  /**
   * address repository.
   */
  @Autowired
  private transient AddressRepository addressRepository;

  /**
   * address repository.
   */
  @Autowired
  private transient CustomerService customerService;

  /**
   * get address by id.
   *
   * @param id String
   * @return AddressValue
   */
  public Address getById(String id) {
    LOG.debug("enter: id: {}", id);

    Address address = addressRepository.findOne(id);
    if (address == null) {
      throw new NotExistException("Address not exist for id: " + id);
    }

    LOG.debug("exit: address: {}", address);
    return address;
  }

}
