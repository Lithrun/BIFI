package nl.hu.sie.bep.bifi.group2.persistence;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import nl.hu.sie.bep.bifi.group2.model.Invoice;
import nl.hu.sie.bep.bifi.group2.model.InvoiceLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MongoReader {
    private ArrayList<Invoice> invoices = new ArrayList<>();

    public List<Invoice> getAllInvoices() {
        MongoCollection<Document> mongoCollection = connectToDatabase();

        FindIterable<Document> documents = mongoCollection.find();

        for (Document document : documents) {
            fillInvoice(document);
        }

        return invoices;
    }

    public MongoCollection<Document> connectToDatabase() {
        MongoClientURI uri = new MongoClientURI("mongodb+srv://Nynke:Tester123@clusterfriendspammer-fvgbf.mongodb.net/test?retryWrites=true&w=majority");
        MongoClient mongoClient = new MongoClient(uri);
        MongoCollection<Document> mongoCollection = null;
        MongoDatabase database;

        try (mongoClient){
            database = mongoClient.getDatabase("BiFiBEP02");
            mongoCollection = database.getCollection("bifi");
        }
        catch (MongoException mongoException) {
            Logger logger = LoggerFactory.getLogger(MongoReader.class);
            logger.info("connectToDatabase - MongoException");
            mongoException.printStackTrace();
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
// TODO: fix        invoiceLine.setTotalPrice(line.getInteger("totalPrice"));
        invoiceLine.setUnit(line.getString("unit"));
        invoice.setInvoiceLine(invoiceLine);
    }
}
