package model;

import java.sql.Date;

public class InvoiceLine
{
	private String btwCode;
	private int productId;
	private String productName;
	private double quantity;
	private double totalPrice;
	private String unit;

	public String getBtwCode() {return btwCode;}

	public void setBtwCode(String newBtwCode) {btwCode = newBtwCode;}

	public int getProductId() {return productId;}

	public void setProductId(int newProductId) {productId = newProductId;}

	public String getProductName() {return productName;}

	public void setProductName(String newProductName) {productName = newProductName;}

	public double getQuantity()
	{
		return quantity;
	}

	public void setQuantity(double quantity)
	{
		this.quantity = quantity;
	}

	public double getTotalPrice() {return totalPrice;}

	public void setTotalPrice(double newTotalPrice) {totalPrice = newTotalPrice;}

	public String getUnit()
	{
		return unit;
	}

	public void setUnit(String unit)
	{
		this.unit = unit;
	}
}