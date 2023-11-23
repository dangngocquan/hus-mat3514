package hw6_21000673_nguyenvandai.exercise5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.PriorityQueue;

public class FlightEventSystem {
    private PriorityQueue<FlightEvent> eventQueue;
    private DateTimeFormatter dateTimeFormatter;

    private JFrame frame;
    private JTextField timestampField;
    private JTextField eventNameField;
    private JTextArea eventLogArea;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FlightEventSystem eventSystem = new FlightEventSystem();
            eventSystem.start();
        });
    }

    public void start() {
        eventQueue = new PriorityQueue<>();
        dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        frame = new JFrame("Flight Event Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel inputPanel = createInputPanel();
        JPanel logPanel = createLogPanel();

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        frame.getContentPane().add(logPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel timestampLabel = new JLabel("Timestamp (yyyy-MM-dd HH:mm): ");
        timestampField = new JTextField(16);
        JLabel eventNameLabel = new JLabel("Event Name: ");
        eventNameField = new JTextField(16);
        JButton addButton = new JButton("Add Event");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFlightEvent();
            }
        });

        panel.add(timestampLabel);
        panel.add(timestampField);
        panel.add(eventNameLabel);
        panel.add(eventNameField);
        panel.add(addButton);

        return panel;
    }

    private void addFlightEvent() {
        String timestampText = timestampField.getText();
        String eventName = eventNameField.getText();

        LocalDateTime timestamp;
        try {
            timestamp = LocalDateTime.parse(timestampText, dateTimeFormatter);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Invalid timestamp format!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        FlightEvent event = new FlightEvent(timestamp, eventName);
        eventQueue.add(event);

        timestampField.setText("");
        eventNameField.setText("");

        updateEventLog();
    }

    private JPanel createLogPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel logLabel = new JLabel("Event Log:");
        eventLogArea = new JTextArea();
        eventLogArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(eventLogArea);

        panel.add(logLabel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private void updateEventLog() {
        StringBuilder logBuilder = new StringBuilder();
        for (FlightEvent event : eventQueue) {
            String timestamp = event.getTimestamp().format(dateTimeFormatter);
            String eventName = event.getEventName();
            logBuilder.append(timestamp).append(" - ").append(eventName).append("\n");
        }
        eventLogArea.setText(logBuilder.toString());
    }
}
