/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student_enrollment_system;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Administrator
 */
public class SubjectDAO {
     public void addSubject(Subject subject) {
        String sql = "INSERT INTO subject (subjectName, courseId) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, subject.getSubjectName());
            pst.setInt(2, subject.getCourseId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSubject(Subject subject) {
        String sql = "UPDATE subject SET subjectName=?, courseId=? WHERE idSubject=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, subject.getSubjectName());
            pst.setInt(2, subject.getCourseId());
            pst.setInt(3, subject.getIdSubject());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSubject(int idSubject) {
        String sql = "DELETE FROM subject WHERE idSubject=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, idSubject);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Subject> getAllSubjects() {
        List<Subject> subjects = new ArrayList<>();
        String sql = "SELECT s.idSubject, s.subjectName, s.courseId, c.courseName " +
                     "FROM subject s JOIN course c ON s.courseId = c.idCourse";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Subject s = new Subject();
                s.setIdSubject(rs.getInt("idSubject"));
                s.setSubjectName(rs.getString("subjectName"));
                s.setCourseId(rs.getInt("courseId"));
                s.setCourseName(rs.getString("courseName")); // optional for display
                subjects.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subjects;
    }
}
