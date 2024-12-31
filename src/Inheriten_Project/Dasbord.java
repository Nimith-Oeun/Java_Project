package Inheriten_Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dasbord implements ActionListener {
    JFrame frame = new JFrame();
    JLabel lblTitle = new JLabel("Dasbord Menu");
    JButton btnStaff = new JButton("Insert Staff");
    JButton btnTeacher = new JButton("Insert Teacher");
    JButton btnStudent = new JButton("Insert Student");
    JButton btnViewStaff = new JButton("View Staff");
    JButton btnViewTeacher = new JButton("View Teacher");
    JButton btnViewStudent = new JButton("View Student");
    Dasbord(){
        frame.setTitle("Dasbord Menu");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        lblTitle.setBounds(170, 10, 150, 50);
        lblTitle.setFont(new java.awt.Font("Arial", 1, 20));


        btnStaff.setBounds(100, 80, 120, 50);
        btnStaff.setFocusable(false);
        btnStaff.addActionListener(this);

        btnViewStaff.setBounds(250, 80, 120, 50);
        btnViewStaff.setFocusable(false);
        btnViewStaff.addActionListener(this);

        btnTeacher.setBounds(100, 140, 120, 50);
        btnTeacher.setFocusable(false);
        btnTeacher.addActionListener(this);

        btnViewTeacher.setBounds(250, 140, 120, 50);
        btnViewTeacher.setFocusable(false);
        btnViewTeacher.addActionListener(this);

        btnStudent.setBounds(100, 200, 120, 50);
        btnStudent.setFocusable(false);
        btnStudent.addActionListener(this);

        btnViewStudent.setBounds(250, 200, 120, 50);
        btnViewStudent.setFocusable(false);
        btnViewStudent.addActionListener(this);

        frame.add(lblTitle);
        frame.add(btnStaff);
        frame.add(btnViewStaff);
        frame.add(btnTeacher);
        frame.add(btnViewTeacher);
        frame.add(btnStudent);
        frame.add(btnViewStudent);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btnStaff) {
                Staff staff = new Staff();
                frame.dispose();
            }
            if (e.getSource()==btnTeacher){
                Teacher teacher = new Teacher();
                frame.dispose();
            }
            if (e.getSource()==btnStudent){
                Student student = new Student();
                frame.dispose();
            }
            if (e.getSource()==btnViewStaff){
                ViewStaff viewStaff = new ViewStaff();
                frame.dispose();
            }
            if (e.getSource()==btnViewTeacher){
                ViewTeachers viewTeachers = new ViewTeachers();
                frame.dispose();
            }
            if (e.getSource()==btnViewStudent){
                ViewStudent viewStudent = new ViewStudent();
                frame.dispose();
            }
    }
}
