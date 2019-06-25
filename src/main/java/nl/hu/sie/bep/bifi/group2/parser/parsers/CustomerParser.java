package nl.hu.sie.bep.bifi.group2.parser.parsers;

import nl.hu.sie.bep.bifi.group2.model.Address;
import nl.hu.sie.bep.bifi.group2.model.Customer;
import nl.hu.sie.bep.bifi.group2.parser.IParser;
import nl.hu.sie.bep.bifi.group2.parser.FileBuilder;
import nl.hu.sie.bep.bifi.group2.parser.ParserUtils;

public class CustomerParser extends ParserUtils implements IParser<Customer>
{
    @Override
    public void parse(FileBuilder builder, Customer model)
    {
        var address = model.getAddress();
        if (address == null) { address = new Address(); }

        var items = new String[]
                {
                        "K",
                        shortenStringValue(40, model.getCompanyName()),
                        shortenStringValue(6, model.getSalutation()),
                        shortenStringValue(20, model.getName()),
                        shortenStringValue(7, model.getInsertion()),
                        shortenStringValue(40, model.getLastName()),

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
}
