package services;

import org.junit.Test;
import org.junit.Before;

import model.Address;
import model.Customer;

import static org.junit.Assert.assertEquals;

public class OldAddressesServiceTest {
    private OldAddressesService service;
    private Customer customer;
    private Address address;

    @Before
    public void beforeEach() {
        this.service = new OldAddressesService();
        this.customer = new Customer();
        this.address = new Address();
    }

    @Test
    public void getByCustomerWithOldAddressTest() {
        this.address.setStreet("-MOATA");
        customer.setAddress(this.address);
        assertEquals("Rotterdam", service.getByCustomer(customer).getCity());
    }

    @Test
    public void getByCustomerWithoutOldAddressTest() {
        this.address.setStreet("Straatweg");
        this.address.setCity("Utrecht");
        customer.setAddress(this.address);
        assertEquals("Utrecht", service.getByCustomer(customer).getCity());
    }
}
