/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student_enrollment_system;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Administrator
 */



public class StudentDAO {
   // Add student (ID auto-increment)
    public void addStudent(Student student) {
        String sql = "INSERT INTO student (firstName, lastName, age, email) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, student.getFirstName());
            pst.setString(2, student.getLastName());
            pst.setInt(3, student.getAge());
            pst.setString(4, student.getEmail());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Student added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all students (for JTable)
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("idStudent"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getInt("age"),
                        rs.getString("email")
                );
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Show student by ID (for filling textfields)
    public Student getStudentById(int id) {
        String sql = "SELECT * FROM student WHERE idStudent=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getInt("idStudent"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getInt("age"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // not found
    }

    // Update student (fill fields first)
    public void updateStudent(Student student) {
        String sql = "UPDATE student SET firstName=?, lastName=?, age=?, email=? WHERE idStudent=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, student.getFirstName());
            pst.setString(2, student.getLastName());
            pst.setInt(3, student.getAge());
            pst.setString(4, student.getEmail());
            pst.setInt(5, student.getIdStudent());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Student updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete student (ask for confirmation)
    public void deleteStudent(int id) {
        Student s = getStudentById(id);
        if (s != null) {
            int confirm = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to delete: " + s.getFirstName() + " " + s.getLastName() + "?",
                    "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM student WHERE idStudent=?";
                try (Connection conn = DBConnection.getConnection();
                     PreparedStatement pst = conn.prepareStatement(sql)) {
                    pst.setInt(1, id);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Student deleted successfully!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Student not found!");
        }
    }
}
