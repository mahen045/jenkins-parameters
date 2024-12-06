package org.example;
import java.sql.*;
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn != null) {
                PreparedStatement pstmt = conn.prepareStatement("select * from product");
                //pstmt.setString(1,"EL101");
                ResultSet rs = pstmt.executeQuery();
                //pstmt.executeQuery();
                while(rs.next()){
                    Product prod = new Product();
                   // Object obj = rs.getObject(1);
                    prod.setProdId(rs.getObject(1, String.class));
                   // Product prod = (Product)obj;
                    System.out.println(prod.getProdId());
                    //System.out.println(rs.getString(1)+":"+rs.getString(2));
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
//       String url = "jdbc:postgresql://localhost/postgres";
//       String username = "postgres";
//       String password = "pass123";
//      // Class.forName("org.postgresql.Driver");
//       Connection conn = DriverManager.getConnection(url, username,password);

       //Statement stmt = conn.createStatement();

       //ResultSet rs = stmt.executeQuery("select * from product");

    }
}
