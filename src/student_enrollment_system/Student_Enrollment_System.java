/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package student_enrollment_system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Administrator
 */
public class Student_Enrollment_System {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            
        // MySQL database credentials
        String url = "jdbc:mysql://localhost:3306/StudentEnrollmentDB";
        String user = "root"; // replace with your MySQL username
        String password = "@Choyisaac12"; // replace with your MySQL password

        // Sample student data
        String firstName = "Maria";
        String lastName = "Santos";
        int age = 19;
        String email = "maria.santos@example.com";

        // SQL statement to insert a student
        String sql = "INSERT INTO students (first_name, last_name, age, email) VALUES (?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = con.prepareStatement(sql)) {

            // Set the parameters
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setInt(3, age);
            stmt.setString(4, email);

            // Execute insert
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Student inserted successfully!");
            } else {
                System.out.println("❌ Failed to insert student.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Connection failed or SQL error!");
            e.printStackTrace();
        }
    }
    }
    

