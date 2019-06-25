package nl.hu.sie.bep.bifi.group2.parser.parsers;

import nl.hu.sie.bep.bifi.group2.model.TextLine;
import nl.hu.sie.bep.bifi.group2.parser.FileBuilder;
import nl.hu.sie.bep.bifi.group2.parser.IParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextLineParserTests
{
    private IParser parser;
    
    @BeforeEach
    public void Before()
    {
        parser = new TextLineParser();
    }
    
    @Test
    public void InvoiceParserTestParse()
    {
        var model = new TextLine();
        model.setDescription("fsfds");
        
        var builder = new FileBuilder();
        parser.parse(builder, model);
        var result = builder.build();
        
        var expected = "T,fsfds";
        assertEquals(expected, result);
    }
}
