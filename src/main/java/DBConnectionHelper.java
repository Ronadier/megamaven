import oracle.jdbc.internal.OracleTypes;

import java.sql.*;

public class DBConnectionHelper {
  public static void main(String[] args) throws SQLException {
    String url = "localhost";
    String port = "1829";
    String dbName = "crmcvrt";
    String user = "EIP_USER";
    String password = "eip_user";
    DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
    try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS = (PROTOCOL = TCP)(HOST = localhost)(PORT = 4455))(CONNECT_DATA=(SERVICE_NAME = S1uniexp.south.rt.ru)))",
            "MDM_API_AST", "d0Lirung#")) {
      if (conn != null) {
        System.out.println("Connected to the database!");
      } else {
        System.out.println("Failed to make connection!");
      }
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("select MDM_DATA_SOURCE.GET_VERSION from dual");
      while (rs.next()) {
        System.out.println(rs.getString(1));
      }
      CallableStatement statement = conn.prepareCall("{ ? = call MDM_DATA_SOURCE.GET_VERSION}");
      statement.registerOutParameter(1, OracleTypes.VARCHAR);
      statement.execute();
      System.out.println(statement.getString(1));
    } catch (SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
