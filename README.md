The Student Enrollment System is a Java desktop application that helps manage students, courses, and enrollments in a school. It connects to a MySQL database to store all data.

Key Features:
Student Management
Add new students with their name, age, and email.
Update student details.
Delete students from the system.
View all students or search by student ID.
Course Management
Add new courses with a name, description, and number of credits.
Update course details.
Delete courses.
View all courses or search by course ID.
Enrollment Management
Enroll students in courses.
View all enrollments in a table with student name, course name, and enrollment date.
Delete enrollments.
Use a combo box to select courses when enrolling a student.
Database Structure:
Students Table – stores student information (ID, name, age, email).
Courses Table – stores course information (ID, name, description, credits).
Enrollments Table – links students and courses using foreign keys and stores the enrollment date.
GUI Behavior:
All tables (JTable) show all data by default.
"View/Show" buttons filter data by ID.
Enrollment panel allows selecting a student and a course to enroll.
GUI is resizable and centered on the screen.

Purpose: This system helps teachers or administrators easily manage students, courses, and course enrollments without manually handling spreadsheets or paper records.
