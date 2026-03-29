/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student_enrollment_system;

/**
 *
 * @author Administrator
 */
public class Course {
   
    private int idCourse;
    private String courseName;
    private String description;

    // Constructors
    public Course() {}

    public Course(String courseName, String description) {
        this.courseName = courseName;
        this.description = description;
    }

    public Course(int idCourse, String courseName, String description) {
        this.idCourse = idCourse;
        this.courseName = courseName;
        this.description = description;
    }

    // Getters and Setters
    public int getIdCourse() { return idCourse; }
    public void setIdCourse(int idCourse) { this.idCourse = idCourse; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return courseName;
    }
}
