class InvoiceLine
{
	private String description;
	private double quantity;
	private double priceExclVat;
	//1 = 0, 2 = laag, 3 = hoog
	private int vatType;
	private DateTime date;
	private String unit;

	private InvoiceLineInformation[] invoiceLineInformations;
	private TextLine textLine;



}