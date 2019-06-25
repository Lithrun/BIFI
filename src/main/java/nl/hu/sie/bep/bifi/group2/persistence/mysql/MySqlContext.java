package nl.hu.sie.bep.bifi.group2.persistence.mysql;

import nl.hu.sie.bep.bifi.group2.model.Company;
import nl.hu.sie.bep.bifi.group2.model.Customer;
import nl.hu.sie.bep.bifi.group2.persistence.mysql.dao.CustomerDao;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import java.util.ArrayList;

public class MySqlContext
{
    private SessionFactory _sessionFactory;
    
    public MySqlContext()
    {
        _sessionFactory = MySqlUtil.createSessionFactory();
    }
    
    
    //Get all companies but only the names, because idk where to look for them
    public Company[] getCompanies()
    {
         var session = _sessionFactory.openSession();
        try
        {
            //idk man
            var query = "SELECT Bedrijfsnaam FROM Bifi.klant GROUP BY Bedrijfsnaam";
            var result = session.createNativeQuery(query, CustomerDao.class).getResultList();
            var items = new ArrayList<Company>();
            
            for (var customer : result)
            {
                items.add(Company.fromCustomer(customer));
            }
            
            return (Company[]) items.toArray();
            
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
    
    
    public Customer[] getCustomers(String companyName)
    {
        //should be company id but the database is bogus
         var session = _sessionFactory.openSession();
        try
        {
            //idk man
            var query = "SELECT * FROM Bifi.klant WHERE Bedrijfsnaam = ?name";
            var result = session.createNativeQuery(query, CustomerDao.class)
                    .setParameter("name", companyName)
                    .getResultList();
            var items = new ArrayList<Customer>();
            
            for (var customer : result)
            {
                items.add(Customer.fromCustomerDao(customer));
            }
            
            return (Customer[]) items.toArray();
            
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
