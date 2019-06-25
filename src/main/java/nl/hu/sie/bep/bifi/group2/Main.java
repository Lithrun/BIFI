package nl.hu.sie.bep.bifi.group2;

import nl.hu.sie.bep.bifi.group2.model.Address;
import nl.hu.sie.bep.bifi.group2.model.Company;
import nl.hu.sie.bep.bifi.group2.model.Customer;
import nl.hu.sie.bep.bifi.group2.model.InvoiceLine;
import nl.hu.sie.bep.bifi.group2.parser.FileParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main (String[] args)
    {
        var main = new Main();
        var model = main.getCompany();

        //parse
        var parser = new FileParser(model);
        var iefFile = parser.parse();

        LOGGER.info("== file ==");
        LOGGER.info(iefFile);
    }

    private Main()
    {
        //ignore
    }

    public Company getCompany()
    {
        var companyAddress = new Address();
        companyAddress.setCity("Utrecht");
        companyAddress.setPostalCode("1234aa");
        companyAddress.setStreet("Street");
        companyAddress.setStreetNumber("21e");

        var company = new Company();
        company.setAddress(companyAddress);
        company.setName("Company name");
        company.setVatNumber("02349385");
        company.setIban("INGB03NL0001234435");
        company.setBic("ING");

        var customers = getCustomers();
        company.setCustomers(customers);

        return company;
    }

    private Customer[] getCustomers()
    {
        var customer1Address = new Address();
        customer1Address.setCity("Utrecht");
        customer1Address.setPostalCode("4321bb");
        customer1Address.setStreet("Street");
        customer1Address.setStreetNumber("21");

        var customer1 = new Customer();
        customer1.setCompanyName("A company");
        customer1.setSalutation("Dhr");
        customer1.setName("Piet");
        customer1.setInsertion("van");
        customer1.setLastName("Test persoon");
        customer1.setAddress(customer1Address);
        customer1.setVatNumber("jdfhkjgf");
        customer1.setIban("INGB03NL9874356iuh");
        customer1.setBic("lkfdg");

        var customer2 = new Customer();

        return new Customer[]
                {
                        customer1,
                        customer2
                };
    }

}
