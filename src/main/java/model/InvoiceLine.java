package model;

import java.sql.Date;

public class InvoiceLine
{
	private String description;
	private double quantity;
	private double priceExclVat;
	//TODO maken vatType an enum with 0, high/hoog, low/laag
	private int vatType; // 1 = 0, 2 = laag, 3 = hoog
	private Date date;
	private String unit;
	private InvoiceLineInformation[] invoiceLineInformations;
	private TextLine textLine;

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public double getQuantity()
	{
		return quantity;
	}

	public void setQuantity(double quantity)
	{
		this.quantity = quantity;
	}

	public double getPriceExclVat()
	{
		return priceExclVat;
	}

	public void setPriceExclVat(double priceExclVat)
	{
		this.priceExclVat = priceExclVat;
	}

	public int getVatType()
	{
		return vatType;
	}

	public void setVatType(int vatType)
	{
		this.vatType = vatType;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public String getUnit()
	{
		return unit;
	}

	public void setUnit(String unit)
	{
		this.unit = unit;
	}

	public InvoiceLineInformation[] getInvoiceLineInformations()
	{
		return invoiceLineInformations;
	}

	public void setInvoiceLineInformations(InvoiceLineInformation[] invoiceLineInformations) { this.invoiceLineInformations = invoiceLineInformations; }

	public TextLine getTextLine()
	{
		return textLine;
	}

	public void setTextLine(TextLine textLine)
	{
		this.textLine = textLine;
	}
}