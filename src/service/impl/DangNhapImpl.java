/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.io.FileWriter;
import javax.swing.JOptionPane;
import model.Customer;
import repository.DangNhapRepository;
import service.DangNhapService;

/**
 *
 * @author Hieucode
 */
public class DangNhapImpl implements DangNhapService {
    
    DangNhapRepository dangNhapRepository = new DangNhapRepository();
    
    @Override
    public Customer loginCustomer(String username, String password) {
        Customer cus = dangNhapRepository.loginCustomer(username, password);
        if (cus == null) {
            return null;
        }
        return cus;
    }

    @Override
    public Boolean writeFile(String username) {
        try {
                FileWriter fw = new FileWriter("username.txt");
                fw.write(username);
                fw.flush();
                fw.close();
                return true;
            } catch (Exception e) {
                return false;
            }
    }

    
}
