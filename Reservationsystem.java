package tasks;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reservationsystem extends JFrame implements ActionListener {
    
    private JTextField usernameField, passwordField, trainNumberField, fromField, toField, pnrField;
    private JComboBox<String> classTypeComboBox;
    private JButton loginButton, reserveButton, cancelButton;

    public Reservationsystem () {
        
        setTitle("Online Reservation System");
        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 30, 80, 25);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 30, 200, 25);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 70, 80, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 200, 25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(150, 110, 80, 25);
        loginButton.addActionListener(this);
        add(loginButton);

        
        reserveButton = new JButton("Reserve");
        reserveButton.setBounds(100, 300, 80, 25);
        reserveButton.addActionListener(this);
        reserveButton.setVisible(false);
        add(reserveButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(200, 300, 80, 25);
        cancelButton.addActionListener(this);
        cancelButton.setVisible(false);
        add(cancelButton);

       
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reservationsystem();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
           
            String username = usernameField.getText();
            String password = passwordField.getText();

            
            if (authenticate(username, password)) {
                // Open reservation form
                openReservationForm();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
        } else if (e.getSource() == reserveButton) {
            // Placeholder for reservation process
            String trainNumber = trainNumberField.getText();
            String classType = (String) classTypeComboBox.getSelectedItem();
            String from = fromField.getText();
            String to = toField.getText();

            if (validateReservationForm(trainNumber, classType, from, to)) {
                // Perform reservation
                reserveTicket(trainNumber, classType, from, to);
            } else {
                JOptionPane.showMessageDialog(this, "Please fill all fields in the reservation form");
            }
        } else if (e.getSource() == cancelButton) {
            // Placeholder for cancellation process
            String pnr = pnrField.getText();
            cancelTicket(pnr);
        }
    }

    private void cancelTicket(String pnr) {
        
        JOptionPane.showMessageDialog(this, "Ticket Canceled for PNR: " + pnr);
        
    }

    private void reserveTicket(String trainNumber, String classType, String from, String to) {
       
        JOptionPane.showMessageDialog(this, "Ticket Reserved");
        
    }

    private boolean validateReservationForm(String trainNumber, String classType, String from, String to) {
       
        
        return !trainNumber.isEmpty() && !classType.isEmpty() && !from.isEmpty() && !to.isEmpty();
    }

    private void openReservationForm() {
        
        JLabel trainNumberLabel = new JLabel("Train Number:");
        trainNumberLabel.setBounds(50, 150, 100, 25);
        add(trainNumberLabel);

        trainNumberField = new JTextField();
        trainNumberField.setBounds(150, 150, 200, 25);
        add(trainNumberField);

        JLabel classTypeLabel = new JLabel("Class Type:");
        classTypeLabel.setBounds(50, 190, 100, 25);
        add(classTypeLabel);

        classTypeComboBox = new JComboBox<>(new String[]{"First Class", "Second Class"});
        classTypeComboBox.setBounds(150, 190, 200, 25);
        add(classTypeComboBox);

        JLabel fromLabel = new JLabel("From:");
        fromLabel.setBounds(50, 230, 100, 25);
        add(fromLabel);

        fromField = new JTextField();
        fromField.setBounds(150, 230, 200, 25);
        add(fromField);

        JLabel toLabel = new JLabel("To:");
        toLabel.setBounds(50, 270, 100, 25);
        add(toLabel);

        toField = new JTextField();
        toField.setBounds(150, 270, 200, 25);
        add(toField);

        reserveButton.setVisible(true);

        
        usernameField.setVisible(false);
        passwordField.setVisible(false);
        loginButton.setVisible(false);

        
        JLabel pnrLabel = new JLabel("PNR:");
        pnrLabel.setBounds(50, 150, 100, 25);
        add(pnrLabel);

        pnrField = new JTextField();
        pnrField.setBounds(150, 150, 200, 25);
        add(pnrField);
        cancelButton.setVisible(true);
    }

    private boolean authenticate(String username, String password) {
        
        return true;
    }
}
