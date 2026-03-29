Student Enrollment System
Project Overview

The Student Enrollment System is a Java Swing desktop application for managing:

Students – add, update, delete, and view student information.
Courses – add, update, delete, and view course information.
Enrollments – enroll students in courses, view enrollments, and delete enrollments.

All data is stored in a MySQL database.

Project Structure
Student_Enrollment_System/
├── src/
│   └── student_enrollment_system/
│       ├── StudentForm.java       # Main GUI class
│       ├── DBConnection.java      # Database connection helper
│       └── ... other helper classes ...
├── lib/
│   └── mysql-connector-java-<version>.jar  # MySQL JDBC Driver
├── build/
├── StudentEnrollmentDB.sql        # SQL schema for database
└── README.md
src/ – Contains all Java source code files.
lib/ – External libraries such as the MySQL JDBC driver.
build/ – Auto-generated compiled classes.
StudentEnrollmentDB.sql – MySQL script to create the database and tables.
Database Setup
Open MySQL Workbench (or any MySQL client).
Run the SQL script StudentEnrollmentDB.sql to create the database and tables:
-- Create database
CREATE DATABASE IF NOT EXISTS StudentEnrollmentDB;
USE StudentEnrollmentDB;

-- Students Table
CREATE TABLE IF NOT EXISTS students (
    idstudents INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    email VARCHAR(100) NOT NULL,
    PRIMARY KEY (idstudents)
);

-- Courses Table
CREATE TABLE IF NOT EXISTS courses (
    idcourse INT NOT NULL AUTO_INCREMENT,
    course_name VARCHAR(100) NOT NULL,
    description TEXT,
    credits INT NOT NULL,
    PRIMARY KEY (idcourse)
);

-- Enrollments Table
CREATE TABLE IF NOT EXISTS enrollments (
    idenrollment INT NOT NULL AUTO_INCREMENT,
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    enrollment_date DATE DEFAULT CURRENT_DATE,
    PRIMARY KEY (idenrollment),
    FOREIGN KEY (student_id) REFERENCES students(idstudents),
    FOREIGN KEY (course_id) REFERENCES courses(idcourse)
);
Make sure the DB username/password in DBConnection.java matches your MySQL setup:
private static final String URL = "jdbc:mysql://localhost:3306/StudentEnrollmentDB";
private static final String USER = "root";
private static final String PASS = "your_password";
Dependencies
Java JDK 24 or higher
NetBeans IDE (or any Java IDE)
MySQL Server
MySQL JDBC Driver (mysql-connector-java-<version>.jar)

Make sure the JDBC driver is added to the project Libraries in NetBeans.

Running the Application
Open the project in NetBeans.
Ensure MySQL server is running.
Clean and Build the project.
Run the project using F6 or the green Run button.
The GUI will open, centered on the screen and resizable.
Features
Students
Add, update, delete, and view students.
Search by student ID.
Courses
Add, update, delete, and view courses.
Search by course ID.
Enrollments
Enroll students in courses.
View all enrollments.
Delete enrollments.
Combo box populated with courses from the database.
Search enrollments by enrollment ID.
