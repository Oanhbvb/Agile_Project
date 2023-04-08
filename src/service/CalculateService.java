package service;

import java.util.ArrayList;
import model.Calculate;
import model.BillingDetail;
import repository.Product_ManagementRepository;

public interface CalculateService {
    public ArrayList<Calculate> getAll();
    public Calculate getById(String id_product);
    public String addNew(Calculate c);
    public String update(String id_product, Calculate c);
    public String delete(String id_product);
    public BillingDetail getMinTotal();
    public BillingDetail getMaxTotal();
    public String readFile();
    public String getTblQuantityAfterCalculates(String id);
    public String deleteCalculateTable();
    public ArrayList<BillingDetail> getAllModel();
    public String addNewModel(BillingDetail c);
    public String rollBack(String id);
    public String deleteBilling(String id_product);
}
