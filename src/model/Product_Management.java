package model;

import java.util.Date;

public class Product_Management {

    private String id_product;
    private String name_product;
    private int unit_size;
    private int quantity;
    private int reveneu;
    private Date date_pro;
    
    

    public Product_Management() {
        
    }

    public Product_Management( String id_product, String name_product, int unit_size, int quantity, int reveneu, Date date_pro) {
        this.id_product = id_product;
        this.name_product = name_product;
        this.unit_size = unit_size;
        this.quantity = quantity;
        this.reveneu = reveneu;
        this.date_pro = date_pro;
    }

    public Product_Management(String id_product, String name_product, int unit_size, int quantity, int reveneu) {
        this.id_product = id_product;
        this.name_product = name_product;
        this.unit_size = unit_size;
        this.quantity = quantity;
        this.reveneu = reveneu;
    }

 

    public String getId_product() {
        return id_product;
    }

    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public int getUnit_size() {
        return unit_size;
    }

    public void setUnit_size(int unit_size) {
        this.unit_size = unit_size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getReveneu() {
        return reveneu;
    }

    public void setReveneu(int reveneu) {
        this.reveneu = reveneu;
    }

    public Date getDate_pro() {
        return date_pro;
    }

    public void setDate_pro(Date date_pro) {
        this.date_pro = date_pro;
    }

    @Override
    public String toString() {
        return "Product_Management{" + "id_product=" + id_product + ", name_product=" + name_product + ", unit_size=" + unit_size + ", quantity=" + quantity + ", reveneu=" + reveneu + ", date_pro=" + date_pro + '}';
    }

    
    
}
    
    
    
