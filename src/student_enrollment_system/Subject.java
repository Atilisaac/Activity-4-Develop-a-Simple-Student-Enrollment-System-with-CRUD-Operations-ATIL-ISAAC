/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student_enrollment_system;

/**
 *
 * @author Administrator
 */
public class Subject {
   private int idSubject;
    private String subjectName;
    private int courseId;      // foreign key
    private String courseName; // optional for display

    // Constructors
    public Subject() {}

    public Subject(String subjectName, int courseId) {
        this.subjectName = subjectName;
        this.courseId = courseId;
    }

    public Subject(int idSubject, String subjectName, int courseId) {
        this.idSubject = idSubject;
        this.subjectName = subjectName;
        this.courseId = courseId;
    }

    public Subject(int idSubject, String subjectName, int courseId, String courseName) {
        this.idSubject = idSubject;
        this.subjectName = subjectName;
        this.courseId = courseId;
        this.courseName = courseName;
    }

    // Getters and Setters
    public int getIdSubject() { return idSubject; }
    public void setIdSubject(int idSubject) { this.idSubject = idSubject; }

    public String getSubjectName() { return subjectName; }
    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }

    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    @Override
    public String toString() {
        return subjectName;
    }
}
