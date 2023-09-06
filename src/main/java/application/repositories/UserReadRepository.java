package application.repositories;

import application.entities.User;
import application.utils.HibernateUtil;

import org.hibernate.Session;

import java.util.*;

public class UserReadRepository {

    public List<User> readUsers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM User", User.class).list();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

}
