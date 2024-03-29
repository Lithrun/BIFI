package nl.hu.sie.bep.bifi.group2.persistence.jar;

import nl.hu.sie.bep.bifi.group2.model.Address;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import nl.hu.sie.bep.bifi.group2.persistence.jar.generic.JarDataFactory;
import nl.hu.sie.bep.bifi.group2.persistence.jar.generic.MappingFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import static org.easymock.EasyMock.expect;

public class OldAddressJarDataFactoryTest extends EasyMockSupport {
    @TestSubject
    private JarDataFactory<Address> testSubject;

    @Mock(name = "mappingFactoryMock")
    private MappingFactory<Address> mappingFactoryMock;

    private static Address getAddressToPerformTheTestWith() {
        Address address = new Address();
        address.setStreet("Ajax");
        address.setStreetNumber("5");
        address.setCity("Rotterdam");
        address.setPostalCode("1901CD");
        return address;
    }

    @BeforeEach
    public void beforeEach() {
        mappingFactoryMock = mock(OldAddressMappingFactory.class);
        testSubject = new OldAddressJarDataFactory(mappingFactoryMock);
        testSubject.open();
    }

    @AfterEach
    public void afterEach() {
        testSubject.close();
        testSubject = null;
        mappingFactoryMock = null;
    }

    @Test
    public void getOldAddressTest() {
        Address address = getAddressToPerformTheTestWith();
        Map<String, String> mapStub = getDataReturnedFromJar(address);
        expect(mappingFactoryMock.convertFromMap(mapStub)).andReturn(address);
        replayAll();

        testSubject = new OldAddressJarDataFactory(mappingFactoryMock);
        assertNotNull(testSubject.get("-MOATA"));
        verifyAll();
    }

    @Test
    public void getDoesNotFindOldAddressTest() {
        assertNull(testSubject.get("MOATA")); // Note the missing preceding hyphen
    }

    private Map<String, String> getDataReturnedFromJar(Address address) {
        Map<String, String> mapStub = new HashMap<>();
        mapStub.put("STRAAT", address.getStreet());
        mapStub.put("HUISNUMMER", address.getStreetNumber());
        mapStub.put("POSTCODE", address.getPostalCode());
        mapStub.put("plaats", address.getCity());
        return mapStub;
    }
}
