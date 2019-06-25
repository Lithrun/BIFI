package nl.hu.sie.bep.bifi.group2.parser.parsers;

import nl.hu.sie.bep.bifi.group2.model.InvoiceLineInformation;
import nl.hu.sie.bep.bifi.group2.parser.IParser;
import nl.hu.sie.bep.bifi.group2.parser.FileBuilder;
import nl.hu.sie.bep.bifi.group2.parser.ParserUtils;

public class InvoiceInformationLineParser extends ParserUtils implements IParser<InvoiceLineInformation>
{
    @Override
    public void parse(FileBuilder builder, InvoiceLineInformation model)
    {
        var items = new String[]
        {
            "F", // to pay respect
                formatDate(model.getDate()),
                shortenStringValue(10, model.getInvoiceNumber())
        };

        builder.add(items);
    }
}
