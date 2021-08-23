package pl.mj.passstorage.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.mj.passstorage.model.Password;
import pl.mj.passstorage.service.HibernateUtil;

import java.util.List;

public class PasswordRepositoryImpl implements PasswordRepository{
    private static SessionFactory sessionFactory;
    private Transaction transaction;
    private Session session;

    public PasswordRepositoryImpl(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<Password> getAll() {
        session = sessionFactory.openSession();
        try {
            String stringHQL = "From Password";
            return session.createQuery(stringHQL).getResultList();
        }finally {
            session.close();
        }
    }

    @Override
    public void addPassword(Password password) {

    }

    @Override
    public void updatePassword(Password password) {

    }

    @Override
    public void deletePassword(Password password) {

    }
}
