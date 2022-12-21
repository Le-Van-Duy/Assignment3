/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import hibernate.HibernateUtils;
import java.util.ArrayList;
import java.util.List;
import model.Grade;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author ADMIN KH
 */
public class GradeRepository {

    private SessionFactory sessionFactory = HibernateUtils.getSf();

    public List<Grade> getAll() {
        Transaction transaction = null;
        List<Grade> listGrade = null;

        try ( Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            listGrade = session.createQuery("from Grade").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listGrade;
    }

    public List<Grade> getAllTop3() {
        Transaction transaction = null;
        List<Grade> listGrade = null;
        try ( Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            listGrade = session.createQuery("from Grade r ORDER BY (r.diemTiengAnh + r.diemTinHoc +r.diemGDTC)/3 DESC").setMaxResults(3).list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listGrade;
    }

    public Grade getGradeByID(int id) {
        Transaction transaction = null;
        Grade grade = null;
        try ( Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            grade = session.get(Grade.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return grade;
    }

    public boolean addGrade(Grade grade) {

        Transaction transaction = null;
        try ( Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(grade);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return false;
    }

    public boolean deleteGrade(String maSV) {
        Transaction transaction = null;
        try ( Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Student student = (Student) session.get(Student.class, maSV);
            System.out.println("-----------+ : " + student);
            session.delete(student.getGrade());
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateGrade(Grade grade) {
        Transaction transaction = null;
        try ( Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(grade);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return false;
    }

    public List<Grade> listSearch(String maSV) {
        Transaction transaction = null;
        List<Grade> listSearch = new ArrayList<>();
        try ( Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            if (maSV == null) {
                maSV = "%";
            } else {
                maSV = "%" + maSV + "%";
            }
            Query q = session.createQuery("Select s.maSV,s.hoTen,g.diemTiengAnh,g.diemTinHoc,g.diemGDTC from Grade g JOIN Student s on g.students.maSV = s.maSV where s.maSV LIKE: searchByMaSV");
            q.setParameter("searchByMaSV", maSV);
            List<Object[]> objects = q.list();
            for (Object[] ob : objects) {
                Object[] aux = ob;
                Student student = new Student();
                student.setMaSV((String) aux[0]);
                student.setHoTen((String) aux[1]);
                Grade grade = new Grade();
                grade.setStudents(student);
                grade.setDiemTiengAnh((int) aux[2]);
                grade.setDiemTinHoc((int) aux[3]);
                grade.setDiemGDTC((int) aux[4]);
                listSearch.add(grade);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }
        return listSearch;
    }

}
