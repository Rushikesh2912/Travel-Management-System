package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCustomer extends JFrame implements ActionListener {

    JLabel labelusername, labelname;
    JComboBox comboid;
    JTextField Tfnumber, Tfcountry, Tfaddress, Tfemail, Tfphone, Tfid, Tfgender;
    JRadioButton rmale, rfemale;
    JButton add, back;

    UpdateCustomer(String username) {
        setBounds(500, 250, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        JLabel text = new JLabel("UPDATE CUSTOMER DEATILS");
        text.setFont(new Font("Tohoma", Font.PLAIN, 20));
        text.setBounds(50, 0, 300, 25);
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        //Username
        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        //id
        JLabel iblid = new JLabel("id");
        iblid.setBounds(30, 90, 150, 25);
        add(iblid);

        //Drop down 
        Tfid = new JTextField();
        Tfid.setBounds(220, 90, 150, 25);
        add(Tfid);

        //Number
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 130, 150, 25);
        add(lblnumber);

        //Number TextFeild
        Tfnumber = new JTextField();
        Tfnumber.setBounds(220, 130, 150, 25);
        add(Tfnumber);

        //Name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 170, 150, 25);
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(220, 170, 150, 25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 210, 150, 25);
        add(lblgender);

        //Gender Change
        Tfgender = new JTextField();
        Tfgender.setBounds(220, 210, 150, 25);
        add(Tfgender);

        //Country
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(30, 250, 150, 25);
        add(lblcountry);

        //Country TextFeild
        Tfcountry = new JTextField();
        Tfcountry.setBounds(220, 250, 150, 25);
        add(Tfcountry);

        //Address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30, 290, 150, 25);
        add(lbladdress);

        //Address textFeild
        Tfaddress = new JTextField();
        Tfaddress.setBounds(220, 290, 150, 25);
        add(Tfaddress);

        //Email
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(30, 330, 150, 25);
        add(lblemail);

        //Email TextField
        Tfemail = new JTextField();
        Tfemail.setBounds(220, 330, 150, 25);
        add(Tfemail);

        //Phone Number
        JLabel lblphone = new JLabel("Phone No.");
        lblphone.setBounds(30, 370, 150, 25);
        add(lblphone);

        //Phone Number TetxtField
        Tfphone = new JTextField();
        Tfphone.setBounds(220, 370, 150, 25);
        add(Tfphone);

        //Add Button
        add = new JButton("Update");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70, 430, 100, 25);
        add.addActionListener(this);
        add(add);

        //back Button
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220, 430, 100, 25);
        back.addActionListener(this);
        add(back);

        //Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 90, 250, 350);
        add(image);

        //Database Fetch
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '" + username + "'");
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                Tfid.setText(rs.getString("id"));
                Tfnumber.setText(rs.getString("number"));
                Tfgender.setText(rs.getString("gender"));
                Tfcountry.setText(rs.getString("country"));
                Tfphone.setText(rs.getString("phone"));
                Tfemail.setText(rs.getString("email"));
                Tfaddress.setText(rs.getString("address"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String username = labelusername.getText();
            String id = Tfid.getText();
            String number = Tfnumber.getText();
            String name = labelname.getText();
            String gender = Tfgender.getText();
            String country = Tfcountry.getText();
            String address = Tfaddress.getText();
            String email = Tfemail.getText();
            String phone = Tfphone.getText();
            if (labelusername.getText().trim().isEmpty() || Tfnumber.getText().trim().isEmpty() || labelname.getText().trim().isEmpty() || Tfcountry.getText().trim().isEmpty() || Tfaddress.getText().trim().isEmpty() || Tfemail.getText().trim().isEmpty() || Tfphone.getText().trim().isEmpty() || Tfgender.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Fill the All Deatils");
            } else {
                try {
                    Conn c = new Conn();
                    String query = "update customer set username = '" + username + "', id = '" + id + "', number = '" + number + "', name = '" + name + "', gender = '" + gender + "', country = '" + country + "', address = '" + address + "', email = '" + email + "', phone = '" + phone + "' where username = '" + username + "'";
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Customer Details Update Successfully...");
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String args[]) {
        new UpdateCustomer("");
    }
}
