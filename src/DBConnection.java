import java.sql.*;
public class DBConnection {
    public Connection conn;
    DBConnection() throws Exception{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new DBConnection();
    }
}
