/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import hibernate.HibernateUtils;
import java.util.List;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ADMIN KH
 */
public class UserRepository {

    private SessionFactory sessionFactory;

    public List<User> getAll() {
        sessionFactory = HibernateUtils.getSf();
        Transaction transaction = null;
        List<User> listUser = null;
        try ( Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            listUser = session.createQuery("from User").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listUser;
    }

}
