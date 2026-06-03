import java.sql.*;

public class JDBCConnectionDemo {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "";

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            System.out.println("ID\tName\tAge\tCourse");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getInt("age") + "\t" +
                    rs.getString("course")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}