package nl.hu.sie.bep.bifi.group2.persistence.jar;

import nl.hu.sie.bep.bifi.group2.model.Address;
import org.easymock.TestSubject;
import nl.hu.sie.bep.bifi.group2.persistence.jar.generic.MappingFactory;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class OldAddressMappingFactoryTest {
    @TestSubject
    private MappingFactory<Address> mappingFactory = new OldAddressMappingFactory();

    private Map<String, String> mapStub;

    @BeforeEach
    public void beforeEach() {
        mapStub = new HashMap<>();
    }

    @AfterEach
    public void afterEach() {
        mapStub = null;
    }

    @Test
    public void convertFromMapTest() {
        initializeAllFakeMapData();

        Address result = mappingFactory.convertFromMap(mapStub);

        assertEquals("Teststraat", result.getStreet());
        assertEquals("1", result.getStreetNumber());
        assertEquals("Testplaats", result.getCity());
        assertEquals("1234AB", result.getPostalCode());
    }

    @Test
    public void convertFromMapWithNullValues() {
        initializeAllFakeMapDataExceptPostalCode();

        Address result = mappingFactory.convertFromMap(mapStub);

        assertEquals("Teststraat", result.getStreet());
        assertEquals("1", result.getStreetNumber());
        assertEquals("Testplaats", result.getCity());
        assertEquals("", result.getPostalCode());
    }

    private void initializeAllFakeMapData() {
        initializeAllFakeMapDataExceptPostalCode();
        mapStub.put("POSTCODE", "1234AB");
    }

    private void initializeAllFakeMapDataExceptPostalCode() {
        mapStub.put("plaats", "Testplaats");
        mapStub.put("STRAAT", "Teststraat");
        mapStub.put("HUISNUMMER", "1");
    }
}
