package Inheriten_Project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewStudent extends JFrame implements ActionListener {
    JTable table ;
    JScrollPane sp;
    DefaultTableModel tableModel = new DefaultTableModel();
    JButton btnBack = new JButton("Back");
    ViewStudent(){
        setTitle("View Student");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        try{
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/School-emp", "postgres", "P@ssw0rd()SQL");
            String query = "SELECT * FROM Students";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int column = metaData.getColumnCount();
            for (int i = 1; i <= column; i++){
                tableModel.addColumn(metaData.getColumnName(i));
            }
            while (resultSet.next()){
                String[] row = new String[column];
                for (int i = 1; i <= column; i++){
                    row[i-1] = resultSet.getString(i);
                }
                tableModel.addRow(row);
            }
            table = new JTable(tableModel);
            sp = new JScrollPane(table);
            sp.setBounds(20, 20, 550, 450);

        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR: " + e.getMessage());
            e.printStackTrace();
        }
        btnBack.setBounds(250, 500, 100, 50);
        btnBack.setFocusable(false);
        btnBack.addActionListener(this);

        add(btnBack);
        add(sp);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack){
            dispose();
            Dasbord dasbord = new Dasbord();
        }
    }
}
