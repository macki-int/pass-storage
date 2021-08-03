package pl.mj.passstorage.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import pl.mj.passstorage.model.Password;


public class HibernateUtil {
    private static SessionFactory sessionFactory;
//    private ServiceRegistry serviceRegistry;

    static {
        Configuration config = getConfiguration();
        sessionFactory = config.buildSessionFactory();
    }


    public static Session openSession(){
        return sessionFactory.openSession();
    }

    private static Configuration getConfiguration(){
        Configuration config = new Configuration();
        config.addAnnotatedClass(Password.class);
        config.setProperty("hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        config.setProperty("hibernate.connection.url", "jdbc:sqlserver://localhost:1433;databaseName=ps");
        config.setProperty("hibernate.connection.username", "passtorage");
        config.setProperty("hibernate.connection.password", "Inora1234");
        config.setProperty("hibernate.show_sql", "true");
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
        config.setProperty("hibernate.hbm2ddl.auto", "update");

        return config;
    }
}
