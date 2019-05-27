package model;

public class Address
{
	private String street;
	private int streetNumber;
	private String postalCode;
	private String city;

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public int getStreetNumber()
	{
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber)
	{
		this.streetNumber = streetNumber;
	}

	public String getPostalCode()
	{
		return postalCode;
	}

	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}
}
