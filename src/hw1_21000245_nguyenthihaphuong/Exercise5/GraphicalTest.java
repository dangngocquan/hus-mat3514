package hw1_21000245_nguyenthihaphuong.Exercise5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalTest {
    private final CreditCard creditCard;

    public GraphicalTest() {
        // Create a CreditCard instance
        creditCard = new CreditCard("John Bowman", "California Savings", "5391 0375 9387 5309", 5000);

        // Create a JFrame for the GUI
        JFrame frame = new JFrame("Credit Card Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        frame.setLayout(new GridLayout(3, 2));

        // Set the background color of the frame's content pane to pink
        Color backgroundColor = new Color(166, 141, 173);
        Container contentPane = frame.getContentPane();
        contentPane.setBackground(backgroundColor);

        // Set the color for the label
        Color labelColor = new Color(242, 190, 209);

        // Text field and label for credit limit input
        JLabel limitLabel = new JLabel("Credit Limit:");
        frame.add(limitLabel);
        limitLabel.setForeground(labelColor);
        JTextField limitField = new JTextField();
        limitField.setToolTipText("Enter new credit limit");
        frame.add(limitField);

        // Button to update credit limit
        JButton limitButton = new JButton("Update Limit");
        frame.add(limitButton);

        // Text field and label for payment input
        JLabel paymentLabel = new JLabel("Payment Amount:");
        frame.add(paymentLabel);
        paymentLabel.setForeground(labelColor);
        JTextField paymentField = new JTextField();
        paymentField.setToolTipText("Enter payment amount");
        frame.add(paymentField);

        // Button to make a payment
        JButton paymentButton = new JButton("Make Payment");
        frame.add(paymentButton);

        // Create GridBagConstraints to specify component placement
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 20, 5, 20); // Add some padding

        // Add components with GridBagConstraints
        gbc.gridx = 0; // Column 0
        gbc.gridy = 0; // Row 0
        frame.add(limitLabel, gbc);

        gbc.gridx = 1; // Column 1
        gbc.gridy = 0; // Row 0
        frame.add(limitField, gbc);

        gbc.gridx = 2; // Column 2
        gbc.gridy = 0; // Row 0
        frame.add(limitButton, gbc);

        gbc.gridx = 0; // Column 0
        gbc.gridy = 1; // Row 1
        frame.add(paymentLabel, gbc);

        gbc.gridx = 1; // Column 1
        gbc.gridy = 1; // Row 1
        frame.add(paymentField, gbc);

        gbc.gridx = 2; // Column 2
        gbc.gridy = 1; // Row 1
        frame.add(paymentButton, gbc);

        // Display balance
        JLabel balanceLabel = new JLabel("Balance: " + creditCard.getBalance());
        frame.add(balanceLabel);

        // ActionListener for updating credit limit
        limitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String limitText = limitField.getText();
                try {
                    int newLimit = Integer.parseInt(limitText);
                    creditCard.updateCreditLimit(newLimit);
                    JOptionPane.showMessageDialog(frame, "Credit limit updated successfully.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid credit limit format.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // ActionListener for making a payment
        paymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String paymentText = paymentField.getText();
                try {
                    double paymentAmount = Double.parseDouble(paymentText);
                    creditCard.makePayment(paymentAmount);
                    balanceLabel.setText("Balance: " + creditCard.getBalance());
                    JOptionPane.showMessageDialog(frame, "Payment made successfully.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid payment amount format.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Show the GUI
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GraphicalTest();
            }
        });
    }
}

