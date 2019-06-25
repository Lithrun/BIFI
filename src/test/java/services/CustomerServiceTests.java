package services;

import org.easymock.EasyMockRunner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import persistence.mysql.dao.CustomerDao;

import java.util.ArrayList;

import static org.easymock.EasyMock.*;

@RunWith(EasyMockRunner.class)
public class CustomerServiceTests {

    private SessionFactory sessionFactory;
    private Session session;
    private Query<CustomerDao> query;
    @Before
    public void setUp() {
        sessionFactory = createMock(SessionFactory.class);
        session = createMock(Session.class);
        query = createMock(Query.class);
    }

    @Test
    public void getAll_ShouldReturnAllCustomers() {
        var service = new CustomerService(sessionFactory);
        var daos = new ArrayList<CustomerDao>() {{
            new CustomerDao();
            new CustomerDao();
            new CustomerDao();
            new CustomerDao();
            new CustomerDao();
        }};

        expect(sessionFactory.openSession()).andReturn(session);
        expect(session.createQuery("from CustomerDao ", CustomerDao.class)).andReturn(query);
        expect(query.list()).andReturn(daos);

        session.close();

        replay(sessionFactory);
        replay(session);
        replay(query);

        var customers = service.getAll();

        Assert.assertEquals(customers.size(), daos.size());

        verify(sessionFactory);
        verify(session);
        verify(query);
    }

}
