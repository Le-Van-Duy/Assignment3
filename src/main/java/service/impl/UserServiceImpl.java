/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import com.nimbusds.jose.crypto.impl.AAD;
import hibernate.HibernateUtils;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.UserRepository;
import service.StudentServcice;
import service.UserService;

/**
 *
 * @author ADMIN KH
 */
public class UserServiceImpl implements UserService {

    private UserRepository userRepository = new UserRepository();

    @Override
    public String checkLogin(String taiKhoan, String matKhau) {
        for (User user : userRepository.getAll()) {
            if (taiKhoan.equalsIgnoreCase(user.getUserName()) && matKhau.equalsIgnoreCase(user.getPassWord())) {
                return user.getRole();
            }
        }
        return null;
    }

}
