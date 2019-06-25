package nl.hu.sie.bep.bifi.group2.model;

import nl.hu.sie.bep.bifi.group2.persistence.mysql.dao.CustomerDao;

public class Company
{
	private String name;
	private String vatNumber;
	private String iban;
	private String bic;
	private Address address;
	private Customer[] customers;
	
	public static Company fromCustomer(CustomerDao dao)
	{
		var company = new Company();
		company.setName(dao.getCompanyName());
		
		return company;
	}	

	public Customer[] getCustomers()
	{
		return customers;
	}

	public void setCustomers(Customer[] customers)
	{
		this.customers = customers;
	}

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	public String getBic()
	{
		return bic;
	}

	public void setBic(String bic)
	{
		this.bic = bic;
	}

	public String getIban()
	{
		return iban;
	}

	public void setIban(String iban)
	{
		this.iban = iban;
	}

	public String getVatNumber()
	{
		return vatNumber;
	}

	public void setVatNumber(String vatNumber)
	{
		this.vatNumber = vatNumber;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}