package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener {

    Choice cpackage;
    JLabel labelusername, labelid, labelnumber, labelphone, labelprize;
    JTextField Tfperson;
    JButton checkPrize, bookpackage, back;
    String username;

    BookPackage(String username) {
        this.username = username;
        setBounds(350, 200, 1100, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("BOOK PACKAGE");
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
        JLabel lblselectPackage = new JLabel("Select Package");
        lblselectPackage.setFont(new Font("Tohoma", Font.PLAIN, 16));
        lblselectPackage.setBounds(40, 110, 150, 20);
        lblselectPackage.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblselectPackage);

        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronzse Package");
        cpackage.setBounds(250, 110, 180, 20);
        add(cpackage);

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

        //id label
        JLabel lblid = new JLabel("id");
        lblid.setFont(new Font("Tohoma", Font.PLAIN, 16));
        lblid.setBounds(40, 190, 150, 20);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblid);

        //id label 
        labelid = new JLabel();
        labelid.setBounds(250, 190, 200, 25);
        labelid.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        add(labelid);

        // NUmber label
        JLabel lblpersons = new JLabel("Number");
        lblpersons.setFont(new Font("Tohoma", Font.PLAIN, 16));
        lblpersons.setBounds(40, 230, 150, 25);
        lblpersons.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblpersons);

        //Number Label
        labelnumber = new JLabel();
        labelnumber.setBounds(250, 230, 150, 25);
        labelnumber.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        add(labelnumber);

        // Phone label
        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tohoma", Font.PLAIN, 16));
        lblphone.setBounds(40, 270, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblphone);

        //Pnone 
        labelphone = new JLabel();
        labelphone.setBounds(250, 270, 200, 25);
        labelphone.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 16));
        add(labelphone);

        // Phone label
        JLabel lblprize = new JLabel("Total Prize");
        lblprize.setFont(new Font("Tohoma", Font.PLAIN, 16));
        lblprize.setBounds(40, 310, 150, 25);
        lblprize.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblprize);

        //Pnone 
        labelprize = new JLabel();
        labelprize.setBounds(250, 310, 200, 25);
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
        checkPrize.setBounds(60, 380, 120, 25);
        checkPrize.addActionListener(this);
        add(checkPrize);

        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200, 380, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(440, 380, 120, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(550, 50, 500, 300);
        add(l12);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkPrize) {
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if (pack.equals("Gold Package")) {
                cost += 12000;
            } else if (pack.equals("Silver Package")) {
                cost += 25000;
            } else {
                cost += 32000;
            }

            int person = Integer.parseInt(Tfperson.getText());
            cost = cost * person;
            labelprize.setText("Rs " + cost);
        } else if (ae.getSource() == bookpackage) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values('" + labelusername.getText() + "', '" + cpackage.getSelectedItem() + "', '" + Tfperson.getText() + "', '" + labelid.getText() + "', '" + labelnumber.getText() + "', '" + labelphone.getText() + "', '" + labelprize.getText() + "')");

                JOptionPane.showMessageDialog(null, "Pacakage Book Successfully...");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String args[]) {
        new BookPackage("");
    }
}
