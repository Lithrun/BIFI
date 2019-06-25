package nl.hu.sie.bep.bifi.group2;

import nl.hu.sie.bep.bifi.group2.model.Company;
import nl.hu.sie.bep.bifi.group2.parser.FileParser;
import nl.hu.sie.bep.bifi.group2.persistence.mongo.MongoReader;
import nl.hu.sie.bep.bifi.group2.services.company.CompanyService;
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
        var companyService = new CompanyService();
        var companies = companyService.getCompanies(month);
        
        for (var company : companies)
        {
            var parser = new FileParser(company);
            var iefFile = parser.parse();

            LOGGER.info("== file ==");
            LOGGER.info(iefFile);

            System.out.println(iefFile);
        }
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
