/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.Grade;
import model.Student;

/**
 *
 * @author ADMIN KH
 */
public interface GradeService {

    List<Grade> getAll();

    List<Grade> getAllTop3();

    String add(Grade grade);

    String delete(String maSV );

    String update(Grade grade);

    Grade findByID(int id);

    List<Grade> searchByMaSV(String maSV);

}
