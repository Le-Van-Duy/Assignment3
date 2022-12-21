/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 *
 * @author ADMIN KH
 */
@Entity
@Table(name = "STUDENTS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student implements Serializable {

    @Id
//    @GeneratedValue
//    @NotEmpty
    @Column(name = "maSV")
    private String maSV;

//    @NotEmpty
//    @Size(min = 3, max = 20, message = "Name length must be b/w 3 and 20")
    @Column(name = "hoTen")
    private String hoTen;

//    @NotEmpty
//    @Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}",
//            message = "Please provide a valid email address")
    @Column(name = "email")
    private String email;

//    @Pattern(regexp = "^[0-9]{10,11}$", message = "Phone must be sequence of 10-11 digits")
    @Column(name = "sdt")
    private String sdt;

    @Column(name = "gioiTinh")
    private boolean gioiTinh;
//    @NotEmpty
    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "hinh")
    private String hinh;
    @OneToOne(mappedBy = "students")
    private Grade grade;

    public Object[] toDataRow() {
        return new Object[]{maSV, hoTen, email, sdt, gioiTinh == true ? "Nam" : "Nữ", diaChi, hinh};
    }

}
