package msg;

import java.sql.*;

public class InsertToDB {
    Connection conn;
  {
    try {
      conn = DriverManager.getConnection("jdbc:mysql://109.196.164.32:3306/learnqa?user=learnqa&password=learnqa");
    } catch (SQLException ex) {
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
  }
  public void insertToDB(Message message) {
    Statement st = null;
    try {
      st = conn.createStatement();
      st.executeQuery("use learnqa_insert_update_delete");

      String query = " insert into learnqa_insert_update_delete.CatsOrders (id, name, paid, adds, cost) "
              + " values (?, ?, ?, ?, ?)";
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      preparedStmt.setInt (1, 9999);
      preparedStmt.setString (2, message.sender);
      preparedStmt.setString   (3, "Y");
      preparedStmt.setString(4, message.message);
      preparedStmt.setInt    (5, 5000);

      preparedStmt.execute();

      conn.close();
    } catch (SQLException ex) {
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
  }
}

