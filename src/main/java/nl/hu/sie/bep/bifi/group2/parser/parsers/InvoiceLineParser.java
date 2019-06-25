package nl.hu.sie.bep.bifi.group2.parser.parsers;

import nl.hu.sie.bep.bifi.group2.model.InvoiceLine;
import nl.hu.sie.bep.bifi.group2.parser.IParser;
import nl.hu.sie.bep.bifi.group2.parser.FileBuilder;
import nl.hu.sie.bep.bifi.group2.parser.ParserUtils;

public class InvoiceLineParser extends ParserUtils implements IParser<InvoiceLine>
{
    @Override
    public void parse(FileBuilder builder, InvoiceLine model)
    {
        var items = new String[]
        {
            "R",
            shortenStringValue(60, model.getProductName()),
            formatValue(3, 2, model.getQuantity()),
            formatValue(3, 2, model.getTotalPrice()),
            model.getBtwCode(),
            formatDate(model.getDate()),
            shortenStringValue(6, model.getUnit())
        };

        builder.add(items);
    }
}
