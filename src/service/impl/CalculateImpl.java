package service.impl;

import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Calculate;
import model.BillingDetail;
import repository.CalculateRepository;
import repository.Product_ManagementRepository;
import service.CalculateService;

public class CalculateImpl implements CalculateService {

    private CalculateRepository cr = new CalculateRepository();

    @Override
    public ArrayList<Calculate> getAll() {
        return cr.getAll();
    }

    @Override
    public Calculate getById(String id_product) {
        Calculate c = cr.getById(id_product);
        if (c == null) {
            return null;
        } else {
            return c;
        }
    }

    @Override
    public String addNew(Calculate c) {
        if (cr.addNew(c)) {
            return "Thêm thành công!";
        } else {
            return "Thêm thất bại!";
        }
    }

    @Override
    public String update(String id_product, Calculate c) {
        Calculate c1 = cr.getById(id_product);

        if (c1 == null) {
            return "Sửa thất bại!";
        } else {
            cr.update(id_product, c);
            return "Sửa thành công!";
        }
    }

    @Override
    public String delete(String id_product) {
        if (cr.delete(id_product)){
            return "Xóa thành công";
        }else{
            return "Xóa thất bại";
        }
    }

    @Override
    public BillingDetail getMinTotal() {
        return cr.getMinTotal();
    }

    @Override
    public BillingDetail getMaxTotal() {
        return cr.getMaxTotal();
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

    @Override
    public String getTblQuantityAfterCalculates(String id) {
        if (cr.getTblQuantityAfterCalculates(id)) {
            return " Cập nhật số lượng, doanh thu thành công";
        } else {
            return " Cập nhật số lượng, doanh thu thất bại";
        }
    }

    @Override
    public String deleteCalculateTable() {

        if (cr.deleteCalculate()) {
            return "Clear table ok"; 
        }else{
            return "Clear fail";}
    }

    @Override
    public ArrayList<BillingDetail> getAllModel() {
        return cr.getAllModel();
    }

    @Override
    public String addNewModel(BillingDetail c) {
        if(cr.addNewModel(c)){
            return "Add model success";
        }
        return "Add model fail";
    }

    @Override
    public String rollBack(String id) {
        if (cr.rollBack(id)) {
            return " Cập nhật số lượng, doanh thu thành công";
        } else {
            return " Cập nhật số lượng, doanh thu thất bại";
        }
    }

    @Override
    public String deleteBilling(String id_product) {
        if (cr.deleteBillingDetail(id_product)){
            return "Xóa thành công Billing";
        }else{
            return "Xóa thất bại Billing";
        }
    }

}
