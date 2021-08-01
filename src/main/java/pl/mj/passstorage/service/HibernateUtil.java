package pl.mj.passstorage.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import pl.mj.passstorage.model.Password;


public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private ServiceRegistry serviceRegistry;


    public static Session openSession(){
        return sessionFactory.openSession();
    }
    private static Configuration getConfiguration(){
        Configuration confg = new Configuration();
        confg.addAnnotatedClass(Password.class);
        confg.setProperty("hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        confg.setProperty("hibernate.connection.url", "jdbc:sqlserver://localhost:1433;databaseName=ps");
        confg.setProperty("hibernate.connection.username", "");
        confg.setProperty("hibernate.connection.password", "");
        confg.setProperty("hibernate.show_sql", "true");
        confg.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
        confg.setProperty("hibernate.hbm2ddl.auto", "update");

        return confg;
    }
}
