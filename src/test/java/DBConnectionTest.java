import org.testng.annotations.Test;

import java.sql.*;

public class DBConnectionTest {

  @Test
  public void testDBConnect () {

    Connection conn = null;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://109.196.164.32:3306/learnqa?user=learnqa&password=learnqa");
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("select * from Cats");
      while (rs.next()) {
        System.out.println("Cat's id: " + rs.getString(1) + " with name: " + rs.getString(2) + ", birthday: " + rs.getString(3));
      }
      rs.close();
      st.close();
      conn.close();
    } catch (SQLException ex) {
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }

  }
}
