package travel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signUp, forgetPass;
    JTextField tfusername;
    JPasswordField tfpassword;
    JCheckBox Cbox;

    Login() {
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        setBounds(350, 200, 900, 400);
        p1.add(image);    //p1.add bcoz we add above the planel

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 320);
        add(p2);

        //Useraname text
        JLabel Iblusername = new JLabel("Username");
        Iblusername.setBounds(60, 20, 100, 25);
        Iblusername.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(Iblusername);

        //text Box
        tfusername = new JTextField();
        tfusername.setBounds(60, 60, 300, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);

        //PAssword text
        JLabel Iblpassword = new JLabel("Password");
        Iblpassword.setBounds(60, 110, 100, 25);
        Iblpassword.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(Iblpassword);

        //text Box
        tfpassword = new JPasswordField();
        tfpassword.setBounds(60, 150, 300, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

        //eyeSymbol
        Cbox = new JCheckBox("Show Password");
        Cbox.setBounds(60, 180, 150, 50);
        tfpassword.setEchoChar('*');
        Cbox.addActionListener(this);
        p2.add(Cbox);

        //login btn
        login = new JButton("Login");
        login.setBounds(60, 230, 130, 30);
        login.setBackground(new Color(133, 193, 233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133, 192, 233)));
        login.addActionListener(this);
        p2.add(login);

        //SinUp btn
        signUp = new JButton("SingUp");
        signUp.setBounds(230, 230, 130, 30);
        signUp.setBackground(new Color(133, 193, 233));
        signUp.setForeground(Color.WHITE);
        signUp.setBorder(new LineBorder(new Color(133, 192, 233)));
        signUp.addActionListener(this);
        p2.add(signUp);

        //forget password
        forgetPass = new JButton("ForgetPassword");
        forgetPass.setBounds(150, 280, 130, 30);
        forgetPass.setBackground(new Color(133, 193, 233));
        forgetPass.setForeground(Color.WHITE);
        forgetPass.setBorder(new LineBorder(new Color(133, 192, 233)));
        forgetPass.addActionListener(this);
        p2.add(forgetPass);

        //text Trouble login
        JLabel text = new JLabel("Trouble in Login...");
        text.setBounds(300, 280, 130, 30);
        text.setForeground(Color.red);
        p2.add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (Cbox.isSelected()) {
            tfpassword.setEchoChar((char) 0);
        } else {
            tfpassword.setEchoChar('*');
        }
        if (ae.getSource() == login) {
            try {
                String username = tfusername.getText();
                String password = tfpassword.getText();

                String query = "select * from account where username = '" + username + "' AND password = '" + password + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    if (tfusername.getText().trim().isEmpty() && tfpassword.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Fill the Username & Password");
                    } else {
                        setVisible(false);
                        new Loading(username);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username & Password");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == signUp) {
            setVisible(false);
            new SignUp();
        } else if (ae.getSource() == forgetPass) {
            setVisible(false);
            new ForgetPassword();
        }
    }

    public static void main(String[] args) {
        new Login();

    }
}
