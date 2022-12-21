/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import com.nimbusds.jose.crypto.impl.AAD;
import java.util.List;
import model.Student;
import repository.StudentRepository;
import service.StudentServcice;

/**
 *
 * @author ADMIN KH
 */
public class StudentServiceImpl implements StudentServcice {

    private StudentRepository studentRepository = new StudentRepository();

    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public String add(Student student) {
        for (Student sv : studentRepository.getAll()) {
            if (student.getMaSV().equalsIgnoreCase(sv.getMaSV())) {
                return "This student ID already exists !";
            }
        }
        if (studentRepository.addStudent(student)) {
            return "Add successful !";
        } else {
            return "Add fail !";
        }
    }

    @Override
    public String delete(String maSV) {
        if (studentRepository.deleteStudent(maSV)) {
            return "Delete successful !";
        } else {
            return "Delete fail !";
        }
    }

    @Override
    public String update(Student student) {
        if (studentRepository.updateStudent(student)) {
            return "Update successful !";
        } else {
            return "Update fail !";
        }
    }

    @Override
    public Student findByMaSV(String maSV) {
        return studentRepository.getStudentByMaSV(maSV);
    }

}
