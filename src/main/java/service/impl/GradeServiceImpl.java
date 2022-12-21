/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.List;
import model.Grade;
import repository.GradeRepository;
import service.GradeService;

/**
 *
 * @author ADMIN KH
 */
public class GradeServiceImpl implements GradeService {

    private GradeRepository gradeRepository = new GradeRepository();

    @Override
    public List<Grade> getAll() {
        return gradeRepository.getAll();
    }

    @Override
    public String add(Grade grade) {
        for (Grade grade1 : gradeRepository.getAll()) {
            if (grade1.getStudents().getMaSV().equals(grade.getStudents().getMaSV())) {
                return "Mã SV -- Này đã tồn tại !";
            }
        }
        if (gradeRepository.addGrade(grade)) {
            return "Add successful !";
        } else {
            return "Add fail !";
        }
    }

    @Override
    public String delete(String maSV) {
        if (gradeRepository.deleteGrade(maSV)) {
            return "Delete successful !";
        } else {
            return "Delete fail !";
        }
    }

    @Override
    public String update(Grade grade) {
        if (gradeRepository.updateGrade(grade)) {
            return "Update successful !";
        } else {
            return "Update fail !";
        }
    }

    @Override
    public Grade findByID(int id) {
        return gradeRepository.getGradeByID(id);
    }

    @Override
    public List<Grade> searchByMaSV(String maSV) {
        return gradeRepository.listSearch(maSV);
    }

    @Override
    public List<Grade> getAllTop3() {
        return gradeRepository.getAllTop3();
    }
    private int currentIndex;

    public void first() {
        if (currentIndex > 0) {
            currentIndex = 0;
        }
    }

    public void previous() {
        if (currentIndex > 0) {
            currentIndex--;
        }
    }

    public void next(List<Grade> list) {
        if (currentIndex < list.size() - 1) {
            currentIndex++;
        }
    }

    public void last(List<Grade> list) {
        currentIndex = list.size() - 1;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public String getCurrentIndexInfor(List<Grade> list) {

        return "Record " + (currentIndex + 1) + " of " + (list.size());
    }

    public void setCurrentIndex(List<Grade> list, Grade g) {
        currentIndex = list.indexOf(g);
    }

}
