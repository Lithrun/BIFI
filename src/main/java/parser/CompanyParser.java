package parser;

import model.Address;
import model.Company;

public class CompanyParser extends ParserUtils implements IParser<Company>
{
    @Override
    public void Parse(LineBuilder builder, Company model)
    {
        var address = model.getAddress();
        if (address == null)
        {
            address = new Address();
        }
        
        var items = new String[]
        {
            "B",
            Shorten(60, model.getName()),                
                
            Shorten(60, address.getStreet()),
            Shorten(10, address.getStreetNumber()),
            Shorten(6, address.getPostalCode()),
            Shorten(20, address.getCity()),
                
            Shorten(13, model.getVatNumber()),
            Shorten(64, model.getIban()),
            Shorten(10, model.getBic()),
        };
        
        builder.AddRange(items);
    }
    
}
