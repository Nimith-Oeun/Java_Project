package Inheriten_Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Teacher extends Staff  {
    JFrame frame = new JFrame();
    JLabel lblTitle = new JLabel("Teacher Form");
    JLabel lblId = new JLabel("ID");
    JLabel lblFistName = new JLabel("Fist Name");
    JLabel lblLastName = new JLabel("Last Name");
    JLabel lblGender = new JLabel("Gender");
    JLabel lblDepartment = new JLabel("Department");
    JLabel lblSalary = new JLabel("Salary");
    JLabel lblSubject = new JLabel("Subject");
    JLabel lblNumberOfClass = new JLabel("<html>Number<br>of Class</html>");
    JTextField txtId = new JTextField();
    JTextField txtFistName = new JTextField();
    JTextField txtLastName = new JTextField();
    JTextField txtGender = new JTextField();
    JTextField txtDepartment = new JTextField();
    JTextField txtSalary = new JTextField();
    JTextField txtSubject = new JTextField();
    JTextField txtNumberOfClass = new JTextField();
    JButton btnInsert = new JButton("Insert");
    JButton btnBack = new JButton("Back");
    private String Subject;
    private String numberOfClass;

    public String getSubject() {
        return Subject;
    }
    public void setSubject(String subject) {
        Subject = subject;
    }
    public String getNumberOfClass() {
        return numberOfClass;
    }
    public void setNumberOfClass(String numberOfClass) {
        this.numberOfClass = numberOfClass;
    }

    Teacher(long id, String FistName, String LastName,String gender, String Department, double Salary, String Subject, String numberOfClass){
        super(id, FistName, LastName,gender, Department, Salary);

        this.Subject = Subject;
        this.numberOfClass = numberOfClass;
    }
    Teacher(){
        frame.setTitle("Insert Teacher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        lblTitle.setBounds(170, 10, 150, 50);
        lblTitle.setFont(new java.awt.Font("Arial", 1, 20));

        lblId.setBounds(50, 80, 95, 25);
        lblId.setFont(new java.awt.Font("Arial", 1, 15));
        txtId.setBounds(145, 80, 250, 35);

        lblFistName.setBounds(50, 120, 95, 25);
        lblFistName.setFont(new java.awt.Font("Arial", 1, 15));
        txtFistName.setBounds(145, 120, 250, 35);

        lblLastName.setBounds(50, 160, 95, 25);
        lblLastName.setFont(new java.awt.Font("Arial", 1, 15));
        txtLastName.setBounds(145, 160, 250, 35);

        lblGender.setBounds(50, 200, 80, 25);
        lblGender.setFont(new java.awt.Font("Arial", 1, 15));
        txtGender.setBounds(145, 200, 250, 35);

        lblDepartment.setBounds(50, 240, 80, 25);
        lblDepartment.setFont(new java.awt.Font("Arial", 1, 15));
        txtDepartment.setBounds(145, 240, 250, 35);

        lblSalary.setBounds(50, 280, 80, 25);
        lblSalary.setFont(new java.awt.Font("Arial", 1, 15));
        txtSalary.setBounds(145, 280, 250, 35);

        lblSubject.setBounds(50, 320, 120, 25);
        lblSubject.setFont(new java.awt.Font("Arial", 1, 15));
        txtSubject.setBounds(145, 320, 250, 35);

        lblNumberOfClass.setBounds(50, 360, 120, 35);
        lblNumberOfClass.setFont(new java.awt.Font("Arial", 1, 15));
        txtNumberOfClass.setBounds(145, 360, 250, 35);

        btnInsert.setBounds(145, 400, 100, 35);
        btnInsert.setFocusable(false);
        btnInsert.addActionListener(this);

        btnBack.setBounds(295, 400, 100, 35);
        btnBack.setFocusable(false);
        btnBack.addActionListener(this);

        frame.add(lblTitle);
        frame.add(lblId);
        frame.add(lblFistName);
        frame.add(lblLastName);
        frame.add(lblGender);
        frame.add(lblDepartment);
        frame.add(lblSalary);
        frame.add(lblSubject);
        frame.add(lblNumberOfClass);
        frame.add(txtId);
        frame.add(txtFistName);
        frame.add(txtLastName);
        frame.add(txtGender);
        frame.add(txtDepartment);
        frame.add(txtSalary);
        frame.add(txtSubject);
        frame.add(txtNumberOfClass);
        frame.add(btnInsert);
        frame.add(btnBack);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack){
            frame.dispose();
            Dasbord dasbord = new Dasbord();
        }
        if(e.getSource() == btnInsert){
            // check error if any field is empty
            if (txtId.getText().isEmpty() || txtFistName.getText().isEmpty() ||
                    txtLastName.getText().isEmpty() || txtGender.getText().isEmpty() ||
                    txtSubject.getText().isEmpty() || txtDepartment.getText().isEmpty() ||
                    txtSalary.getText().isEmpty() || txtNumberOfClass.getText().isEmpty()
            ){
                JOptionPane.showMessageDialog(frame, "Please fill in all fields.");
                return;
            }
            //---------------------------

            long empid = Long.parseLong(txtId.getText());
            String fName = txtFistName.getText();
            String lName = txtLastName.getText();
            String Gd = txtGender.getText();
            String Dp = txtDepartment.getText();
            BigDecimal Sl = BigDecimal.valueOf(Double.parseDouble(txtSalary.getText()));
            String Sb = txtSubject.getText();
            int Nc = Integer.parseInt(txtNumberOfClass.getText());

            Connection connection = null;
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/School-emp", "postgres", "P@ssw0rd()SQL");
                String query = "INSERT INTO Teachers VALUES(?,?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setLong(1, empid);
                preparedStatement.setString(2, fName);
                preparedStatement.setString(3, lName);
                preparedStatement.setString(4, Gd);
                preparedStatement.setString(5, Dp);
                preparedStatement.setBigDecimal(6, Sl);
                preparedStatement.setString(7, Sb);
                preparedStatement.setInt(8, Nc);
                int rowAffected = preparedStatement.executeUpdate();
                if(rowAffected > 0){
                    JOptionPane.showMessageDialog(frame, "Data Inserted Successfully");
                    frame.dispose();
                    Dasbord dasbord = new Dasbord();
                } else {
                    JOptionPane.showMessageDialog(frame, "Data Not Inserted");
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "ERROR: " + ex.getMessage());
                ex.printStackTrace();
            }finally {
                if (connection != null){
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }

        }
    }
}
