package parser.parsers;

import model.Address;
import model.Customer;
import parser.FileBuilder;
import parser.IParser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerParserTests
{
    private IParser _parser;
    
    @BeforeEach
    public void Before()
    {
        _parser = new CustomerParser();
    }
    
    @Test
    public void CustomerParserTestParse()
    {
        var customer = new Customer();
        customer.setCompanyName("company");
        customer.setSalutation("test");
        customer.setName("test name");
        customer.setInsertion("insert");
        customer.setLastName("harry");
        customer.setVatNumber("vat");
        customer.setIban("iban");
        customer.setBic("bic");

        var address = new Address();
        address.setStreet("street");
        address.setStreetNumber("21a");
        address.setPostalCode("1234aa");
        address.setCity("utrecht");
        
        customer.setAddress(address);
        
        var builder = new FileBuilder();
        _parser.Parse(builder, customer);
        var result = builder.Build();
        
        var expected = "K,company,test,test name,insert,harry,street,21a,1234aa,utrecht,vat,iban,bic";
        assertEquals(expected, result);
    }
    
    @Test
    public void CustomerParserTestParseInvalidAddress()
    {
        var customer = new Customer();
        customer.setCompanyName("company");
        customer.setSalutation("test");
        customer.setName("test name");
        customer.setInsertion("insert");
        customer.setLastName("harry");
        customer.setVatNumber("vat");
        customer.setIban("iban");
        customer.setBic("bic");

        var builder = new FileBuilder();
        _parser.Parse(builder, customer);
        var result = builder.Build();

        var expected = "K,company,test,test name,insert,harry,,,,,vat,iban,bic";
        assertEquals(expected, result);
    }
    
    @Test
    public void CustomerParserTestParseInvalidLength()
    {
        var customer = new Customer();
        customer.setCompanyName("012345678901234567890123456789012345678901234567890123456789!");
        customer.setSalutation("test");
        customer.setName("test name");
        customer.setInsertion("insert");
        customer.setLastName("harry");
        customer.setVatNumber("vat");
        customer.setIban("iban");
        customer.setBic("bic");

        var address = new Address();
        address.setStreet("street");
        address.setStreetNumber("21a");
        address.setPostalCode("1234aa");
        address.setCity("utrecht");
        
        customer.setAddress(address);
        
        var builder = new FileBuilder();
        _parser.Parse(builder, customer);
        var result = builder.Build();
        
        var expected = "K,0123456789012345678901234567890123456789,test,test name,insert,harry,street,21a,1234aa,utrecht,vat,iban,bic";
        assertEquals(expected, result);
    }
        
}
