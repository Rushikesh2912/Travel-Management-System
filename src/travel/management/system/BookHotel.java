package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener {

    Choice chotel, cac, cfood;
    JLabel labelusername, labelid, labelnumber, labelphone, labelprize;
    JTextField Tfdays, Tfperson;
    JButton checkPrize, bookpackage, back;
    String username;

    BookHotel(String username) {
        this.username = username;
        setBounds(350, 200, 1100, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("BOOK HOTEL");
        text.setFont(new Font("Tohoma", Font.ROMAN_BASELINE, 20));
        text.setBounds(100, 10, 200, 30);
        add(text);

        //username label
        JLabel lblusername = new JLabel("Username");
        text.setFont(new Font("Tohoma", Font.PLAIN, 16));
        lblusername.setBounds(40, 70, 100, 20);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblusername);

        //customer username 
        labelusername = new JLabel();
        labelusername.setBounds(250, 70, 150, 20);
        labelusername.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        add(labelusername);

        //selectPackage label
        JLabel lblselectPackage = new JLabel("Select Hotel");
        lblselectPackage.setFont(new Font("Tohoma", Font.PLAIN, 16));
        lblselectPackage.setBounds(40, 110, 150, 20);
        lblselectPackage.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblselectPackage);

        chotel = new Choice();
        chotel.setBounds(250, 110, 180, 20);
        add(chotel);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while (rs.next()) {
                chotel.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Number label
        JLabel lblTperson = new JLabel("Total Person");
        lblTperson.setFont(new Font("Tohoma", Font.PLAIN, 16));
        lblTperson.setBounds(40, 150, 150, 25);
        lblTperson.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblTperson);

        //persons TextFoield
        Tfperson = new JTextField();
        Tfperson.setBounds(250, 150, 100, 25);
        add(Tfperson);

        //Number label
        JLabel lbldays = new JLabel("NO. Of Days");
        lbldays.setFont(new Font("Tohoma", Font.PLAIN, 16));
        lbldays.setBounds(40, 190, 150, 25);
        lbldays.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbldays);

        //persons TextFoield
        Tfdays = new JTextField();
        Tfdays.setBounds(250, 190, 100, 25);
        add(Tfdays);

        JLabel lblac = new JLabel("AC/Non-AC");
        lblac.setFont(new Font("Tohoma", Font.PLAIN, 16));
        lblac.setBounds(40, 230, 150, 25);
        lblac.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblac);

        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250, 230, 180, 20);
        add(cac);

        JLabel lblfood = new JLabel("Food Include");
        lblfood.setFont(new Font("Tohoma", Font.PLAIN, 16));
        lblfood.setBounds(40, 270, 150, 25);
        lblfood.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblfood);

        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250, 270, 180, 20);
        add(cfood);

        //id label
        JLabel lblid = new JLabel("id");
        lblid.setFont(new Font("Tohoma", Font.PLAIN, 16));
        lblid.setBounds(40, 310, 150, 20);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblid);

        //id label 
        labelid = new JLabel();
        labelid.setBounds(250, 310, 200, 25);
        labelid.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        add(labelid);

        // NUmber label
        JLabel lblpersons = new JLabel("Number");
        lblpersons.setFont(new Font("Tohoma", Font.PLAIN, 16));
        lblpersons.setBounds(40, 350, 150, 25);
        lblpersons.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblpersons);

        //Number Label
        labelnumber = new JLabel();
        labelnumber.setBounds(250, 350, 150, 25);
        labelnumber.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        add(labelnumber);

        // Phone label
        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tohoma", Font.PLAIN, 16));
        lblphone.setBounds(40, 390, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblphone);

        //Pnone 
        labelphone = new JLabel();
        labelphone.setBounds(250, 390, 200, 25);
        labelphone.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        add(labelphone);

        // Phone label
        JLabel lblprize = new JLabel("Total Prize");
        lblprize.setFont(new Font("Tohoma", Font.PLAIN, 16));
        lblprize.setBounds(40, 430, 150, 25);
        lblprize.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblprize);

        //Pnone 
        labelprize = new JLabel();
        labelprize.setBounds(250, 430, 200, 25);
        labelprize.setForeground(Color.red);
        labelprize.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(labelprize);
        try {
            Conn c = new Conn();
            String query = "select * from customer where username = '" + username + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        checkPrize = new JButton("Check Prize");
        checkPrize.setBackground(Color.BLACK);
        checkPrize.setForeground(Color.WHITE);
        checkPrize.setBounds(60, 490, 120, 25);
        checkPrize.addActionListener(this);
        add(checkPrize);

        bookpackage = new JButton("Book Hotel");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200, 490, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 490, 120, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(500, 50, 600, 400);
        add(l12);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkPrize) {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name = '" + chotel.getSelectedItem() + "'");
                while (rs.next()) {
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodinclude"));
                    int ac = Integer.parseInt(rs.getString("acroom"));

                    int persons = Integer.parseInt(Tfperson.getText());
                    int days = Integer.parseInt(Tfdays.getText());

                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();
                    if (persons * days > 0) {
                        int total = 0;
                        total += acselected.equals("AC") ? ac : 0;
                        total += foodselected.equals("Yes") ? food : 0;
                        total += cost;
                        total = total * persons * days;
                        labelprize.setText("Rs " + total);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please Enter the a Valid Number");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == bookpackage) {
            if (Tfdays.getText().trim().isEmpty() || Tfperson.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Fill the All Deatils");
            } else {
                try {
                    Conn c = new Conn();
                    c.s.executeUpdate("insert into bookhotel values('" + labelusername.getText() + "', '" + chotel.getSelectedItem() + "', '" + Tfperson.getText() + "', '" + Tfdays.getText() + "', '" + cac.getSelectedItem() + "', '" + cfood.getSelectedItem() + "', '" + labelid.getText() + "', '" + labelnumber.getText() + "', '" + labelphone.getText() + "', '" + labelprize.getText() + "')");

                    JOptionPane.showMessageDialog(null, "Hotel Booked Successfully...");
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
        new BookHotel("");
    }
}
