package nl.hu.sie.bep.bifi.group2.model;

import nl.hu.sie.bep.bifi.group2.persistence.mysql.dao.CustomerDao;
import nl.hu.sie.bep.bifi.group2.services.invoices.InvoiceService;

import java.util.ArrayList;
import java.util.List;

public class Customer
{
	private String companyName;
	private String salutation;
	private String name;
	private String insertion;
	private String lastName;
	private Address address;
	private String vatNumber;
	private String iban;
	private String bic;
    private int customerId;
    private Invoice[] invoices;
    private int personId;
    
    public static Customer fromCustomerDao(CustomerDao dao)
	{
		var customer = new Customer();
		customer.setCustomerId(dao.getId());
		customer.setCompanyName(dao.getCompanyName());
		customer.setSalutation(dao.getSalutation());
		
		var person = dao.getPerson();
		customer.setName(person.getFirstName());
		customer.setInsertion(person.getInsertion());
		customer.setLastName(person.getLastName());
		
		var address = new Address();
		var addressDao = dao.getAddresses().get(0);
		
		address.setStreet(addressDao.getStreet());
		address.setStreetNumber(addressDao.getStreetNumber());
		address.setPostalCode(addressDao.getZipCode());
		address.setCity(addressDao.getCity());
		
		customer.setAddress(address);
		
		return customer;
	}

	public String getCompanyName()
	{
		return companyName;
	}

	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}

	public String getSalutation()
	{
		return salutation;
	}

	public void setSalutation(String salutation)
	{
		this.salutation = salutation;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getInsertion()
	{
		return insertion;
	}

	public void setInsertion(String insertion)
	{
		this.insertion = insertion;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	public String getVatNumber()
	{
		return vatNumber;
	}

	public void setVatNumber(String vatNumber)
	{
		this.vatNumber = vatNumber;
	}

	public String getIban()
	{
		return iban;
	}

	public void setIban(String iban)
	{
		this.iban = iban;
	}

	public String getBic()
	{
		return bic;
	}

	public void setBic(String bic)
	{
		this.bic = bic;
	}

    public Invoice[] getInvoices() {
        return invoices;
    }

    public void setInvoices(Invoice[] invoices) {
        this.invoices = invoices;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}