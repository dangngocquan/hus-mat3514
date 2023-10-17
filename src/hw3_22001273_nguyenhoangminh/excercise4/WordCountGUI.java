package hw3_22001273_nguyenhoangminh.excercise4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCountGUI implements ActionListener {
    JFrame f;
    JPanel textPanel, statPanel;
    JLabel textLabel;
    JTable statDisplay;
    JScrollPane scrollPane;
    JTextArea textInput;
    JButton start;

    public WordCountGUI() {
        f = new JFrame("Word Count GUI");
        f.setSize(1378, 768);
        f.setLayout(new GridLayout(1, 2));
            textPanel = new JPanel();
            textPanel.setLayout(null);
            f.add(textPanel);
                textLabel = new JLabel("Please input text:");
                textLabel.setBounds(50, 30, 100, 30);
                textPanel.add(textLabel);

                textInput = new JTextArea();
                textInput.setBounds(50, 60, 600, 400);
                textPanel.add(textInput);

                start = new JButton("Start");
                start.setBounds(50, 500, 80, 30);
                start.addActionListener(this);
                textPanel.add(start);

            statPanel = new JPanel();
            statPanel.setLayout(null);
            f.add(statPanel);

        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            statPanel.removeAll();

            String inText = textInput.getText();
            WordLinkedList wordList = new WordLinkedList(inText);
            String[][] table = wordList.toTable();
            String[] attribute = {"Word", "Frequency"};

            statDisplay = new JTable(table, attribute) {
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return false;
                }
            };

            scrollPane = new JScrollPane(statDisplay);
            scrollPane.setBounds(150,50, 400, 600);
            statPanel.add(scrollPane);
            statPanel.validate();
            statPanel.repaint();
        }
    }

    public static void main(String[] args) {
        new WordCountGUI();
    }
}
