package nl.hu.sie.bep.bifi.group2.services.customer;

import nl.hu.sie.bep.bifi.group2.model.Address;
import nl.hu.sie.bep.bifi.group2.model.Customer;
import nl.hu.sie.bep.bifi.group2.persistence.mysql.MySqlUtil;
import nl.hu.sie.bep.bifi.group2.persistence.mysql.dao.CustomerDao;
import nl.hu.sie.bep.bifi.group2.services.address.IOldAddressesService;
import nl.hu.sie.bep.bifi.group2.services.address.OldAddressesService;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerService
{
    private SessionFactory _sessionFactory;
    private IOldAddressesService _addressService;
    
    public CustomerService()
    {
        _sessionFactory = MySqlUtil.createSessionFactory();
        _addressService = new OldAddressesService();
    }
    
    public List<Customer> getCustomersByCompany(String companyName)
    {
        var value = getAllCustomers().stream().filter(x -> x.getCompanyName().equals(companyName));
        return value.collect(Collectors.toList());
    }
    
    public List<Customer> getAllCustomers()
    {
        var session = _sessionFactory.openSession();

        try
        {
            var customerDaos = session.createQuery("from CustomerDao ", CustomerDao.class).list();
            var customers = new ArrayList<Customer>();
            for (var customerDao : customerDaos)
            {
                var mapper = MappingUtil.getMapper();
                var customer = mapper.map(customerDao, Customer.class);

                customer.setName(customerDao.getPerson().getFirstName());
                customer.setInsertion(customerDao.getPerson().getInsertion());
                customer.setLastName(customerDao.getPerson().getLastName());
                
                //TODO support multi address
                
                var address = customerDao.getAddresses().get(0);
                var addressMapping = mapper.map(address, Address.class);
                
                customer.setAddress(_addressService.getByCustomer(addressMapping));
                
                customers.add(customer);
            }
            
            return customers;
        }
        catch (HibernateException ex)
        {
            return null;
        }
        finally
        {
            session.close();
        }

    }
}
