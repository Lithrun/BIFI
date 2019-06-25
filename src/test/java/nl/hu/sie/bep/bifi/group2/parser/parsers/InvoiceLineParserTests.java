package nl.hu.sie.bep.bifi.group2.parser.parsers;

import nl.hu.sie.bep.bifi.group2.model.InvoiceLine;
import nl.hu.sie.bep.bifi.group2.parser.FileBuilder;
import nl.hu.sie.bep.bifi.group2.parser.IParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceLineParserTests
{
    private IParser parser;
    
    @BeforeEach
    public void Before()
    {
        parser = new InvoiceLineParser();
    }
    
    @Test
    public void InvoiceLineParserTestParse()
    {
        var invoiceLine = new InvoiceLine();
        invoiceLine.setBtwCode("123");
        invoiceLine.setProductName("sdlkfsl");
        invoiceLine.setProductId(1);
        invoiceLine.setQuantity(1);
        invoiceLine.setUnit("1");
        invoiceLine.setTotalPrice(12);
        
        var builder = new FileBuilder();
        parser.parse(builder, invoiceLine);
        var result = builder.build();
        
        var expected = "R,sdlkfsl,00100,01200,123,,1";
        assertEquals(expected, result);
    }
}
