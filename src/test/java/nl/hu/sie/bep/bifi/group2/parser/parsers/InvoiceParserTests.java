package nl.hu.sie.bep.bifi.group2.parser.parsers;

import nl.hu.sie.bep.bifi.group2.model.Invoice;
import nl.hu.sie.bep.bifi.group2.model.InvoiceLine;
import nl.hu.sie.bep.bifi.group2.parser.FileBuilder;
import nl.hu.sie.bep.bifi.group2.parser.IParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceParserTests
{
    private IParser parser;
    
    @BeforeEach
    public void Before()
    {
        parser = new InvoiceParser();
    }
    
    @Test
    public void InvoiceParserTestParse()
    {
        var model = new Invoice();
        model.setCustomerId(1);
        model.setDate(new Date(2018, 01, 01));
        model.setNote("sdfsdf");
        model.setType("type");
        model.setInvoiceId(1);
        model.setPersonId(1);
        
        var builder = new FileBuilder();
        parser.parse(builder, model);
        var result = builder.build();
        
        var expected = "F,t,010218,";
        assertEquals(expected, result);
    }
}
