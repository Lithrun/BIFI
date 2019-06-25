package nl.hu.sie.bep.bifi.group2.parser;

import nl.hu.sie.bep.bifi.group2.model.Company;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class FileParserTests
{
    private FileParser<Company> fileParser;
    
    @BeforeEach
    public void Before()
    {
        //reflection didn't catch inheritance
        var company = new TestCompany().GetCompany();
        fileParser = new FileParser<>(company);
    }
    
    @Test
    public void FileParserTestParseValid()
    {
        var result = fileParser.parse();
        
        var expected = "B,Company name,Street,21e,1234aa,Utrecht,02349385,INGB03NL0001234435,ING\n" +
                "K,A company,Dhr,Piet,van,Test persoon,Street,21,4321bb,Utrecht,jdfhkjgf,INGB03NL9874356iuh,lkfdg\n" +
                "R,,00000,00000,0,,\n" +
                "K,,,,,,,,,,,,";
                
        assertEquals(expected, result);
    }
    
    
}
