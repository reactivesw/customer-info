package io.reactivesw.customer.info.domain.service

import io.reactivesw.customer.info.domain.model.Address
import io.reactivesw.customer.info.domain.model.Customer
import io.reactivesw.customer.info.infrastructure.repository.CustomerRepository
import io.reactivesw.customer.info.infrastructure.update.UpdateAction
import io.reactivesw.customer.info.infrastructure.update.UpdaterService
import io.reactivesw.exception.NotExistException
import spock.lang.Specification

class CustomerServiceTest extends Specification {

    CustomerRepository customerRepository = Mock(CustomerRepository)

    UpdaterService updateService = Mock(UpdaterService)

    CustomerService customerService

    Address address = new Address(id: "addressId")
    Customer customer

    def setup() {
        customerService = new CustomerService(customerRepository: customerRepository, updateService: updateService)

        List<Address> addresses = new ArrayList<>()
        addresses.add(address)
        customer = new Customer(id: "customerId", version: 0, addresses: addresses)
    }

    def "Test 1.1: get by id"() {

        when:
        customerRepository.findOne("customerId") >> customer
        Customer result = customerService.getById("customerId")
        then:
        result.getId() == customer.getId()
    }

    def "Test 1.2: get by id that not exist"() {

        when:
        customerRepository.findOne("customerId") >> null
        customerService.getById("customerId")
        then:
        thrown(NotExistException)
    }

    def "Test 2.1: update customer "() {
        when:
        customerRepository.findOne("customerId") >> customer
        customerRepository.save(_) >> customer
        Customer result = customerService.updateCustomer("customerId", 0, new ArrayList<UpdateAction>())
        then:
        noExceptionThrown()
        result.getId() == customer.getId()
    }

    def "Test 2.2: update customer that not exist "() {
        when:
        customerRepository.findOne("customerId") >> null
        customerRepository.save(_) >> customer
        Customer result = customerService.updateCustomer("customerId", 0, new ArrayList<UpdateAction>())
        then:
        noExceptionThrown()
        result.getId() == customer.getId()
    }

}
