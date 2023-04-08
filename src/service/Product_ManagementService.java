/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.Date;
import model.Product_Management;

/**
 *
 * @author Hieucode
 */
public interface Product_ManagementService {
    public ArrayList<Product_Management> getAll();
    public String addNew(Product_Management pm);
    public String update(String idProduct, Product_Management pm);
    public ArrayList<Product_Management> getAllSort(String sort, String firstDay, String lastDay);
    public Product_Management getById(String ID_PRODUCT);
    public String  deleteProduct(String id_product);
    public String readFile();
}
