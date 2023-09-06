package application.repositories;

import application.entities.User;
import application.utils.Constants;
import application.utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

public class UserCreateRepository {

    public String createUser(User user) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            String hql = "INSERT INTO User (firstName, lastName, age, profession) " +
                    "VALUES (:firstName, :lastName, :age, :profession)";

            MutationQuery query = session.createMutationQuery(hql);
            query.setParameter("firstName", user.getFirstName());
            query.setParameter("lastName", user.getLastName());
            query.setParameter("age", user.getAge());
            query.setParameter("profession", user.getProfession());
            query.executeUpdate();

            transaction.commit();
            return Constants.DATA_INSERT_MSG;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return e.getMessage();
        }
    }

}
