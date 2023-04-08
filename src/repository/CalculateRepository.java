package repository;

import java.util.ArrayList;
import model.Calculate;
import java.sql.*;
import model.BillingDetail;

public class CalculateRepository {

    private DbConnection dbConnection;

    public ArrayList<Calculate> getAll() {
        ArrayList<Calculate> lstCalculate = new ArrayList<>();
        String sql = "SELECT * FROM CALCULATE  ";

        try (Connection con = dbConnection.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Calculate c = new Calculate();
                c.setId_product(rs.getString("ID_PRODUCT"));
                c.setName_product(rs.getString("NAME_PRODUCT"));
                c.setQuantity(rs.getInt("QUANTITY"));
                c.setUnit_price(rs.getInt("UNIT_PRICE"));
                c.setTotal(rs.getInt("TOTAL"));
                lstCalculate.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstCalculate;
    }
    
    public ArrayList<BillingDetail> getAllModel() {
        ArrayList<BillingDetail> lstCalculate = new ArrayList<>();
        String sql = "SELECT *  FROM BILLINGDETAIL";

        try (Connection con = dbConnection.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BillingDetail c = new BillingDetail();
                c.setOrdinal_numbers(rs.getInt("ORDINAL_NUMBERS"));
                c.setId_product(rs.getString("ID_PRODUCT"));
                c.setName_product(rs.getString("NAME_PRODUCT"));
                c.setQuantity(rs.getInt("QUANTITY"));
                c.setUnit_price(rs.getInt("UNIT_PRICE"));
                c.setTotal(rs.getInt("TOTAL"));
                lstCalculate.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstCalculate;
    }
    
    public Boolean getTblQuantityAfterCalculates(String id) {
        String sql = "UPDATE PRODUCT_MANAGEMENT\n" +
                    " SET QUANTITY = (  SELECT P.QUANTITY - C.QUANTITY\n" +
        "				FROM PRODUCT_MANAGEMENT P\n" +
        "				INNER JOIN CALCULATE C ON P.ID_PRODUCT = C.ID_PRODUCT\n" +
        "				WHERE P.ID_PRODUCT = ? \n" +
        "				),\n" +
                    "	  REVENUE  = (  SELECT P.REVENUE + C.TOTAL\n" +
            "				FROM PRODUCT_MANAGEMENT P\n" +
            "				INNER JOIN CALCULATE C ON P.ID_PRODUCT = C.ID_PRODUCT\n" +
            "				WHERE P.ID_PRODUCT = ?\n" +
            "				 ),\n" +
                    "	  DATE_PRO = GETDATE()\n" +
                    "WHERE ID_PRODUCT = ?";

        try (Connection con = dbConnection.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            ps.setObject(2, id);
            ps.setObject(3, id);
            
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public Calculate getById(String id_product) {
        Calculate c = new Calculate();
        
        String sql = "SELECT * FROM PRODUCT_MANAGEMENT WHERE ID_PRODUCT = ?";
        
        try (Connection con = dbConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id_product);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c.setId_product(id_product);
                c.setName_product(rs.getString("NAME_PRODUCT"));
                c.setUnit_price(rs.getInt("UNIT_PRICE"));
                c.setQuantity(0);
                c.setTotal(0);
                return c;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public BillingDetail getMinTotal() {
        BillingDetail c = new BillingDetail();
        
        String sql = " SELECT TOP 1 ID_PRODUCT, NAME_PRODUCT "+
                       "FROM BILLINGDETAIL\n" +
                       "GROUP BY ID_PRODUCT, NAME_PRODUCT\n" +
                       "ORDER BY SUM(TOTAL) DESC";
        
        try (Connection con = dbConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c.setName_product(rs.getString("NAME_PRODUCT"));
                c.setId_product(rs.getString("ID_PRODUCT"));
                c.setUnit_price(0);
                c.setQuantity(0);
                c.setTotal(0);
                return c;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public BillingDetail getMaxTotal() {
        BillingDetail c = new BillingDetail();
        
        String sql = " SELECT TOP 1 ID_PRODUCT, NAME_PRODUCT "+
                       "FROM BILLINGDETAIL\n" +
                       "GROUP BY ID_PRODUCT, NAME_PRODUCT\n" +
                       "ORDER BY SUM(TOTAL) ASC";
        
        try (Connection con = dbConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c.setName_product(rs.getString("NAME_PRODUCT"));
                c.setId_product(rs.getString("ID_PRODUCT"));
                c.setUnit_price(0);
                c.setQuantity(0);
                c.setTotal(0);
                return c;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean addNew(Calculate c) {
        String sql = "INSERT INTO CALCULATE VALUES (?, ?, ?, ?, ?)";
        try (Connection con = dbConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, c.getId_product());
            ps.setObject(2, c.getName_product());
            ps.setObject(3, c.getQuantity());
            ps.setObject(4, c.getUnit_price());
            ps.setObject(5, c.getTotal());
            
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean addNewModel(BillingDetail c) {
        String sql = "INSERT INTO BILLINGDETAIL VALUES (?, ?, ?, ?, ?)";
        try (Connection con = dbConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, c.getId_product());
            ps.setObject(2, c.getName_product());
            ps.setObject(3, c.getQuantity());
            ps.setObject(4, c.getUnit_price());
            ps.setObject(5, c.getTotal());
            
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    
    public boolean update(String id_product, Calculate c) {
        String sql = "UPDATE CALCULATE SET "
                + "NAME_PRODUCT = ?,"
                + "QUANTITY = ?,"
                + "UNIT_PRICE = ?,"
                + "TOTAL = ? "
                + "WHERE ID_PRODUCT = ?";
        try (Connection con = dbConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, c.getName_product());
            ps.setObject(2, c.getQuantity());
            ps.setObject(3, c.getUnit_price());
            ps.setObject(4, c.getTotal());
            ps.setObject(5, id_product);
            
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean delete(String id_product) {
        String sql = "DELETE FROM CALCULATE WHERE ID_PRODUCT = ?";
        try (Connection con = dbConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id_product);            
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean rollBack(String id) {
        String sql = " UPDATE PRODUCT_MANAGEMENT\n" +
                    " SET QUANTITY = ( SELECT P.QUANTITY + C.QUANTITY\n" +
            "				FROM PRODUCT_MANAGEMENT P\n" +
            "				INNER JOIN CALCULATE C ON P.ID_PRODUCT = C.ID_PRODUCT\n" +
            "				WHERE P.ID_PRODUCT =? \n" +
            "				),\n" +
                    "	REVENUE = ( SELECT P.REVENUE - C.TOTAL\n" +
            "				FROM PRODUCT_MANAGEMENT P\n" +
            "				INNER JOIN CALCULATE C ON P.ID_PRODUCT = C.ID_PRODUCT\n" +
            "				WHERE P.ID_PRODUCT = ?\n" +
            "				 ),\n" +
                    "	DATE_PRO = GETDATE()\n" +
                    "WHERE ID_PRODUCT = ? ";
        try (Connection con = dbConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            ps.setObject(2, id);
            ps.setObject(3, id);
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    
    public boolean deleteBillingDetail(String id) {
        String sql = "DELETE FROM BILLINGDETAIL WHERE ID_PRODUCT = ?";
        try (Connection con = dbConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) { 
            ps.setObject(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteCalculate() {
        String sql = "DELETE FROM CALCULATE";
        try (Connection con = dbConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {          
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
