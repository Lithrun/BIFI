package parser.parsers;

import model.Address;
import model.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parser.FileBuilder;
import parser.IParser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompanyParserTests
{
    private IParser parser;

    @BeforeEach
    public void Before()
    {
        parser = new CompanyParser();
    }
        
    @Test
    public void CompanyParserTestParse()
    {
        var company = new Company();
        company.setName("01234567890123456789");
        company.setVatNumber("123");
        company.setIban("456");
        company.setBic("789");
        
        var address = new Address();
        address.setStreet("street");
        address.setStreetNumber("21a");
        address.setPostalCode("1234aa");
        address.setCity("utrecht");
        
        company.setAddress(address);
        
        var builder = new FileBuilder();
        parser.parse(builder, company);
        
        var result = builder.build();
        
        var expected = "B,01234567890123456789,street,21a,1234aa,utrecht,123,456,789";
        assertEquals(expected, result);
    }
    
    @Test
    public void CompanyParserTestParseInvalidAddress()
    {
        var company = new Company();
        company.setName("01234567890123456789");
        company.setVatNumber("123");
        company.setIban("456");
        company.setBic("789");

        var builder = new FileBuilder();
        parser.parse(builder, company);

        var result = builder.build();

        var expected = "B,01234567890123456789,,,,,123,456,789";
        assertEquals(expected, result);
    }
    
    @Test
    public void CompanyParserTestParseInvalidLength()
    {
        var company = new Company();
        company.setName("012345678901234567890123456789012345678901234567890123456789!");
        company.setVatNumber("123");
        company.setIban("456");
        company.setBic("789");

        var address = new Address();
        address.setStreet("street");
        address.setStreetNumber("21a");
        address.setPostalCode("1234aa");
        address.setCity("utrecht");

        company.setAddress(address);

        var builder = new FileBuilder();
        parser.parse(builder, company);

        var result = builder.build();

        var expected = "B,012345678901234567890123456789012345678901234567890123456789,street,21a,1234aa,utrecht,123,456,789";
        assertEquals(expected, result);
    }
}
