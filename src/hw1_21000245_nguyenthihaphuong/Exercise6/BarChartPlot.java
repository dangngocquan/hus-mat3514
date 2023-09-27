package hw1_21000245_nguyenthihaphuong.Exercise6;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

/** P-2.30
 * Write a Java program that inputs a document and then outputs a bar-chart plot of
 * the frequencies of each alphabet character that appears within that document.
 */

public class BarChartPlot extends JFrame {
    private final DefaultCategoryDataset dataset;
    private final JFreeChart barChart;
    private final ChartPanel chartPanel;
    private final JButton generateButton;
    private final JButton loadButton;
    private final JTextArea textArea;

    public BarChartPlot(String title) {
        super(title);

        // Create an empty dataset initially
        dataset = createEmptyDataset();

        // Create a bar chart from the empty dataset
        barChart = createChart(dataset);

        // Create a panel to hold the chart
        chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(800, 600));

        // Create a text area for input document
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Create a "Generate Chart" button
        generateButton = new JButton("Generate Chart");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String document = textArea.getText();
                Map<Character, Integer> charFrequency = calculateCharacterFrequency(document);
                updateDataset(charFrequency);
            }
        });

        // Create a "Load Document" button
        loadButton = new JButton("Load Document");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
                fileChooser.setFileFilter(filter);

                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    String selectedFile = fileChooser.getSelectedFile().getAbsolutePath();
                    try {
                        String content = readFile(selectedFile);
                        textArea.setText(content);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error reading the selected file.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Add components to the JFrame
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loadButton);
        buttonPanel.add(generateButton);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.NORTH);
        add(chartPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private DefaultCategoryDataset createEmptyDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        return dataset;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Character Frequency Chart", // Chart title
                "Character", // X-axis label
                "Frequency", // Y-axis label
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Chart orientation
                true, // Show legend
                true, // Show tooltips
                false // Show URLs
        );

        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.black);

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinePaint(Color.black);
        plot.setRangeGridlinePaint(Color.black);

        // Use NumberAxis for the Y-axis to display integers
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        yAxis.setNumberFormatOverride(NumberFormat.getIntegerInstance());

        // Customize bar colors
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.pink); // Set color to pink

        return chart;
    }

    private Map<Character, Integer> calculateCharacterFrequency(String document) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        document = document.toLowerCase();
        for (int i = 0; i < document.length(); i++) {
            char c = document.charAt(i);
            if (Character.isLetter(c)) {
                charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
            }
        }
        return charFrequency;
    }

    private void updateDataset(Map<Character, Integer> charFrequency) {
        dataset.clear();
        for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
            dataset.addValue(entry.getValue(), "Frequency", entry.getKey().toString());
        }
    }

    private String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        reader.close();
        return content.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BarChartPlot example = new BarChartPlot("Character Frequency Chart");
                example.pack();
                example.setLocationRelativeTo(null);
                example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                example.setVisible(true);
            }
        });
    }
}
