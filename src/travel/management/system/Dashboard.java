package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    String username;
    JButton addPersonalDeatils, viewPersonalDeatils, updatePersonalDeatils, deletePersonalDeatils, checkPackages, bookPackage, viewPackage,
            viewHotel, Destination, bookHotel, viewBookHotel, Payment, Calculator, Notepad, About, logout;

    Dashboard(String username) {
        this.username = username;
//  setBounds(0, 0, 1600, 1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        //Panel header
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 1600, 60);
        add(p1);

        logout = new JButton("logout");
        logout.setBounds(1400, 13, 100, 30);
        logout.setBackground(new Color(0, 0, 102));
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Tohoma", Font.PLAIN, 20));
        logout.addActionListener(this);
        p1.add(logout);
        //header Image logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);

        //Dashboard Name
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tohoma", Font.BOLD, 30));
        p1.add(heading);

        //Button Pnel Left Side
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 102));
        p2.setBounds(0, 60, 300, 900);
        add(p2);

        //Add Personal Deatils Buttons
        addPersonalDeatils = new JButton("Add Personal Deatils");
        addPersonalDeatils.setBounds(0, 0, 300, 50);
        addPersonalDeatils.setBackground(new Color(0, 0, 102));
        addPersonalDeatils.setForeground(Color.WHITE);
        addPersonalDeatils.setFont(new Font("Tohoma", Font.PLAIN, 20));
        addPersonalDeatils.setMargin(new Insets(0, 0, 0, 70));
        addPersonalDeatils.addActionListener(this);
        p2.add(addPersonalDeatils);

        //Update Person Deatils Buttons
        updatePersonalDeatils = new JButton("Upadate Personal Deatils");
        updatePersonalDeatils.setBounds(0, 50, 300, 50);
        updatePersonalDeatils.setBackground(new Color(0, 0, 102));
        updatePersonalDeatils.setForeground(Color.WHITE);
        updatePersonalDeatils.setFont(new Font("Tohoma", Font.PLAIN, 20));
        updatePersonalDeatils.setMargin(new Insets(0, 0, 0, 35));
        updatePersonalDeatils.addActionListener(this);
        p2.add(updatePersonalDeatils);

        //View Personal Deatils Buttons
        viewPersonalDeatils = new JButton("View Deatils");
        viewPersonalDeatils.setBounds(0, 100, 300, 50);
        viewPersonalDeatils.setBackground(new Color(0, 0, 102));
        viewPersonalDeatils.setForeground(Color.WHITE);
        viewPersonalDeatils.setFont(new Font("Tohoma", Font.PLAIN, 20));
        viewPersonalDeatils.setMargin(new Insets(0, 0, 0, 150));
        viewPersonalDeatils.addActionListener(this);
        p2.add(viewPersonalDeatils);

        //Delete Personal Deatils Buttons
        deletePersonalDeatils = new JButton("Delete Personal Deatils");
        deletePersonalDeatils.setBounds(0, 150, 300, 50);
        deletePersonalDeatils.setBackground(new Color(0, 0, 102));
        deletePersonalDeatils.setForeground(Color.WHITE);
        deletePersonalDeatils.setFont(new Font("Tohoma", Font.PLAIN, 20));
        deletePersonalDeatils.setMargin(new Insets(0, 0, 0, 50));
        deletePersonalDeatils.addActionListener(this);
        p2.add(deletePersonalDeatils);

        //Check Pacakge Buttons
        checkPackages = new JButton("Check Packages");
        checkPackages.setBounds(0, 200, 300, 50);
        checkPackages.setBackground(new Color(0, 0, 102));
        checkPackages.setForeground(Color.WHITE);
        checkPackages.setFont(new Font("Tohoma", Font.PLAIN, 20));
        checkPackages.setMargin(new Insets(0, 0, 0, 110));
        checkPackages.addActionListener(this);
        p2.add(checkPackages);

        //Book Pacakge Buttons
        bookPackage = new JButton("Book Package");
        bookPackage.setBounds(0, 250, 300, 50);
        bookPackage.setBackground(new Color(0, 0, 102));
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setFont(new Font("Tohoma", Font.PLAIN, 20));
        bookPackage.setMargin(new Insets(0, 0, 0, 130));
        bookPackage.addActionListener(this);
        p2.add(bookPackage);

        //View Pacakge Buttons
        viewPackage = new JButton("View Package");
        viewPackage.setBounds(0, 300, 300, 50);
        viewPackage.setBackground(new Color(0, 0, 102));
        viewPackage.setForeground(Color.WHITE);
        viewPackage.setFont(new Font("Tohoma", Font.PLAIN, 20));
        viewPackage.setMargin(new Insets(0, 0, 0, 130));
        viewPackage.addActionListener(this);
        p2.add(viewPackage);

        //View Hotels Buttons
        viewHotel = new JButton("View Hotel");
        viewHotel.setBounds(0, 350, 300, 50);
        viewHotel.setBackground(new Color(0, 0, 102));
        viewHotel.setForeground(Color.WHITE);
        viewHotel.setFont(new Font("Tohoma", Font.PLAIN, 20));
        viewHotel.setMargin(new Insets(0, 0, 0, 158));
        viewHotel.addActionListener(this);
        p2.add(viewHotel);

        //book Hotel Buttons
        bookHotel = new JButton("Book Hotel");
        bookHotel.setBounds(0, 400, 300, 50);
        bookHotel.setBackground(new Color(0, 0, 102));
        bookHotel.setForeground(Color.WHITE);
        bookHotel.setFont(new Font("Tohoma", Font.PLAIN, 20));
        bookHotel.setMargin(new Insets(0, 0, 0, 158));
        bookHotel.addActionListener(this);
        p2.add(bookHotel);

        //View book Hotel Buttons
        viewBookHotel = new JButton("View Booked Hotel");
        viewBookHotel.setBounds(0, 450, 300, 50);
        viewBookHotel.setBackground(new Color(0, 0, 102));
        viewBookHotel.setForeground(Color.WHITE);
        viewBookHotel.setFont(new Font("Tohoma", Font.PLAIN, 20));
        viewBookHotel.setMargin(new Insets(0, 0, 0, 90));
        viewBookHotel.addActionListener(this);
        p2.add(viewBookHotel);

        //Destination Buttons
        Destination = new JButton("Destination");
        Destination.setBounds(0, 500, 300, 50);
        Destination.setBackground(new Color(0, 0, 102));
        Destination.setForeground(Color.WHITE);
        Destination.setFont(new Font("Tohoma", Font.PLAIN, 20));
        Destination.setMargin(new Insets(0, 0, 0, 160));
        Destination.addActionListener(this);
        p2.add(Destination);

        //Payment Buttons
        Payment = new JButton("Payment");
        Payment.setBounds(0, 550, 300, 50);
        Payment.setBackground(new Color(0, 0, 102));
        Payment.setForeground(Color.WHITE);
        Payment.setFont(new Font("Tohoma", Font.PLAIN, 20));
        Payment.setMargin(new Insets(0, 0, 0, 180));
        Payment.addActionListener(this);
        p2.add(Payment);

        //Calculator Buttons
        Calculator = new JButton("Calculator");
        Calculator.setBounds(0, 600, 300, 50);
        Calculator.setBackground(new Color(0, 0, 102));
        Calculator.setForeground(Color.WHITE);
        Calculator.setFont(new Font("Tohoma", Font.PLAIN, 20));
        Calculator.setMargin(new Insets(0, 0, 0, 170));
        Calculator.addActionListener(this);
        p2.add(Calculator);

        //Notepad Buttons
        Notepad = new JButton("Notepad");
        Notepad.setBounds(0, 650, 300, 50);
        Notepad.setBackground(new Color(0, 0, 102));
        Notepad.setForeground(Color.WHITE);
        Notepad.setFont(new Font("Tohoma", Font.PLAIN, 20));
        Notepad.setMargin(new Insets(0, 0, 0, 185));
        Notepad.addActionListener(this);
        p2.add(Notepad);

        //About Buttons
        About = new JButton("About");
        About.setBounds(0, 700, 300, 50);
        About.setBackground(new Color(0, 0, 102));
        About.setForeground(Color.WHITE);
        About.setFont(new Font("Tohoma", Font.PLAIN, 20));
        About.setMargin(new Insets(0, 0, 0, 210));
        About.addActionListener(this);
        p2.add(About);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 0, 1650, 1000);
        add(image);

        JLabel text = new JLabel("Travel And Tourism Management System");
        text.setBounds(400, 70, 1200, 70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Railway", Font.PLAIN, 55));
        image.add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addPersonalDeatils) {
            new AddCustomer(username);
        } else if (ae.getSource() == viewPersonalDeatils) {
            new ViewCustomer(username);
        } else if (ae.getSource() == updatePersonalDeatils) {
            new UpdateCustomer(username);
        } else if (ae.getSource() == checkPackages) {
            new CheckPackage();
        } else if (ae.getSource() == bookPackage) {
            new BookPackage(username);
        } else if (ae.getSource() == viewPackage) {
            new ViewPackage(username);
        } else if (ae.getSource() == viewHotel) {
            new CheckHotel();
        } else if (ae.getSource() == Destination) {
            new Destination();
        } else if (ae.getSource() == bookHotel) {
            new BookHotel(username);
        } else if (ae.getSource() == viewBookHotel) {
            new ViewBookHotel(username);
        } else if (ae.getSource() == Payment) {
            new Payment();
        } else if (ae.getSource() == Calculator) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == Notepad) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == About) {
            new About();
        } else if (ae.getSource() == logout) {
            setVisible(false);
            new Login();
        }else if(ae.getSource() == deletePersonalDeatils){
            new DeleteDetails(username);
        }
    }

    public static void main(String args[]) {
        new Dashboard("");
    }
}
