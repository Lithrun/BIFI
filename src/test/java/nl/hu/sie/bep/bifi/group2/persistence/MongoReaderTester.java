package nl.hu.sie.bep.bifi.group2.persistence;

import nl.hu.sie.bep.bifi.group2.persistence.mongo.MongoReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//TODO Niet op een live database testen!!!!!
public class MongoReaderTester {
    private MongoReader mongoReader;

    @BeforeEach
    public void setupMongoReader() {
        mongoReader = new MongoReader();
    }

    @Test
    public void testInvoiceLoader() {
        assertEquals(5, mongoReader.getAllInvoices().size());
    }
}
