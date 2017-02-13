package io.reactivesw.customer.info.infrastructure.repository;

import io.reactivesw.customer.info.domain.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by umasuo on 17/1/05.
 */
public interface AddressRepository extends JpaRepository<Address, String>,
    CrudRepository<Address, String> {

}
