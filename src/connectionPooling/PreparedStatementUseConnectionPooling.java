package connectionPooling;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 

public class PreparedStatementUseConnectionPooling {
    public static void main(String... arg) throws SQLException {
 
           ConnectionPool connectionPool = new ConnectionPool(
                        "org.postgresql.Driver",
                        "jdbc:postgresql://localhost:5432/payslip", "postgres", "Pass1word",
                        2, 3, true);
 
           Connection con = connectionPool.getConnection();
           System.out.println("We have got connection from ConnectionPool class");
           
           PreparedStatement prepStmt = con
                        .prepareStatement("select emp_id, emp_name from employee");
           
           ResultSet rs = prepStmt.executeQuery();
           while (rs.next()) {
                  System.out.print(rs.getInt("emp_id") + " ");
                  System.out.println(rs.getString("emp_name"));
           }
 
           if (rs != null)
                  rs.close(); // close resultSet
           if (prepStmt != null)
                  prepStmt.close(); // close PreparedStatement
 
           connectionPool.free(con);
           System.out.println("We have free/released connection to ConnectionPool class");
    }
}
 
/*OUTPUT
 
We have got connection from ConnectionPool class
7 ankit
8 rohit
We have free/released connection to ConnectionPool class
 
*/