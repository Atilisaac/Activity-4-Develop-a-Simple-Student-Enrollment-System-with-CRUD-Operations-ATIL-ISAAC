/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student_enrollment_system;
import java.sql.Date;
/**
 *
 * @author Administrator
 */
public class Enrollment {
     private int idEnrollment;
    private int studentId;
    private int courseId;
    private Date enrollmentDate;

    // Constructors
    public Enrollment() {}

    public Enrollment(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public Enrollment(int idEnrollment, int studentId, int courseId) {
        this.idEnrollment = idEnrollment;
        this.studentId = studentId;
        this.courseId = courseId;
    }

    // Getters and Setters
    public int getIdEnrollment() { return idEnrollment; }
    public void setIdEnrollment(int idEnrollment) { this.idEnrollment = idEnrollment; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public Date getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(Date enrollmentDate) { this.enrollmentDate = enrollmentDate; }

    @Override
    public String toString() {
        return "Enrollment: StudentID=" + studentId + ", CourseID=" + courseId;
    }

}
