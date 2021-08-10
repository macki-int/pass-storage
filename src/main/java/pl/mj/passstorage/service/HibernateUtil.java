package pl.mj.passstorage.service;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import pl.mj.passstorage.model.Password;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                System.out.println("start config");
                Configuration config = new Configuration();
                System.out.println("created config");

                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
//                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=ps;integratedSecurity=true");
//                settings.put(Environment.URL, "jdbc:postgresql://localhost:5433/ps");
                settings.put(Environment.USER, "passtorage");
                settings.put(Environment.PASS, "Inora1234");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "create-drop");

                config.setProperties(settings);
                config.addAnnotatedClass(Password.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

                sessionFactory = config.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                System.out.println("Wrapper exception: " + e);
                System.out.println("Underlying exception: " + e.getCause());
//                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
