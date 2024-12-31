package Inheriten_Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Student implements ActionListener {

    JFrame frame = new JFrame();
    JLabel lblTitle = new JLabel("Student Form");
    JLabel lblId = new JLabel("ID");
    JLabel lblFistName = new JLabel("Fist Name");
    JLabel lblLastName = new JLabel("Last Name");
    JLabel lblGender = new JLabel("Gender");
    JLabel lblYear = new JLabel("Year");
    JLabel lblsubject = new JLabel("Subject");
    JTextField txtId = new JTextField();
    JTextField txtFistName = new JTextField();
    JTextField txtLastName = new JTextField();
    JTextField txtGender = new JTextField();
    JTextField txtYear = new JTextField();
    JTextField txtsubject = new JTextField();
    JButton btnInsert = new JButton("Insert");
    JButton btnBack = new JButton("Back");

    private long id;
    private String FistName;
    private String LastName;
    private String gender;
    private String Year;
    private String subject;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFistName() {
        return FistName;
    }
    public void setFistName(String fistName) {
        FistName = fistName;
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public String getYear() {
        return Year;
    }
    public void setYear(String year) {
        Year = year;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    Student(long id, String FistName, String LastName,String gender, String Year, String subject){
        this.id = id;
        this.FistName = FistName;
        this.LastName = LastName;
        this.gender = gender;
        this.Year = Year;
        this.subject = subject;
    }
    Student(){
        frame.setTitle("Student");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

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

        lblYear.setBounds(50, 240, 80, 25);
        lblYear.setFont(new java.awt.Font("Arial", 1, 15));
        txtYear.setBounds(145, 240, 250, 35);

        lblsubject.setBounds(50, 280, 80, 25);
        lblsubject.setFont(new java.awt.Font("Arial", 1, 15));
        txtsubject.setBounds(145, 280, 250, 35);

        btnInsert.setBounds(145, 350, 100, 35);
        btnInsert.setFocusable(false);
        btnInsert.addActionListener(this);

        btnBack.setBounds(295, 350, 100, 35);
        btnBack.setFocusable(false);
        btnBack.addActionListener(this);

        frame.add(lblTitle);
        frame.add(lblId);
        frame.add(lblFistName);
        frame.add(lblLastName);
        frame.add(lblGender);
        frame.add(lblYear);
        frame.add(lblsubject);
        frame.add(txtId);
        frame.add(txtFistName);
        frame.add(txtLastName);
        frame.add(txtGender);
        frame.add(txtYear);
        frame.add(txtsubject);
        frame.add(btnInsert);
        frame.add(btnBack);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnBack){
            frame.dispose();
            Dasbord dasbord = new Dasbord();
        }
        if(e.getSource() == btnInsert){
            // check error if any field is empty
            if (txtId.getText().isEmpty() || txtFistName.getText().isEmpty() ||
                    txtLastName.getText().isEmpty() || txtGender.getText().isEmpty() ||
                    txtsubject.getText().isEmpty() || txtYear.getText().isEmpty()
            ){
                JOptionPane.showMessageDialog(frame, "Please fill in all fields.");
                return;
            }
            //---------------------------
            long empid = Long.parseLong(txtId.getText());
            String fName = txtFistName.getText();
            String lName = txtLastName.getText();
            String Gd = txtGender.getText();
            String sb = txtsubject.getText();
            int years = Integer.parseInt(txtYear.getText());
            Connection connection = null;
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/School-emp", "postgres", "P@ssw0rd()SQL");
                String query = "INSERT INTO Students VALUES(?,?,?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setLong(1, empid);
                preparedStatement.setString(2, fName);
                preparedStatement.setString(3, lName);
                preparedStatement.setString(4, Gd);
                preparedStatement.setString(5, sb);
                preparedStatement.setInt(6, years);
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
