/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import model.Product_Management;
import repository.Product_ManagementRepository;
import service.Product_ManagementService;

/**
 *
 * @author Hieucode
 */
public class Product_ManagementImpl implements Product_ManagementService {

    private Product_ManagementRepository pmre = new Product_ManagementRepository();

    public Product_ManagementImpl() {
    }

    @Override
    public ArrayList<Product_Management> getAll() {
        return pmre.getAll();
    }

    @Override
    public String addNew(Product_Management pm) {
        if (pmre.addNew(pm)) {
            return "Thêm thành công!";
        } else {
            return "Thêm thất bại!";
        }
    }

    @Override
    public String update(String idProduct, Product_Management pm) {
        if (pmre.update(idProduct, pm)) {
            return "Sửa thành công!";
        } else {
            return "Sửa thất bại!";
        }
    }

    @Override
    public ArrayList<Product_Management> getAllSort(String sort, String firstDay, String lastDay) {
        return pmre.getAllSort(sort, firstDay, lastDay);
    }

    @Override
    public Product_Management getById(String ID_PRODUCT) {
        Product_Management pm = pmre.getById(ID_PRODUCT);

        if (pm == null) {
            return null;
        } else {
            return pm;
        }
    }

    @Override
    public String deleteProduct(String id_product) {
        if (pmre.getByIdCalculate(id_product) == null) {
            if (pmre.deleteBillingDetail(id_product)) {
                pmre.deleteProductManagement(id_product);
                return "Xóa thành công!";
            }
        } 
            pmre.deleteProductManagement(id_product);
            return "Xóa thành công!";
    }

    @Override
    public String readFile() {
        try {
            FileReader fr = new FileReader("username.txt");
            int c;
            String username = "";
            while ((c = fr.read()) != -1) {
                username += (char) c;
            }
            fr.close();
            return username;
        } catch (Exception e) {
            return null;
        }
    }

}
