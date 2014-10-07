import java.sql.*;

public class dbTest {

  public static void main(String[] args) throws Exception {
    Connection conn = null;    
    Statement stmt = null;
    ResultSet rs = null;
    String query = null;
    
    try {
      Class.forName("com.ddtek.jdbc.oracle.OracleDriver");
      String user = args[0];
      String password = args[1];
      conn = DriverManager.getConnection("jdbc:datadirect:oracle://192.168.0.221:1521;ServiceName=orcl;User=" + user +";password=" + password);
      stmt = conn.createStatement();
      query = "select * from tb_esero where rownum <= 1";
      rs = stmt.executeQuery(query);
      while (rs.next()) {
        System.out.println("aprv_no : " + rs.getString("aprv_no"));
      }
      rs.close();
      stmt.close();
      conn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

  
  
  
