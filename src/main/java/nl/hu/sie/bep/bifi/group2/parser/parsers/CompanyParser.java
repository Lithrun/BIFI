package nl.hu.sie.bep.bifi.group2.parser.parsers;

import nl.hu.sie.bep.bifi.group2.model.Address;
import nl.hu.sie.bep.bifi.group2.model.Company;
import nl.hu.sie.bep.bifi.group2.parser.IParser;
import nl.hu.sie.bep.bifi.group2.parser.FileBuilder;
import nl.hu.sie.bep.bifi.group2.parser.ParserUtils;

/**
 * Parse the company
 * Their is no address parser because this will be in the company line
 */
public class CompanyParser extends ParserUtils implements IParser<Company>
{
    @Override
    public void parse(FileBuilder builder, Company model)
    {
        var address = GetAddress(model);
        
        var items = new String[]
        {
            "B",
            shortenStringValue(60, model.getName()),
                
            shortenStringValue(60, address.getStreet()),
            shortenStringValue(10, address.getStreetNumber()),
            shortenStringValue(6, address.getPostalCode()),
            shortenStringValue(20, address.getCity()),
                
            shortenStringValue(13, model.getVatNumber()),
            shortenStringValue(64, model.getIban()),
            shortenStringValue(10, model.getBic()),
        };
        
        builder.add(items);
    }
    
    private Address GetAddress(Company model)
    {
        var address = model.getAddress();
        if (address == null) { return new Address(); }
        
        return address;
    }
    
}
