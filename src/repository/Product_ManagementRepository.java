package repository;

import java.util.ArrayList;
import model.Product_Management;
import java.util.Date;
import java.sql.*;
import model.Calculate;

public class Product_ManagementRepository {

    private DbConnection dbConnection;

    public ArrayList<Product_Management> getAll() {
        ArrayList<Product_Management> lstProduct = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCT_MANAGEMENT ";
        try (Connection con = new DbConnection().getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product_Management pm = new Product_Management();
                pm.setId_product(rs.getString("ID_PRODUCT"));
                pm.setName_product(rs.getString("NAME_PRODUCT"));
                pm.setUnit_size(rs.getInt("UNIT_PRICE"));
                pm.setQuantity(rs.getInt("QUANTITY"));
                pm.setReveneu(rs.getInt("REVENUE"));
                lstProduct.add(pm);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstProduct;
    }

    public boolean addNew(Product_Management pm) {
        String sql = "INSERT INTO PRODUCT_MANAGEMENT(ID_PRODUCT, NAME_PRODUCT, UNIT_PRICE, QUANTITY, REVENUE, DATE_PRO)"
                + " VALUES(?, ?, ?, ?, ?, CURRENT_TIMESTAMP);";

        try (Connection con = dbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, pm.getId_product());
            ps.setObject(2, pm.getName_product());
            ps.setObject(3, pm.getUnit_size());
            ps.setObject(4, pm.getQuantity());
            ps.setObject(5, pm.getReveneu());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(String ID_PRODUCT, Product_Management pm) {
        String sql = "UPDATE PRODUCT_MANAGEMENT SET "
                + "NAME_PRODUCT = ?, "
                + "UNIT_PRICE = ?, "
                + "QUANTITY = ?, "
                + "REVENUE = ?, "
                + "DATE_PRO = CURRENT_TIMESTAMP "
                + "WHERE ID_PRODUCT = ?";

        try (Connection con = dbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setObject(5, ID_PRODUCT);
            ps.setObject(1, pm.getName_product());
            ps.setObject(2, pm.getUnit_size());
            ps.setObject(3, pm.getQuantity());
            ps.setObject(4, pm.getReveneu());

            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Product_Management> getAllSort(String sort, String firstDay, String lastDay) {
        ArrayList<Product_Management> lstProduct = new ArrayList<>();

        if (sort.equals("ASC")) {
            String sql = "SELECT * FROM PRODUCT_MANAGEMENT \n" +
                        "WHERE (DATE_PRO > CAST( ? AS DATETIME) or DATE_PRO = CAST( ? AS DATETIME)) \n" +
                        "	AND (DATE_PRO < CAST( ? AS DATETIME) or DATE_PRO = CAST( ? AS DATETIME))\n" +
                        "ORDER BY REVENUE ASC";

            try (Connection con = dbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setObject(1, firstDay);
                ps.setObject(2, firstDay);
                ps.setObject(3, lastDay);
                ps.setObject(4, lastDay);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Product_Management pm = new Product_Management();
                    pm.setId_product(rs.getString("ID_PRODUCT"));
                    pm.setName_product(rs.getString("NAME_PRODUCT"));
                    pm.setUnit_size(rs.getInt("UNIT_PRICE"));
                    pm.setQuantity(rs.getInt("QUANTITY"));
                    pm.setReveneu(rs.getInt("REVENUE"));
                    pm.setDate_pro(rs.getDate("DATE_PRO"));
                    lstProduct.add(pm);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else  {
            String sql = "SELECT * FROM PRODUCT_MANAGEMENT \n" +
                        "WHERE (DATE_PRO > CAST( ? AS DATETIME) or DATE_PRO = CAST( ? AS DATETIME)) \n" +
                        "	AND (DATE_PRO < CAST( ? AS DATETIME) or DATE_PRO = CAST( ? AS DATETIME))\n" +
                        "ORDER BY REVENUE DESC";

            try (Connection con = dbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setObject(1, firstDay);
                ps.setObject(2, firstDay);
                ps.setObject(3, lastDay);
                ps.setObject(4, lastDay);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Product_Management pm = new Product_Management();
                    pm.setId_product(rs.getString("ID_PRODUCT"));
                    pm.setName_product(rs.getString("NAME_PRODUCT"));
                    pm.setUnit_size(rs.getInt("UNIT_PRICE"));
                    pm.setQuantity(rs.getInt("QUANTITY"));
                    pm.setReveneu(rs.getInt("REVENUE"));
                    pm.setDate_pro(rs.getDate("DATE_PRO"));
                    lstProduct.add(pm);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return lstProduct;
    }

    
    public Product_Management getById(String ID_PRODUCT) {
        Product_Management pm = new Product_Management();

        String sql = "SELECT * FROM PRODUCT_MANAGEMENT "
                + "WHERE ID_PRODUCT = ?";

        try (Connection con = dbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ID_PRODUCT);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pm.setId_product(rs.getString("ID_PRODUCT"));
                pm.setName_product(rs.getString("NAME_PRODUCT"));
                pm.setUnit_size(rs.getInt("UNIT_PRICE"));
                pm.setQuantity(rs.getInt("QUANTITY"));
                pm.setReveneu(rs.getInt("REVENUE"));
                pm.setDate_pro(rs.getDate("DATE_PRO"));
                return pm;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Calculate getByIdCalculate(String ID_PRODUCT) {
        Calculate calculate = new Calculate();

        String sql = "SELECT "
                + "ID_PRODUCT,"
                + "NAME_PRODUCT,"
                + "QUANTITY,"
                + "UNIT_PRICE"
                + " FROM CALCULATE "
                + "WHERE ID_PRODUCT = ?";

        try (Connection con = dbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ID_PRODUCT);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                calculate.setId_product(rs.getString("ID_PRODUCT"));
                calculate.setName_product(rs.getString("NAME_PRODUCT"));
                calculate.setQuantity(rs.getInt("QUANTITY"));
                calculate.setUnit_price(rs.getInt("UNIT_PRICE"));
                return calculate;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean deleteBillingDetail(String ID_PRODUCT) {
        String sql = " DELETE FROM BILLINGDETAIL WHERE ID_PRODUCT = ?";

        try (Connection con = dbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setObject(1, ID_PRODUCT);

            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteProductManagement(String ID_PRODUCT) {
        String sql = " DELETE FROM PRODUCT_MANAGEMENT WHERE ID_PRODUCT = ?";

        try (Connection con = dbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setObject(1, ID_PRODUCT);

            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void main(String[] args) {
        Product_ManagementRepository pm = new Product_ManagementRepository();
        
        for (Product_Management p : pm.getAll()) {
            System.out.println(p.toString());
        }
    }
}
