import java.sql.*;

public class Test {
    public static void main(String[] args) {
        String sql = "SELECT empID,name,gender,position FROM employees ";
        String userName = "postgres";
        String password = "P@ssw0rd()SQL";
        String url = "jdbc:postgresql://localhost:5432/employee";

        try {
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
               String name = rs.getString("name");
               String gender = rs.getString("gender");
               String position = rs.getString("position");
               String empID = rs.getString("empID");
               System.out.println(empID+" "+name + " " + gender+" "+position);
           }
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
