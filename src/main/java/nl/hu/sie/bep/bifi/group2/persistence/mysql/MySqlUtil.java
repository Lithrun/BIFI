package nl.hu.sie.bep.bifi.group2.persistence.mysql;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySqlUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration config = new Configuration();
                config.configure("mysql/hibernate.cfg.xml");
                sessionFactory = config.buildSessionFactory();
            } catch (Exception exception) {
                Logger logger = LoggerFactory.getLogger(MySqlUtil.class);
                logger.info("getSessionFactory - Exception");
                exception.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
