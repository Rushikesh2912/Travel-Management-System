package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class DeleteDetails extends JFrame implements ActionListener {

    JButton back;
    String username;

    DeleteDetails(String username) {
        this.username = username;
        setBounds(480, 180, 870, 625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

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

        //userid label
        JLabel lblid = new JLabel("id");
        lblid.setBounds(30, 110, 150, 25);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblid);

        //customer userid 
        JLabel labelid = new JLabel();
        labelid.setBounds(220, 110, 150, 25);
        labelid.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        add(labelid);

        //Number label
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 170, 150, 25);
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblnumber);

        //customer Number 
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 170, 150, 25);
        labelnumber.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        add(labelnumber);

        //Name label
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 230, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblname);

        //customer name 
        JLabel labelname = new JLabel();
        labelname.setBounds(220, 230, 150, 25);
        labelname.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        add(labelname);

        //Gender label
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 290, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblgender);

        //customer Gender
        JLabel labelgender = new JLabel();
        labelgender.setBounds(220, 290, 150, 25);
        labelgender.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        add(labelgender);

        //Country label
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(480, 50, 150, 25);
        lblcountry.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblcountry);

        //customer Country
        JLabel labelcountry = new JLabel();
        labelcountry.setBounds(630, 50, 150, 25);
        labelcountry.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        add(labelcountry);

        //Address label
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(480, 110, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbladdress);

        //customer Address
        JLabel labeladdress = new JLabel();
        labeladdress.setBounds(630, 110, 150, 25);
        labeladdress.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        add(labeladdress);

        // PhoneNumber label
        JLabel lblphone = new JLabel("Phone No.");
        lblphone.setBounds(480, 170, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblphone);

        //customer PhoneNumber
        JLabel labelphone = new JLabel();
        labelphone.setBounds(630, 170, 150, 25);
        labelphone.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        add(labelphone);

        //Email label
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(480, 230, 150, 25);
        lblemail.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblemail);

        //customer email
        JLabel labelemail = new JLabel();
        labelemail.setBounds(630, 230, 150, 25);
        labelemail.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        add(labelemail);

        //BAck Button
        back = new JButton("Delete");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350, 350, 100, 25);
        back.addActionListener(this);
        add(back);

        //ImageIcon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20, 400, 600, 200);
        add(image);

        //ImageIcon Replicate
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(600, 400, 600, 200);
        add(image2);

        try {
            Conn c = new Conn();
            String query = "select * from customer where username = '" + username + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelemail.setText(rs.getString("email"));
                labelphone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Conn c = new Conn();
            c.s.executeUpdate("delete from account where username = '" + username + "'");
            c.s.executeUpdate("delete from customer where username = '" + username + "'");
            c.s.executeUpdate("delete from bookpackage where username = '" + username + "'");
            c.s.executeUpdate("delete from bookhotel where username = '" + username + "'");

            JOptionPane.showMessageDialog(null, "Data Deleted Sucessfuly...!");
            setVisible(false);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new DeleteDetails("");
    }
}
