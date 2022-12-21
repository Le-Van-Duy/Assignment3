/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import hibernate.HibernateUtils;
import java.util.List;
import javax.persistence.Query;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ADMIN KH
 */
public class StudentRepository {

    private SessionFactory sessionFactory = HibernateUtils.getSf();

    public List<Student> getAll() {
        Transaction transaction = null;
        List<Student> listStudent = null;

        try ( Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            listStudent = session.createQuery("from Student").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }
        return listStudent;
    }

    public Student getStudentByMaSV(String maSV) {
        Transaction transaction = null;
        Student student = null;
        try ( Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            student = session.get(Student.class, maSV);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return student;
    }

    public boolean addStudent(Student student) {

        Transaction transaction = null;
        try ( Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return false;
    }

    public boolean deleteStudent(String maSV) {
        Transaction transaction = null;
        try ( Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, maSV);
            session.delete(student);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return false;
    }

    public boolean updateStudent(Student student) {
        Transaction transaction = null;
        try ( Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return false;
    }

}
