package services;

import model.Address;
import model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OldAddressesServiceTest {
    private OldAddressesService service;
    private Customer customer;
    private Address address;

    @BeforeEach
    void beforeEach() {
        this.service = new OldAddressesService();
        this.customer = new Customer();
        this.address = new Address();
    }

    @Test
    void getByCustomerWithOldAddressTest() {
        this.address.setStreet("-MOATA");
        customer.setAddress(this.address);
        assertEquals("Rotterdam", service.getByCustomer(customer).getCity());
    }

    @Test
    void getByCustomerWithoutOldAddressTest() {
        this.address.setStreet("Straatweg");
        this.address.setCity("Utrecht");
        customer.setAddress(this.address);
        assertEquals("Utrecht", service.getByCustomer(customer).getCity());
    }
}
