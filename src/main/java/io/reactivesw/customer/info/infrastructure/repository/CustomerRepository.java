package io.reactivesw.customer.info.infrastructure.repository;

import io.reactivesw.customer.info.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by umasuo on 16/12/26.
 */
public interface CustomerRepository extends JpaRepository<Customer, String>,
    CrudRepository<Customer, String> {

}
