package persistence;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import model.Invoice;
import model.InvoiceLine;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoReader {
    private ArrayList<Invoice> invoices = new ArrayList<Invoice>();

    public ArrayList<Invoice> getAllInvoices() {
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

        MongoDatabase database = mongoClient.getDatabase("BiFiBEP02");

        MongoCollection<Document> mongoCollection = database.getCollection("bifi");

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
//        invoiceLine.setTotalPrice(line.getInteger("totalPrice"));
        invoiceLine.setUnit(line.getString("unit"));
        invoice.setInvoiceLine(invoiceLine);
    }
}
