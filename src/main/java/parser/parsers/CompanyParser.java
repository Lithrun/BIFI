package parser.parsers;

import model.Address;
import model.Company;
import parser.FileBuilder;
import parser.IParser;
import parser.ParserUtils;

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
