package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import db.DBConnection;
import model.Product;

public class ProductDAO {
	 // INSERT
    public void addProduct(Product p) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO product VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, p.getId());
            ps.setString(2, p.getName());
            ps.setDouble(3, p.getPrice());

            ps.executeUpdate();
            System.out.println("Product Added!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DISPLAY
    public void getProducts() {
        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM product";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getDouble(3)
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteProduct(int id) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "DELETE FROM product WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("Product Deleted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
