package nl.hu.sie.bep.bifi.group2.persistence.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import nl.hu.sie.bep.bifi.group2.model.Invoice;
import nl.hu.sie.bep.bifi.group2.model.InvoiceLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MongoReader 
{
    private ArrayList<Invoice> invoices = new ArrayList<>();

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoReader.class);
    private final String connectionString = "mongodb+srv://Nynke:Tester123@clusterfriendspammer-fvgbf.mongodb.net/test?retryWrites=true&w=majority";

    public List<Invoice> getAllInvoices() 
    {
        var uri = new MongoClientURI(connectionString);
        var mongoClient = new MongoClient(uri);

        try 
        {
            var database = mongoClient.getDatabase("BiFiBEP02");
            var mongoCollection = database.getCollection("bifi");
            var documents = mongoCollection.find();
            return new ArrayList<>();

            //for (Document document : documents) 
            //{
            //    fillInvoice(document);
            //}

            //return invoices;
        }
        catch (MongoException mongoException) 
        {
            LOGGER.info("connectToDatabase", mongoException);
        }
        finally 
        {
            mongoClient.close();
        }

        return null;        

    }

    public MongoCollection<Document> connectToDatabase() 
    {
        MongoClientURI uri = new MongoClientURI(connectionString);
        MongoClient mongoClient = new MongoClient(uri);
        MongoCollection<Document> mongoCollection = null;
        MongoDatabase database;

        try (mongoClient)
        {
            database = mongoClient.getDatabase("BiFiBEP02");
            mongoCollection = database.getCollection("bifi");
        }
        catch (MongoException mongoException) 
        {
            LOGGER.info("connectToDatabase", mongoException);
        }
        finally 
        {
            mongoClient.close();
        }

        return mongoCollection;
    }

    public void fillInvoice(Document document) {
        Invoice invoice = new Invoice();
        invoice.setCustomerId(document.getInteger("customerId"));
        invoice.setDate(document.getDate("date"));
        invoice.setInvoiceId(document.getInteger("invoiceId"));
        invoice.setNote(document.getString("note"));
        invoice.setPersonId(document.getInteger("personId"));
        List<Document> invoiceLinesfromDb = (List<Document>) document.get("invoiceLines");
        for (Document line : invoiceLinesfromDb) {
            fillInvoiceLines(line, invoice);
        }
        invoices.add(invoice);
    }

    public void fillInvoiceLines(Document line, Invoice invoice) {
        InvoiceLine invoiceLine = new InvoiceLine();
        invoiceLine.setBtwCode(line.getString("btwCode"));
        invoiceLine.setProductId(line.getInteger("productId"));
        invoiceLine.setProductName(line.getString("productName"));
        invoiceLine.setQuantity(line.getInteger("quantity"));
        invoiceLine.setTotalPrice(line.getDouble("totalPrice"));
        invoiceLine.setUnit(line.getString("unit"));
        invoice.setInvoiceLine(invoiceLine);
    }
}
