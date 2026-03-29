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
public class EnrollmentDAO {
        // Add course (ID auto-increment)
    public void addCourse(Course course) {
        String sql = "INSERT INTO course (courseName, description) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, course.getCourseName());
            pst.setString(2, course.getDescription());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Course added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Show course by ID (fill text fields)
    public Course getCourseById(int id) {
        String sql = "SELECT * FROM course WHERE idCourse=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Course(
                        rs.getInt("idCourse"),
                        rs.getString("courseName"),
                        rs.getString("description")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update course (fill fields first)
    public void updateCourse(Course course) {
        String sql = "UPDATE course SET courseName=?, description=? WHERE idCourse=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, course.getCourseName());
            pst.setString(2, course.getDescription());
            pst.setInt(3, course.getIdCourse());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Course updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete course (ask for confirmation)
    public void deleteCourse(int id) {
        Course c = getCourseById(id);
        if (c != null) {
            int confirm = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to delete: " + c.getCourseName() + "?",
                    "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM course WHERE idCourse=?";
                try (Connection conn = DBConnection.getConnection();
                     PreparedStatement pst = conn.prepareStatement(sql)) {
                    pst.setInt(1, id);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Course deleted successfully!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Course not found!");
        }
    }

    // Get all courses (for JTable)
    public List<Course> getAllCourses() {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT * FROM course";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Course(
                        rs.getInt("idCourse"),
                        rs.getString("courseName"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}


