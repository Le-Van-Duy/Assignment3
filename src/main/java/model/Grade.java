package model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "GRADE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Grade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

//    @Column(name = "maSV")
//    private String maSV;
    @Column(name = "diemTiengAnh")
    private int diemTiengAnh;

    @Column(name = "diemTinHoc")
    private int diemTinHoc;

    @Column(name = "diemGDTC")
    private int diemGDTC;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "maSV", referencedColumnName = "maSV")
    private Student students;

    public float diemTB() {
        return (diemTiengAnh + diemTinHoc + diemGDTC) / 3;
    }

    public Object[] toDataRow() {
        return new Object[]{students.getMaSV(), students.getHoTen(), diemTiengAnh, diemTinHoc, diemGDTC, diemTB()};
    }

}
