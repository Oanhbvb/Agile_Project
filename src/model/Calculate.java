package model;

public class Calculate {
    private String id_product;
    private String name_product;
    private int quantity;
    private int unit_price;
    private int total;

    public Calculate() {
    }

    public Calculate(String id_product, String name_product, int quantity, int unit_price, int total) {
        this.id_product = id_product;
        this.name_product = name_product;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.total = total;
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

    
}
