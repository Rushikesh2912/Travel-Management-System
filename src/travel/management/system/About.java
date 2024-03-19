package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {

    About() {
        setBounds(600, 200, 500, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel l1 = new JLabel("ABOUT");
        l1.setBounds(200, 20, 100, 40);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(l1);

        String s = "\t\t\t\tAbout Projects\n"
                + "  \n\n"
                + "Creating a travel and tourism management system using Java Swing involves building a graphical user interface (GUI) application that users can interact with to search for destinations, book travel services, and manage their travel plans. Below is an outline of the different parts you can include in your project:"
                + "  \n\n"
                + " 1. User Authentication and Registration: "
                + "\n" + "Create screens for users to register and log in. Store user information in a database and validate credentials during login." + "\n\n"
                + " 2. Main Dashboard: "
                + "\n" + "Design a dashboard where users can navigate to different sections of the application, such as searching for destinations, managing bookings, and viewing their profile." + "\n\n"
                + " 3. Destination Search: "
                + "\n" + "Implement a search interface where users can enter their preferred destination, travel dates, and other filters. Display search results with images and brief descriptions of destinations." + "\n\n"
                + " 4. Accommodation and Transportation Booking: "
                + "\n" + "Allow users to select accommodations (hotels, resorts, etc.) and transportation options (flights, trains, etc.). Provide booking forms with necessary details like dates, preferences, and passenger information."
                + " 5. Itinerary Planning: "
                + "\n" + "Create a feature that lets users plan their itineraries by adding destinations, accommodations, and activities to a timeline. Enable users to save and edit their itineraries." + "\n\n"
                + " 6. Booking Confirmation and Payment: "
                + "\n" + "Display a summary of the user's selected services and allow them to proceed with the booking. Integrate a payment gateway for secure transactions." + "\n\n"
                + " 7. User Profile Management: "
                + "\n" + "Enable users to view and edit their profiles, including personal information, contact details, and password." + "\n\n"
                + " 8. Booking History and Tracking: "
                + "\n" + "Implement a section where users can view their past bookings and check the status of ongoing bookings." + "\n\n"
                + " 9. Reviews and Ratings: "
                + "\n" + "Allow users to leave reviews and ratings for destinations, accommodations, and services they have used." + "\n\n"
                + " 10. Admin Panel: "
                + "\n" + "Create an admin interface for managing destinations, accommodations, activities, and user accounts. Admins should be able to add, update, or delete entries." + "\n\n"
                + " 12. Error Handling and Validation: "
                + "\n" + "Implement proper input validation and error handling to provide a smooth user experience." + "\n\n"
                + "\n\n\t\t\t        Thank You...!" + "\n"
                + "\n\n You're welcome! If you have any specific parts or aspects of the project that you'd like to discuss or need further assistance with, please feel free to ask. Whether it's about coding, design, implementation, or any other related topic, I'm here to help!"
                + "\n\n\t\t\tContact us == 9623548002";
        TextArea area = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20, 100, 450, 300);
        add(area);

        JButton back = new JButton("Back");
        back.setBounds(200, 420, 100, 25);
        add(back);
        back.addActionListener(this);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String args[]) {
        new About();
    }
}
