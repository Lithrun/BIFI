package parser.parsers;

import model.Invoice;
import parser.FileBuilder;
import parser.IParser;
import parser.ParserUtils;

public class InvoiceParser extends ParserUtils implements IParser<Invoice> {

    @Override
    public void Parse(FileBuilder builder, Invoice model) {

        var items = new String[]
                {

                };
        builder.Add(items);
    }
}