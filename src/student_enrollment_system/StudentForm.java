/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package student_enrollment_system;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import javax.swing.JFrame;


/**
 *
 * @author Administrator
 */
public class StudentForm extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(StudentForm.class.getName());

    /**
     * Creates new form StudentForm
     */
    public StudentForm() {
        initComponents();
        this.setLocationRelativeTo(null); // null = center
        studentDAO = new StudentDAO();
        // 1️⃣ Frame settings
    this.setSize(680, 530);        // initial size
    this.setLocationRelativeTo(null); // center on screen
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(true);        // allow resizing

    
    
    DefaultTableModel model = new DefaultTableModel(
                
    new Object [][] {},
    new String [] { "ID", "First Name", "Last Name", "Age", "Email" }
);
tblStudents.setModel(model);
    }
    private StudentDAO studentDAO;
    private void clearStudentFields() {
    txtId.setText("");
    txtFirstName.setText("");
    txtLastName.setText("");
    txtAge.setText("");
    txtEmail.setText("");
}
// Clear course text fields
private void clearCourseFields() {
    txtCourseId.setText("");
    txtCourseName.setText("");
    txtCourseDescription.setText("");
    txtCredits.setText("");
}
private void refreshCourseTable() {
    try (Connection conn = DBConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM courses")) {

        DefaultTableModel model = (DefaultTableModel) tblCourse.getModel();
        model.setRowCount(0); // clear table

        while (rs.next()) {
            Object[] row = {
                rs.getInt("idcourse"),  
                rs.getString("course_name"),
                rs.getString("description"),
                rs.getInt("credits")
            };
            model.addRow(row);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
// Method to load all courses into JTable
private void loadAllCourses() {
    String sql = "SELECT * FROM courses";
    try (Connection conn = DBConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        DefaultTableModel model = (DefaultTableModel) tblCourse.getModel();
        model.setRowCount(0); // Clear the table

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("idcourse"),
                rs.getString("course_name"),
                rs.getString("description"),
                rs.getInt("credits")
            });
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error loading courses.");
    }
}
// Show all courses in JTable
private void showAllCourses() {
    String sql = "SELECT * FROM courses";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        DefaultTableModel model = (DefaultTableModel) tblCourse.getModel();
        model.setRowCount(0); // clear JTable

        while (rs.next()) {
            Object[] row = {
                rs.getInt("idcourse"),
                rs.getString("course_name"),
                rs.getString("description"),
                rs.getInt("credits")
            };
            model.addRow(row);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error fetching courses!");
    }
}
private void loadCoursesToComboBox() {
    enrollcombo.removeAllItems();
    String sql = "SELECT idcourse, course_name FROM courses";
    try (Connection conn = DBConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            int id = rs.getInt("idcourse");
            String name = rs.getString("course_name");
            enrollcombo.addItem(id + " - " + name); // e.g., "1 - Math"
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error loading courses!");
    }
}



// ------------------- POPULATE COURSE COMBOBOX -------------------
// Call this once in your constructor after initComponents()

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Parent = new javax.swing.JPanel();
        firstpanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        secondpanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCourse = new javax.swing.JTable();
        sas = new javax.swing.JLabel();
        txtCourseId1 = new javax.swing.JLabel();
        txtCourseId2 = new javax.swing.JLabel();
        txtCourseId3 = new javax.swing.JLabel();
        txtCourseId = new javax.swing.JTextField();
        txtCourseName = new javax.swing.JTextField();
        txtCourseDescription = new javax.swing.JTextField();
        txtCredits = new javax.swing.JTextField();
        btnAddCourse = new javax.swing.JButton();
        btnUpdateCourse = new javax.swing.JButton();
        btnDeleteCourse = new javax.swing.JButton();
        btnShowCourse = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        thirdpanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEnrollment = new javax.swing.JTable();
        btnViewEnrollment = new javax.swing.JButton();
        btnDeleteEnrollment = new javax.swing.JButton();
        btnEnroll = new javax.swing.JButton();
        txtEnrollmentID = new javax.swing.JTextField();
        enrollcombo = new javax.swing.JComboBox<>();
        FVIEW = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        StudentID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setLayout(null);

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Student");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(10, 100, 100, 40);

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Course");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(10, 180, 100, 40);

        jButton3.setBackground(new java.awt.Color(0, 153, 153));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Subject");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(10, 260, 100, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 120, 490);

        Parent.setBackground(new java.awt.Color(204, 255, 255));
        Parent.setLayout(new java.awt.CardLayout());

        firstpanel.setBackground(new java.awt.Color(204, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("First Name");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255), 2));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Last Name");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255), 2));

        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("      Age");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255), 2));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("    Email");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255), 2));

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("              ADD STUDENT");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 0, 0));
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 0, 0));
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 0, 0));
        jButton6.setText("VIEW");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(0, 0, 0));
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("STUDENT ID:");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 204, 255), 2));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(54, 54, 54)
                        .addComponent(btnDelete))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(13, 13, 13)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtAge, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtLastName)
                                .addComponent(txtEmail)))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jButton6)
                        .addGap(36, 36, 36)
                        .addComponent(btnUpdate))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(jButton6)
                    .addComponent(btnAdd))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout firstpanelLayout = new javax.swing.GroupLayout(firstpanel);
        firstpanel.setLayout(firstpanelLayout);
        firstpanelLayout.setHorizontalGroup(
            firstpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firstpanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );
        firstpanelLayout.setVerticalGroup(
            firstpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firstpanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        Parent.add(firstpanel, "card2");

        secondpanel.setBackground(new java.awt.Color(204, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblCourse.setBackground(new java.awt.Color(255, 255, 255));
        tblCourse.setForeground(new java.awt.Color(0, 0, 0));
        tblCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "course_id", "course_name", "description", "credits"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblCourse);

        sas.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        sas.setForeground(new java.awt.Color(0, 0, 0));
        sas.setText("Course ID:");
        sas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        txtCourseId1.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtCourseId1.setForeground(new java.awt.Color(0, 0, 0));
        txtCourseId1.setText("Course Name:");
        txtCourseId1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        txtCourseId2.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtCourseId2.setForeground(new java.awt.Color(0, 0, 0));
        txtCourseId2.setText("Description");
        txtCourseId2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        txtCourseId3.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        txtCourseId3.setForeground(new java.awt.Color(0, 0, 0));
        txtCourseId3.setText("Credits");
        txtCourseId3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        txtCourseId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCourseIdActionPerformed(evt);
            }
        });

        txtCourseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCourseNameActionPerformed(evt);
            }
        });

        txtCourseDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCourseDescriptionActionPerformed(evt);
            }
        });

        txtCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCreditsActionPerformed(evt);
            }
        });

        btnAddCourse.setBackground(new java.awt.Color(204, 204, 204));
        btnAddCourse.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddCourse.setForeground(new java.awt.Color(0, 0, 0));
        btnAddCourse.setText("ADD");
        btnAddCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCourseActionPerformed(evt);
            }
        });

        btnUpdateCourse.setBackground(new java.awt.Color(204, 204, 204));
        btnUpdateCourse.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdateCourse.setForeground(new java.awt.Color(0, 0, 0));
        btnUpdateCourse.setText("UPDATE");
        btnUpdateCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCourseActionPerformed(evt);
            }
        });

        btnDeleteCourse.setBackground(new java.awt.Color(204, 204, 204));
        btnDeleteCourse.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteCourse.setForeground(new java.awt.Color(0, 0, 0));
        btnDeleteCourse.setText("DELETE");
        btnDeleteCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCourseActionPerformed(evt);
            }
        });

        btnShowCourse.setBackground(new java.awt.Color(204, 204, 204));
        btnShowCourse.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnShowCourse.setForeground(new java.awt.Color(0, 0, 0));
        btnShowCourse.setText("SHOW");
        btnShowCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowCourseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnAddCourse)
                .addGap(44, 44, 44)
                .addComponent(btnUpdateCourse)
                .addGap(46, 46, 46)
                .addComponent(btnDeleteCourse)
                .addGap(38, 38, 38)
                .addComponent(btnShowCourse)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCourseId1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCourseId2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCourseName)
                                    .addComponent(txtCourseDescription)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(sas, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(txtCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtCourseId3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCredits)))
                        .addGap(319, 319, 319))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sas)
                            .addComponent(txtCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCourseId1)
                            .addComponent(txtCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtCourseId2))
                    .addComponent(txtCourseDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCourseId3)
                    .addComponent(txtCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddCourse)
                    .addComponent(btnUpdateCourse)
                    .addComponent(btnDeleteCourse)
                    .addComponent(btnShowCourse))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("      ADD COURSE/VIEW");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout secondpanelLayout = new javax.swing.GroupLayout(secondpanel);
        secondpanel.setLayout(secondpanelLayout);
        secondpanelLayout.setHorizontalGroup(
            secondpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(secondpanelLayout.createSequentialGroup()
                .addGroup(secondpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(secondpanelLayout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(secondpanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        secondpanelLayout.setVerticalGroup(
            secondpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(secondpanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        Parent.add(secondpanel, "card3");

        thirdpanel.setBackground(new java.awt.Color(204, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Student");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Course");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblEnrollment.setBackground(new java.awt.Color(255, 255, 255));
        tblEnrollment.setForeground(new java.awt.Color(0, 0, 0));
        tblEnrollment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Enrollment ID ", "Student Name ", "Course Name ", "Enrollment Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblEnrollment);

        btnViewEnrollment.setBackground(new java.awt.Color(204, 204, 204));
        btnViewEnrollment.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnViewEnrollment.setForeground(new java.awt.Color(0, 0, 0));
        btnViewEnrollment.setText("View");
        btnViewEnrollment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewEnrollmentActionPerformed(evt);
            }
        });

        btnDeleteEnrollment.setBackground(new java.awt.Color(204, 204, 204));
        btnDeleteEnrollment.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteEnrollment.setForeground(new java.awt.Color(0, 0, 0));
        btnDeleteEnrollment.setText("Delete");
        btnDeleteEnrollment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteEnrollmentActionPerformed(evt);
            }
        });

        btnEnroll.setBackground(new java.awt.Color(204, 204, 204));
        btnEnroll.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEnroll.setForeground(new java.awt.Color(0, 0, 0));
        btnEnroll.setText("Enroll");
        btnEnroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnrollActionPerformed(evt);
            }
        });

        txtEnrollmentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnrollmentIDActionPerformed(evt);
            }
        });

        enrollcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEnrollmentID, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enrollcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnEnroll)
                        .addGap(88, 88, 88)
                        .addComponent(btnViewEnrollment)
                        .addGap(88, 88, 88)
                        .addComponent(btnDeleteEnrollment)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(enrollcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtEnrollmentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewEnrollment)
                    .addComponent(btnDeleteEnrollment)
                    .addComponent(btnEnroll))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout thirdpanelLayout = new javax.swing.GroupLayout(thirdpanel);
        thirdpanel.setLayout(thirdpanelLayout);
        thirdpanelLayout.setHorizontalGroup(
            thirdpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thirdpanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        thirdpanelLayout.setVerticalGroup(
            thirdpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thirdpanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        Parent.add(thirdpanel, "card4");

        FVIEW.setBackground(new java.awt.Color(204, 255, 255));
        FVIEW.setForeground(new java.awt.Color(0, 0, 0));

        tblStudents.setBackground(new java.awt.Color(255, 255, 255));
        tblStudents.setForeground(new java.awt.Color(0, 0, 0));
        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Student ID", "First Name", "Last Name", "Age", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblStudents);

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 0, 0));
        jButton8.setText("SHOW");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Student ID:");

        StudentID.setBackground(new java.awt.Color(255, 255, 255));
        StudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FVIEWLayout = new javax.swing.GroupLayout(FVIEW);
        FVIEW.setLayout(FVIEWLayout);
        FVIEWLayout.setHorizontalGroup(
            FVIEWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FVIEWLayout.createSequentialGroup()
                .addGroup(FVIEWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FVIEWLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FVIEWLayout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(StudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        FVIEWLayout.setVerticalGroup(
            FVIEWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FVIEWLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(FVIEWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(StudentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addGap(55, 55, 55))
        );

        Parent.add(FVIEW, "card5");

        getContentPane().add(Parent);
        Parent.setBounds(120, 0, 540, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Parent.removeAll();
        Parent.add(firstpanel);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    // 1️⃣ Load all enrollments into the JTable
    DefaultTableModel model = (DefaultTableModel) tblEnrollment.getModel();
    model.setRowCount(0); // clear existing rows

    String sqlEnrollments = "SELECT e.idenrollment, CONCAT(s.first_name, ' ', s.last_name) AS student_name, " +
                            "c.course_name, e.enrollment_date " +
                            "FROM enrollments e " +
                            "JOIN students s ON e.idstudent = s.idstudent    " +
                            "JOIN courses c ON e.idcourse = c.idcourse";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(sqlEnrollments);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("idenrollment"),
                rs.getString("student_name"),
                rs.getString("course_name"),
                rs.getString("enrollment_date")
            });
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error loading enrollments: " + ex.getMessage());
    }

    // 2️⃣ Fill the enrollcombo with all courses
    enrollcombo.removeAllItems(); // clear existing items
    String sqlCourses = "SELECT idcourse, course_name FROM courses";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(sqlCourses);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            // You can store id in the combo's hidden value if needed
            enrollcombo.addItem(rs.getInt("idcourse") + " - " + rs.getString("course_name"));
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error loading courses: " + ex.getMessage());
    }
        
        Parent.removeAll();
        Parent.add(thirdpanel);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        loadAllCourses(); // Populate the JTable
        
        Parent.removeAll();
        Parent.add(secondpanel);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       String idStr = txtId.getText().trim();
    if (idStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter the student ID!");
        return;
    }

    int id;
    try {
        id = Integer.parseInt(idStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID must be a number!");
        return;
    }

    try {
        Connection conn = DBConnection.getConnection();

        // 1️⃣ Get student info
        String sqlSelect = "SELECT * FROM students WHERE idstudent=?";
        PreparedStatement pstSelect = conn.prepareStatement(sqlSelect);
        pstSelect.setInt(1, id);
        ResultSet rs = pstSelect.executeQuery();

        if (rs.next()) {
            // Student exists, show info
            String info = "ID: " + rs.getInt("idstudent") +
                          "\nFirst Name: " + rs.getString("first_name") +
                          "\nLast Name: " + rs.getString("last_name") +
                          "\nAge: " + rs.getInt("age") +
                          "\nEmail: " + rs.getString("email");

            int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to delete this student?\n\n" + info,
                    "Confirm Delete", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                // 2️⃣ Delete student
                String sqlDelete = "DELETE FROM students WHERE idstudent=?";
                PreparedStatement pstDelete = conn.prepareStatement(sqlDelete);
                pstDelete.setInt(1, id);
                pstDelete.executeUpdate();
                JOptionPane.showMessageDialog(this, "Student deleted successfully!");
                clearStudentFields();
                showAllStudents();
                pstDelete.close();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Student not found!");
        }

        rs.close();
        pstSelect.close();
        conn.close();

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error deleting student.");
    }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       showAllStudents();
}

private void showAllStudents() {
    String sql = "SELECT * FROM students";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        DefaultTableModel model = (DefaultTableModel) tblStudents.getModel();
        model.setRowCount(0); // clear existing rows

        while (rs.next()) {
            Object[] row = {
                rs.getInt("idstudent"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getInt("age"),
                rs.getString("email")
            };
            model.addRow(row);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error fetching students!");
    }
        
        Parent.removeAll();
        Parent.add(FVIEW);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
         String idStr = txtId.getText().trim();
    if (idStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter the Student ID!");
        return;
    }

    int id;
    try {
        id = Integer.parseInt(idStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Student ID must be a number!");
        return;
    }

    // STEP 1: Load student info if text fields are empty
    if (txtFirstName.getText().isEmpty() && txtLastName.getText().isEmpty() 
        && txtAge.getText().isEmpty() && txtEmail.getText().isEmpty()) {

        try (Connection conn = DBConnection.getConnection()) {
            String sqlSelect = "SELECT * FROM students WHERE idstudent=?";
            PreparedStatement pstSelect = conn.prepareStatement(sqlSelect);
            pstSelect.setInt(1, id);
            ResultSet rs = pstSelect.executeQuery();

            if (rs.next()) {
                txtFirstName.setText(rs.getString("first_name"));
                txtLastName.setText(rs.getString("last_name"));
                txtAge.setText(String.valueOf(rs.getInt("age")));
                txtEmail.setText(rs.getString("email"));
            } else {
                JOptionPane.showMessageDialog(this, "Student not found!");
            }

            rs.close();
            pstSelect.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading student info!");
        }

    } 
    // STEP 2: Save edited info if text fields already have data
    else {
        String firstName = txtFirstName.getText().trim();
        String lastName = txtLastName.getText().trim();
        String ageStr = txtAge.getText().trim();
        String email = txtEmail.getText().trim();

        if (firstName.isEmpty() || lastName.isEmpty() || ageStr.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields to update!");
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Age must be a number!");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            String sqlUpdate = "UPDATE students SET first_name=?, last_name=?, age=?, email=? WHERE idstudent=?";
            PreparedStatement pstUpdate = conn.prepareStatement(sqlUpdate);
            pstUpdate.setString(1, firstName);
            pstUpdate.setString(2, lastName);
            pstUpdate.setInt(3, age);
            pstUpdate.setString(4, email);
            pstUpdate.setInt(5, id);

            int rows = pstUpdate.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Student updated successfully!");
                clearStudentFields();
                showAllStudents(); // refresh JTable
            } else {
                JOptionPane.showMessageDialog(this, "Update failed. Student not found!");
            }

            pstUpdate.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating student!");
        }
    }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String firstName = txtFirstName.getText().trim();
    String lastName = txtLastName.getText().trim();
    String ageStr = txtAge.getText().trim();
    String email = txtEmail.getText().trim();

    if(firstName.isEmpty() || lastName.isEmpty() || ageStr.isEmpty() || email.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill all fields!");
        return;
    }

    int age;
    try {
        age = Integer.parseInt(ageStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Age must be a number!");
        return;
    }

    String sql = "INSERT INTO students (first_name, last_name, age, email) VALUES (?, ?, ?, ?)";
    try {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, firstName);
        pst.setString(2, lastName);
        pst.setInt(3, age);
        pst.setString(4, email);
        pst.executeUpdate();
        JOptionPane.showMessageDialog(this, "Student added successfully!");
        clearStudentFields();
        showAllStudents();
        pst.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error adding student.");
    }
        
        Parent.removeAll();
        Parent.add(firstpanel);
        Parent.repaint();
        Parent.revalidate();
    }//GEN-LAST:event_btnAddActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
     String idStr = StudentID.getText().trim(); // <-- use correct field name

    if (idStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter the student ID!");
        return;
    }

    int id;
    try {
        id = Integer.parseInt(idStr);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID must be a number!");
        return;
    }

    try {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM students WHERE idstudent = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            txtFirstName.setText(rs.getString("first_name"));
            txtLastName.setText(rs.getString("last_name"));
            txtAge.setText(String.valueOf(rs.getInt("age")));
            txtEmail.setText(rs.getString("email"));

            // Show in JTable as well
            DefaultTableModel model = (DefaultTableModel) tblStudents.getModel();
            model.setRowCount(0); // clear previous rows
            Object[] row = {
                rs.getInt("idstudent"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getInt("age"),
                rs.getString("email")
            };
            model.addRow(row);

        } else {
            JOptionPane.showMessageDialog(this, "Student not found!");
        }

        rs.close();
        pst.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void txtCourseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCourseNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCourseNameActionPerformed

    private void txtCreditsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCreditsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCreditsActionPerformed

    private void txtCourseIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCourseIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCourseIdActionPerformed

    private void txtCourseDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCourseDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCourseDescriptionActionPerformed

    private void btnShowCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowCourseActionPerformed
         String courseIdText = txtCourseId.getText().trim();
    if (courseIdText.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter a Course ID!");
        return;
    }

    int courseId = 0;
    try {
        courseId = Integer.parseInt(courseIdText);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Course ID must be a number!");
        return;
    }

    String sql = "SELECT * FROM courses WHERE idcourse = ?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setInt(1, courseId);
        ResultSet rs = pst.executeQuery();

        // Clear the table first
        DefaultTableModel model = (DefaultTableModel) tblCourse.getModel();
        model.setRowCount(0);

        // Populate the JTable with the search result
        if (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("idcourse"),
                rs.getString("course_name"),
                rs.getString("description"),
                rs.getInt("credits")
            });
        } else {
            JOptionPane.showMessageDialog(null, "Course not found!");
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error retrieving course.");
    }
    }//GEN-LAST:event_btnShowCourseActionPerformed

    private void StudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StudentIDActionPerformed

    private void btnAddCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCourseActionPerformed
       // Prevent adding if user typed something in the ID field
    if (!txtCourseId.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Do NOT enter Course ID! It will be generated automatically.");
        return;
    }
                                               
    String name = txtCourseName.getText().trim();
    String description = txtCourseDescription.getText().trim();
    int credits;

    // Validate credits
    try {
        credits = Integer.parseInt(txtCredits.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Credits must be a number!");
        return;
    }

    if (name.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Course name cannot be empty!");
        return;
    }

    String sql = "INSERT INTO courses (course_name, description, credits) VALUES (?, ?, ?)";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setString(1, name);
        pst.setString(2, description);
        pst.setInt(3, credits);

        int rows = pst.executeUpdate();
        if (rows > 0) {
            JOptionPane.showMessageDialog(this, "Course added successfully!");
            txtCourseName.setText("");
            txtCourseDescription.setText("");
            txtCredits.setText("");
            showAllCourses(); // refresh JTable
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error adding course: " + e.getMessage());
    }

    
    }//GEN-LAST:event_btnAddCourseActionPerformed

    private void btnUpdateCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCourseActionPerformed
       String idText = txtCourseId.getText().trim();

    if (idText.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter Course ID first!");
        return;
    }

    int courseId;
    try {
        courseId = Integer.parseInt(idText);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Course ID must be a number!");
        return;
    }

    // Check if fields are empty → fetch data from DB
    if (txtCourseName.getText().isEmpty() && txtCourseDescription.getText().isEmpty() && txtCredits.getText().isEmpty()) {
        // First click → fill the fields
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT course_name, description, credits FROM courses WHERE idcourse = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, courseId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txtCourseName.setText(rs.getString("course_name"));
                txtCourseDescription.setText(rs.getString("description"));
                txtCredits.setText(String.valueOf(rs.getInt("credits")));
            } else {
                JOptionPane.showMessageDialog(null, "Course ID not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching course data!");
        }

    } else {
        // Second click → update DB
        String name = txtCourseName.getText().trim();
        String description = txtCourseDescription.getText().trim();
        int credits;

        if (name.isEmpty() || description.isEmpty() || txtCredits.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all fields before updating!");
            return;
        }

        try {
            credits = Integer.parseInt(txtCredits.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Credits must be a number!");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE courses SET course_name = ?, description = ?, credits = ? WHERE idcourse = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, description);
            pst.setInt(3, credits);
            pst.setInt(4, courseId);

            int rows = pst.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Course updated successfully!");
                txtCourseId.setText("");
                txtCourseName.setText("");
                txtCourseDescription.setText("");
                txtCredits.setText("");
                showAllCourses(); // Refresh JTable
            } else {
                JOptionPane.showMessageDialog(null, "Course ID not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error updating course!");
        }
    }
    }//GEN-LAST:event_btnUpdateCourseActionPerformed

    private void btnDeleteCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCourseActionPerformed
        String idText = txtCourseId.getText().trim();
    if (idText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter Course ID to delete!");
        return;
    }

    int courseId;
    try {
        courseId = Integer.parseInt(idText);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Course ID must be a number!");
        return;
    }

    // Show course info before deletion
    String sqlSelect = "SELECT * FROM courses WHERE idcourse = ?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement pstSelect = conn.prepareStatement(sqlSelect)) {

        pstSelect.setInt(1, courseId);
        ResultSet rs = pstSelect.executeQuery();

        if (rs.next()) {
            String courseInfo = "Course ID: " + rs.getInt("idcourse") +
                                "\nName: " + rs.getString("course_name") +
                                "\nDescription: " + rs.getString("description") +
                                "\nCredits: " + rs.getInt("credits");

            int confirm = JOptionPane.showConfirmDialog(this,
                "Do you want to delete this course?\n\n" + courseInfo,
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                String sqlDelete = "DELETE FROM courses WHERE idcourse = ?";
                try (PreparedStatement pstDelete = conn.prepareStatement(sqlDelete)) {
                    pstDelete.setInt(1, courseId);
                    pstDelete.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Course deleted successfully!");
                    txtCourseId.setText("");
                    txtCourseName.setText("");
                    txtCourseDescription.setText("");
                    txtCredits.setText("");
                    refreshCourseTable(); // optional helper method to refresh JTable
                }
            }

        } else {
            JOptionPane.showMessageDialog(this, "Course ID not found!");
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error deleting course: " + e.getMessage());
    }
    }//GEN-LAST:event_btnDeleteCourseActionPerformed

    private void btnEnrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnrollActionPerformed
   // 1️⃣ Get student ID
    String studentIdText = txtEnrollmentID.getText().trim();
    if (studentIdText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a Student ID!");
        return;
    }

    int studentId;
    try {
        studentId = Integer.parseInt(studentIdText);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Student ID must be a number!");
        return;
    }

    // 2️⃣ Get course ID from combo box
    if (enrollcombo.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(this, "Please select a course!");
        return;
    }
    String selectedCourse = enrollcombo.getSelectedItem().toString();
    int courseId = Integer.parseInt(selectedCourse.split(" - ")[0]); // parse the ID

    // 3️⃣ Insert enrollment into database
    String sql = "INSERT INTO enrollments (idstudent, idcourse, enrollment_date) VALUES (?, ?, CURDATE())";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setInt(1, studentId);
        pst.setInt(2, courseId);
        pst.executeUpdate();

        JOptionPane.showMessageDialog(this, "Student enrolled successfully!");

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error enrolling student: " + ex.getMessage());
        return;
    }

    // 4️⃣ Refresh the enrollment table to show the new entry
    jButton3ActionPerformed(null); // reuse the load button code

    }//GEN-LAST:event_btnEnrollActionPerformed

    private void btnDeleteEnrollmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteEnrollmentActionPerformed
    String enrollmentIdText = txtEnrollmentID.getText().trim();
    if (enrollmentIdText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter an Enrollment ID!");
        return;
    }

    int enrollmentId;
    try {
        enrollmentId = Integer.parseInt(enrollmentIdText);
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Enrollment ID must be a number!");
        return;
    }

    try (Connection conn = DBConnection.getConnection()) {

        // 1️⃣ Get enrollment info to show confirmation
        String query = "SELECT s.first_name, s.last_name, c.course_name " +
                       "FROM enrollments e " +
                       "JOIN students s ON e.idstudent = s.idstudent " +
                       "JOIN courses c ON e.idcourse = c.idcourse " +
                       "WHERE e.idenrollment = ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, enrollmentId);
        ResultSet rs = pst.executeQuery();

        if (!rs.next()) {
            JOptionPane.showMessageDialog(this, "Enrollment ID not found!");
            return;
        }

        String studentName = rs.getString("first_name") + " " + rs.getString("last_name");
        String courseName = rs.getString("course_name");

        // 2️⃣ Confirm deletion
        int confirm = JOptionPane.showConfirmDialog(this,
                "Delete enrollment of " + studentName + " in " + courseName + "?",
                "Confirm Delete", JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {
            return; // user canceled
        }

        // 3️⃣ Delete enrollment
        String deleteSql = "DELETE FROM enrollments WHERE idenrollment = ?";
        PreparedStatement deletePst = conn.prepareStatement(deleteSql);
        deletePst.setInt(1, enrollmentId);
        deletePst.executeUpdate();

        JOptionPane.showMessageDialog(this, "Enrollment deleted successfully!");

        // 4️⃣ Refresh the enrollment table
        jButton3ActionPerformed(null); // reuse the load button code

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error deleting enrollment: " + ex.getMessage());
    }
    
    }//GEN-LAST:event_btnDeleteEnrollmentActionPerformed

    private void btnViewEnrollmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewEnrollmentActionPerformed
     int enrollmentId;
    try {
        enrollmentId = Integer.parseInt(txtEnrollmentID.getText());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please enter a valid Enrollment ID.");
        return;
    }

    DefaultTableModel model = (DefaultTableModel) tblEnrollment.getModel();
    model.setRowCount(0);

    String sql = "SELECT e.idenrollment, CONCAT(s.first_name, ' ', s.last_name) AS student_name, " +
                 "c.course_name, e.enrollment_date " +
                 "FROM enrollments e " +
                 "JOIN students s ON e.idstudent = s.idstudent " +
                 "JOIN courses c ON e.idcourse = c.idcourse " +
                 "WHERE e.idenrollment = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setInt(1, enrollmentId);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("idenrollment"),
                rs.getString("student_name"),
                rs.getString("course_name"),
                rs.getString("enrollment_date")
            });
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error fetching enrollment: " + ex.getMessage());
    }

    }//GEN-LAST:event_btnViewEnrollmentActionPerformed

    private void txtEnrollmentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnrollmentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnrollmentIDActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new StudentForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FVIEW;
    private javax.swing.JPanel Parent;
    private javax.swing.JTextField StudentID;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddCourse;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteCourse;
    private javax.swing.JButton btnDeleteEnrollment;
    private javax.swing.JButton btnEnroll;
    private javax.swing.JButton btnShowCourse;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateCourse;
    private javax.swing.JButton btnViewEnrollment;
    private javax.swing.JComboBox<String> enrollcombo;
    private javax.swing.JPanel firstpanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel sas;
    private javax.swing.JPanel secondpanel;
    private javax.swing.JTable tblCourse;
    private javax.swing.JTable tblEnrollment;
    private javax.swing.JTable tblStudents;
    private javax.swing.JPanel thirdpanel;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtCourseDescription;
    private javax.swing.JTextField txtCourseId;
    private javax.swing.JLabel txtCourseId1;
    private javax.swing.JLabel txtCourseId2;
    private javax.swing.JLabel txtCourseId3;
    private javax.swing.JTextField txtCourseName;
    private javax.swing.JTextField txtCredits;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEnrollmentID;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLastName;
    // End of variables declaration//GEN-END:variables

    
}
