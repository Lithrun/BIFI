package persistence;

import com.mongodb.client.MongoCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.text.Document;

import static org.junit.jupiter.api.Assertions.*;


public class MongoReaderTester {
    private MongoReader mongoReader;

    //TODO Mock document to give to testInvoiceFiller
    //TODO Mock document and Invoice to give to testInvoiceLineFiller

    @BeforeEach
    public void setupMongoReader() {
        mongoReader = new MongoReader();
    }

    @Test
    public void testMongoConnection() {
        assertEquals(mongoReader.connectToDatabase(), "test");
    }

    @Test
    public void testInvoiceFiller(){
        Document document = new Document();

        assertEquals(mongoReader.fillInvoice(document), "test");
    }

    @Test
    public void testInvoiceLineFiller() {
        assertEquals(mongoReader.fillInvoice(document, invoice), "test");
    }
}
