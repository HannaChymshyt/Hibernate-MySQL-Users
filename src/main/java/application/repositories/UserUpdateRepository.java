package application.repositories;

import application.entities.User;
import application.utils.Constants;
import application.utils.HibernateUtil;
import application.utils.IdChecker;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

public class UserUpdateRepository {

    public String updateUser(User user) {

        if (IdChecker.isIdExists(user)) {
            return updateUserById(user);
        } else {
            return Constants.ID_NO_EXISTS_MSG;
        }

    }

    private String updateUserById(User user) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            String hql = "UPDATE User SET profession = :profession WHERE id = :id";
            MutationQuery query = session.createMutationQuery(hql);
            query.setParameter("profession", user.getProfession());
            query.setParameter("id", user.getId());
            query.executeUpdate();

            transaction.commit();

            return Constants.DATA_UPDATE_MSG;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return e.getMessage();
        }
    }

}
