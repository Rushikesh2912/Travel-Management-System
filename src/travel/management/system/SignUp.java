package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUp extends JFrame implements ActionListener {

    JButton CreateBtn, BackBtn;
    JTextField Tusername, Tname, TPname, TAnswer;
    Choice Option;

    SignUp() {
        setBounds(350, 200, 900, 360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 500, 400);
        p1.setBackground(new Color(133, 193, 233));
        p1.setLayout(null);
        add(p1);

        //Username
        JLabel username = new JLabel("Username");
        username.setFont(new Font("Tahoma", Font.BOLD, 16));
        username.setBounds(50, 20, 125, 25);
        p1.add(username);

        //USername TExtFeild
        Tusername = new JTextField();
        Tusername.setBounds(220, 20, 170, 23);
        Tusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(Tusername);
        setVisible(true);

        //name
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tahoma", Font.BOLD, 16));
        name.setBounds(50, 60, 125, 25);
        p1.add(name);

        //name TExtFeild
        Tname = new JTextField();
        Tname.setBounds(220, 60, 170, 23);
        Tname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(Tname);

        //Password
        JLabel Passname = new JLabel("Password");
        Passname.setFont(new Font("Tahoma", Font.BOLD, 16));
        Passname.setBounds(50, 100, 125, 25);
        p1.add(Passname);

        //Passname TExtFeild
        TPname = new JTextField();
        TPname.setBounds(220, 100, 170, 23);
        TPname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(TPname);

        //Security Question
        JLabel Security = new JLabel("Security Question");
        Security.setFont(new Font("Tahoma", Font.BOLD, 16));
        Security.setBounds(50, 140, 125, 25);
        p1.add(Security);

        //Choice 
        Option = new Choice();
        Option.add("Your Fav Actor");
        Option.add("Your Pet Name");
        Option.add("Your First School Name");
        Option.add("Your Crush Name");
        Option.add("Your Lucky Number");
        Option.setBounds(220, 140, 170, 30);
        p1.add(Option);

        //Answer
        JLabel Answer = new JLabel("Answer");
        Answer.setFont(new Font("Tahoma", Font.BOLD, 16));
        Answer.setBounds(50, 180, 125, 25);
        p1.add(Answer);

        //Answer TExtFeild
        TAnswer = new JTextField();
        TAnswer.setBounds(220, 180, 170, 23);
        TAnswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(TAnswer);

        //Create Button
        CreateBtn = new JButton("Create");
        CreateBtn.setBackground(Color.WHITE);
        CreateBtn.setForeground(new Color(133, 193, 233));
        CreateBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
        CreateBtn.setBounds(90, 240, 100, 30);
        CreateBtn.addActionListener(this);
        p1.add(CreateBtn);

        //Create Button
        BackBtn = new JButton("Back");
        BackBtn.setBackground(Color.WHITE);
        BackBtn.setForeground(new Color(133, 193, 233));
        BackBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
        BackBtn.setBounds(250, 240, 100, 30);
        BackBtn.addActionListener(this);
        p1.add(BackBtn);

        //Panel 2
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Image = new JLabel(i3);
        Image.setBounds(580, 40, 250, 250);
        add(Image);

        setVisible(true);
    }

    //Event Trigger help of that 
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == CreateBtn) {
            String username = Tusername.getText();
            String name = Tname.getText();
            String password = TPname.getText();
            String question = Option.getSelectedItem();
            String answer = TAnswer.getText();
            if (username.isEmpty() || name.isEmpty() || password.isEmpty() || question.isEmpty() || answer.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Fill the All Details...");
            } else {
                try {

                    String query = "insert into account values('" + username + "','" + name + "','" + password + "','" + question + "','" + answer + "')";

                    Conn c = new Conn();
                    //4. Executing MySql Queries
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Account Create Successfully...");

                    setVisible(false);
                    new Login();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (ae.getSource()
                == BackBtn) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String args[]) {
        new SignUp();
    }
}
