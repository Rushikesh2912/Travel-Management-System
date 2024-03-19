package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewPackage extends JFrame implements ActionListener {

    JButton back;

    ViewPackage(String username) {
        setBounds(420, 200, 900, 450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("VIEW PACAKGE & DETAILS");
        text.setFont(new Font("Tohoma", Font.BOLD, 20));
        text.setBounds(60, 0, 300, 30);
        add(text);

        //username label
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblusername);

        //customer username 
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        labelusername.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        add(labelusername);

        //Package label
        JLabel lblid = new JLabel("Package");
        lblid.setBounds(30, 90, 150, 25);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblid);

        //customer userid 
        JLabel labelpackage = new JLabel();
        labelpackage.setBounds(220, 90, 150, 25);
        labelpackage.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        add(labelpackage);

        //Total Persons label
        JLabel lblnumber = new JLabel("Total Persons");
        lblnumber.setBounds(30, 130, 150, 25);
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblnumber);

        //customer Number 
        JLabel labelperson = new JLabel();
        labelperson.setBounds(220, 130, 150, 25);
        labelperson.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        add(labelperson);

        //Name label
        JLabel lblname = new JLabel("id");
        lblname.setBounds(30, 170, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblname);

        //customer name 
        JLabel labelid = new JLabel();
        labelid.setBounds(220, 170, 150, 25);
        labelid.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        add(labelid);

        //Gender label
        JLabel lblgender = new JLabel("Number");
        lblgender.setBounds(30, 210, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblgender);

        //customer Gender
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 210, 150, 25);
        labelnumber.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        add(labelnumber);

        //Country label
        JLabel lblcountry = new JLabel("Phone");
        lblcountry.setBounds(30, 250, 150, 25);
        lblcountry.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblcountry);

        //customer Country
        JLabel labelphone = new JLabel();
        labelphone.setBounds(220, 250, 150, 25);
        labelphone.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        add(labelphone);

        //Price label
        JLabel lbladdress = new JLabel("Price");
        lbladdress.setBounds(30, 290, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbladdress);

        //customer Address
        JLabel labelprice = new JLabel();
        labelprice.setBounds(220, 290, 150, 25);
        labelprice.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        add(labelprice);

        //Back Button
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130, 360, 100, 25);
        back.addActionListener(this);
        add(back);

        //ImageIcon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookeddetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 20, 600, 400);
        add(image);

        try {
            Conn c = new Conn();
            String query = "select * from bookpackage where username = '" + username + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpackage.setText(rs.getString("package"));
                labelprice.setText(rs.getString("price"));
                labelperson.setText(rs.getString("person"));
                labelphone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String args[]) {
        new ViewPackage("Prasad11");
    }
}
