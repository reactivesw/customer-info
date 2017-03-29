package io.reactivesw.customer.info.domain.service

import io.reactivesw.customer.info.domain.model.Address
import io.reactivesw.customer.info.domain.model.Customer
import io.reactivesw.customer.info.infrastructure.repository.AddressRepository
import io.reactivesw.exception.NotExistException
import spock.lang.Specification

class AddressServiceTest extends Specification {

    AddressRepository addressRepository = Mock(AddressRepository)

    CustomerService customerService = Mock(CustomerService)

    AddressService addressService = new AddressService(addressRepository: addressRepository, customerService: customerService)

    Address address = new Address(id: "addressId")


    Customer customer

    def setup() {
        List<Address> addresses = new ArrayList<>()
        addresses.add(address)
        customer = new Customer(id: "customerId", addresses: addresses)
    }

    def "Test 1.1: get address by id"() {
        when:
        addressRepository.findOne(_) >> address
        Address result = addressService.getById("addressId")
        then:
        noExceptionThrown()
        result.getId() == address.getId()
    }

    def "Test 1.2: get address by id that not exist"() {
        when:
        addressRepository.findOne(_) >> null
        addressService.getById("addressId")
        then:
        thrown(NotExistException)
    }

    def "Test 2.1: get addresses by customerId"() {
        when:
        customerService.getById("customerId") >> customer
        List<Customer> addresses = addressService.getAllAddressByCustomerId("customerId")
        then:
        noExceptionThrown()
        addresses.size() == 1
    }

    def "Test 2.2: get addresses by customerId that do not have any address"() {
        customer.setAddresses(null)
        when:
        customerService.getById("customerId") >> customer
        List<Customer> addresses = addressService.getAllAddressByCustomerId("customerId")
        then:
        noExceptionThrown()
        addresses.size() == 0
    }
}

