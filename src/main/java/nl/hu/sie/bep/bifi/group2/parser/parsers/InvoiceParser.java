package nl.hu.sie.bep.bifi.group2.parser.parsers;

import nl.hu.sie.bep.bifi.group2.model.Invoice;
import nl.hu.sie.bep.bifi.group2.parser.FileBuilder;
import nl.hu.sie.bep.bifi.group2.parser.IParser;
import nl.hu.sie.bep.bifi.group2.parser.ParserUtils;

public class InvoiceParser extends ParserUtils implements IParser<Invoice> {

    @Override
    public void parse(FileBuilder builder, Invoice model) {

        var items = new String[]
                {

                };
        builder.add(items);
    }
}
