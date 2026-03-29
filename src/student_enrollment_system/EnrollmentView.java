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
public class EnrollmentView {
     private int idEnrollment;
    private int studentId;
    private String studentName;
    private int courseId;
    private String courseName;
    private Date enrollmentDate;

    // Constructors
    public EnrollmentView() {}

    // Getters and Setters
    public int getIdEnrollment() { return idEnrollment; }
    public void setIdEnrollment(int idEnrollment) { this.idEnrollment = idEnrollment; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public Date getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(Date enrollmentDate) { this.enrollmentDate = enrollmentDate; }

    @Override
    public String toString() {
        return studentName + " enrolled in " + courseName + " on " + enrollmentDate;
    }
}
