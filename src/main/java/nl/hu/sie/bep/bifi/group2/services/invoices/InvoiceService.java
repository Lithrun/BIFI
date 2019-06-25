package nl.hu.sie.bep.bifi.group2.services.invoices;

import nl.hu.sie.bep.bifi.group2.model.Invoice;
import nl.hu.sie.bep.bifi.group2.persistence.mongo.MongoReader;

import java.util.ArrayList;

public class InvoiceService
{
    private MongoReader mongoDb;
    
    public InvoiceService()
    {
        mongoDb = new MongoReader();
    }
    
    public Invoice[] getInvoiceForCustomerByMonth(int customerId, int month)
    {
        var invoices = mongoDb.getAllInvoices();

        var values = new ArrayList<Invoice>();
        for (var invoice : invoices)
        {
            if (invoice.getCustomerId() != customerId)
            {
                continue;
            }

            if (invoice.getDate().getMonth() != month)
            {
                continue;
            }

            values.add(invoice);
        }
        
        return (Invoice[]) values.toArray();
    }
}
