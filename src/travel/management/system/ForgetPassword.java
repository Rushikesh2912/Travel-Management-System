package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener {

    JTextField Tusername, Tname, Tquestion, Tanswer, Tpassword;
    JButton search, retrive, back;

    ForgetPassword() {
        setBounds(350, 200, 850, 360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Image = new JLabel(i3);
        Image.setBounds(580, 70, 200, 200);
        add(Image);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 500, 270);
        add(p1);

        //Username
        JLabel username = new JLabel("Username");
        username.setBounds(40, 20, 100, 20);
        username.setFont(new Font("Tohoma", Font.BOLD, 20));
        p1.add(username);

        //Username TextFeild
        Tusername = new JTextField();
        Tusername.setBounds(210, 20, 150, 25);
        Tusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(Tusername);

        //Search Btn for Name
        search = new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(380, 20, 100, 25);
        search.addActionListener(this);
        p1.add(search);

        //name
        JLabel name = new JLabel("Name");
        name.setBounds(40, 60, 100, 25);
        name.setFont(new Font("Tohoma", Font.BOLD, 20));
        p1.add(name);

        //name TextFeild
        Tname = new JTextField();
        Tname.setBounds(210, 60, 150, 25);
        Tname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(Tname);

        //Seruity Question
        JLabel question = new JLabel("Security Question");
        question.setBounds(40, 100, 150, 25);
        question.setFont(new Font("Tohoma", Font.BOLD, 20));
        p1.add(question);

        //Question TextFeild
        Tquestion = new JTextField();
        Tquestion.setBounds(210, 100, 150, 25);
        Tquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(Tquestion);

        //Answer
        JLabel answer = new JLabel("Answer");
        answer.setBounds(40, 140, 150, 25);
        answer.setFont(new Font("Tohoma", Font.BOLD, 20));
        p1.add(answer);

        //Question TextFeild
        Tanswer = new JTextField();
        Tanswer.setBounds(210, 140, 150, 25);
        Tanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(Tanswer);

        //Retrive Btn for Answer
        retrive = new JButton("Retrive");
        retrive.setBackground(Color.GRAY);
        retrive.setForeground(Color.WHITE);
        retrive.setBounds(380, 140, 100, 25);
        retrive.addActionListener(this);
        p1.add(retrive);

        //password
        JLabel password = new JLabel("Password");
        password.setBounds(40, 180, 150, 25);
        password.setFont(new Font("Tohoma", Font.BOLD, 20));
        p1.add(password);

        //password TextFeild
        Tpassword = new JTextField();
        Tpassword.setBounds(210, 180, 150, 25);
        Tpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(Tpassword);

        //BackBtn
        back = new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(150, 230, 100, 25);
        back.addActionListener(this);
        p1.add(back);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            try {
                String query = "select * from account where username = '" + Tusername.getText() + "'";
                Conn c = new Conn();

                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    Tname.setText(rs.getString("name"));
                    Tquestion.setText(rs.getString("security"));

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource()
                == retrive) {
            try {
                String query = "select * from account where answer = '" + Tanswer.getText() + "' AND username = '" + Tusername.getText() + "'";
                Conn c = new Conn();

                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    Tpassword.setText(rs.getString("password"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String args[]) {
        new ForgetPassword();
    }
}
