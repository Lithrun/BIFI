package nl.hu.sie.bep.bifi.group2.services;

import nl.hu.sie.bep.bifi.group2.services.customer.CustomerService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nl.hu.sie.bep.bifi.group2.persistence.mysql.dao.CustomerDao;

import java.util.ArrayList;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerServiceTests {

    private SessionFactory sessionFactory;
    private Session session;
    private Query<CustomerDao> query;

    @BeforeEach
    public void setUp() {
        sessionFactory = createMock(SessionFactory.class);
        session = createMock(Session.class);
        query = createMock(Query.class);
    }

    @Test
    public void getAll_ShouldReturnAllCustomers() {
        var service = new CustomerService();
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

        var customers = service.getAllCustomers();

        assertEquals(customers.size(), daos.size());

        verify(sessionFactory);
        verify(session);
        verify(query);
    }
}
