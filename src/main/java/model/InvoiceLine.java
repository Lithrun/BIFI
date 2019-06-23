package model;

import java.sql.Date;

public class InvoiceLine
{
	private String btwCode;
	private int productId;
	private String productName;
	private int quantity;
	private int totalPrice;
	private String unit;

	public String getBtwCode() {return btwCode;}

	public void setBtwCode(String btwCode) { this.btwCode = btwCode;}

	public int getProductId() {return productId;}

	public void setProductId(int productId) {this.productId = productId;}

	public String getProductName() {return productName;}

	public void setProductName(String productName) {this.productName = productName;}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity) { this.quantity = quantity; }

	public int getTotalPrice() {return totalPrice;}

	public void setTotalPrice(int totalPrice) {this.totalPrice = totalPrice;}

	public String getUnit() { return unit; }

	public void setUnit(String unit) { this.unit = unit; }
}