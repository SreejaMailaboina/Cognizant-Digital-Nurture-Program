import java.sql.*;

public class StudentDAO {

    private static final String URL =
            "jdbc:mysql://localhost:3306/college";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Insert Student
    public void insertStudent(int id, String name,
                              int age, String course) {

        String sql =
                "INSERT INTO students(id,name,age,course) VALUES(?,?,?,?)";

        try (
                Connection con =
                        DriverManager.getConnection(URL, USER, PASSWORD);

                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, course);

            int rows = ps.executeUpdate();

            System.out.println(rows +
                    " record inserted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Student
    public void updateStudent(int id,
                              String newCourse,
                              int newAge) {

        String sql =
                "UPDATE students SET course=?, age=? WHERE id=?";

        try (
                Connection con =
                        DriverManager.getConnection(URL, USER, PASSWORD);

                PreparedStatement ps =
                        con.prepareStatement(sql)
        ) {

            ps.setString(1, newCourse);
            ps.setInt(2, newAge);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();

            System.out.println(rows +
                    " record updated successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        // Insert new student
        dao.insertStudent(4,
                "Sreeja",
                21,
                "BCA");

        // Update student
        dao.updateStudent(4,
                "MCA",
                22);
    }
}