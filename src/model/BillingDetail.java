/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class BillingDetail {
    private int ordinal_numbers;
    private String id_product;
    private String name_product;
    private int quantity;
    private int unit_price;
    private int total;

    public BillingDetail(int ordinal_numbers, String id_product, String name_product, int quantity, int unit_price, int total) {
        this.ordinal_numbers = ordinal_numbers;
        this.id_product = id_product;
        this.name_product = name_product;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.total = total;
    }

    public BillingDetail(String id_product, String name_product, int quantity, int unit_price, int total) {
        this.id_product = id_product;
        this.name_product = name_product;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.total = total;
    }

    public BillingDetail(String id_product, String name_product) {
        this.id_product = id_product;
        this.name_product = name_product;
    }
    
    

    public BillingDetail() {
    }

    public int getOrdinal_numbers() {
        return ordinal_numbers;
    }

    public void setOrdinal_numbers(int ordinal_numbers) {
        this.ordinal_numbers = ordinal_numbers;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(int unit_price) {
        this.unit_price = unit_price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "BILLINGDETAIL{" + "ordinal_numbers=" + ordinal_numbers + ", id_product=" + id_product + ", name_product=" + name_product + ", quantity=" + quantity + ", unit_price=" + unit_price + ", total=" + total + '}';
    }
    
    
    
}
