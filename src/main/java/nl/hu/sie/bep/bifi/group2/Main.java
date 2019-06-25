package nl.hu.sie.bep.bifi.group2;

import nl.hu.sie.bep.bifi.group2.model.Company;
import nl.hu.sie.bep.bifi.group2.parser.FileParser;
import nl.hu.sie.bep.bifi.group2.persistence.mongo.MongoReader;
import nl.hu.sie.bep.bifi.group2.persistence.mysql.MySqlContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main
{
    private final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    
    private int month;

    public static void main (String[] args)
    {
        var main = new Main(args);
        main.parse();

    }
    
    public Main(String[] args)
    {
        if (args.length != 1)
        {
            throw new IllegalArgumentException("No valid month has been given");
        }
        
        var value = tryParseInt(args[0]);
        if (value == null || value < 1 || value > 12)
        {
            throw new IllegalArgumentException("Invalid month");
        }
    }
    
    private void parse()
    {
        var companies = getCompanies();
        for (var company : companies)
        {
            var parser = new FileParser(company);
            var iefFile = parser.parse();

            LOGGER.info("== file ==");
            LOGGER.info(iefFile);

            System.out.println(iefFile);
        }
    }
    
    private Company[] getCompanies()
    {
        var mongoDb = new MongoReader();
        var invoices = mongoDb.getAllInvoices();
        
        var context = new MySqlContext();
        var companies = context.getCompanies();
        
        for (var company : companies)
        {
            var customers = context.getCustomers(company.getName());

            for (var customer : customers)
            {
                for (var invoice : invoices)
                {
                    if (invoice.getCustomerId() != customer.getCustomerId())
                    {
                        continue;
                    }
                    
                    if (invoice.getDate().getMonth() != month)
                    {
                        continue;
                    }
                    
                    customer.addInvoices(invoice);
                }
            }
            
            company.setCustomers(customers);
        }
        
        return companies;
    }
    
    private Integer tryParseInt(String value)
    {
        try
        {
            return Integer.parseInt(value);
        }
        catch (NumberFormatException e)
        {
            return null;
        }
    }

}
