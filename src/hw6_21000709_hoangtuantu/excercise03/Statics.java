package hw6_21000709_hoangtuantu.excercise03;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Statics extends JFrame {

	private List<List<Double>> data;

	public Statics(String title, List<List<Double>> data) {
		super(title);
		this.data = data;

		// Set up the UI
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add the chart panel
		ChartPanel chartPanel = new ChartPanel();
		add(chartPanel);

		// Make the frame visible
		setVisible(true);
	}

	private class ChartPanel extends JPanel {
		private static final int AXIS_MARGIN = 50;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;

			int dataSize = data.size();
			int width = getWidth();
			int height = getHeight();

			// Draw the axes
			g2d.drawLine(AXIS_MARGIN, height - AXIS_MARGIN, width - AXIS_MARGIN, height - AXIS_MARGIN);
			g2d.drawLine(AXIS_MARGIN, height - AXIS_MARGIN, AXIS_MARGIN, AXIS_MARGIN);

			// Draw x-axis label
			g2d.drawString("Size", width / 2 - 20, height - 10);

			// Draw y-axis label
			g2d.rotate(-Math.PI / 2); // Rotate the text for y-axis label
			g2d.drawString("Run Time", -height / 2, AXIS_MARGIN - 30);
			g2d.rotate(Math.PI / 2); // Rotate it back
			String[] names = {"Bubble Sort", "Insertion Sort", "Selection Sort", "Shell Sort", "Quick Sort", "Merge Sort", "Heap Sort"};
			// Draw the data points for each series
			for (int i = 0; i < dataSize; i++) {
				List<Double> series = data.get(i);
				g2d.setColor(getRandomColor()); // Assign a random color for each series

				for (int j = 0; j < series.size(); j++) {
					int x = AXIS_MARGIN + j * (width - 2 * AXIS_MARGIN) / (series.size() - 1);
					int y = height - AXIS_MARGIN - (int) (series.get(j) * (height - 2 * AXIS_MARGIN) / getMaxValue());
					g2d.fillOval(x - 2, y - 2, 4, 4);

					// Connect points with lines
					if (j > 0) {
						int x1 = AXIS_MARGIN + (j - 1) * (width - 2 * AXIS_MARGIN) / (series.size() - 1);
						int y1 = height - AXIS_MARGIN - (int) (series.get(j - 1) * (height - 2 * AXIS_MARGIN) / getMaxValue());
						g2d.drawLine(x1, y1, x, y);
					}

					// Add labels for each series
					if (j == series.size() - 1) {
						g2d.setColor(Color.BLACK);
						g2d.drawString(names[i], x + 5, y - 5);
					}
				}
			}
		}

		private double getMaxValue() {
			double max = Double.MIN_VALUE;
			for (List<Double> series : data) {
				for (double value : series) {
					if (value > max) {
						max = value;
					}
				}
			}
			return max;
		}

		private Color getRandomColor() {
			int r = (int) (Math.random() * 256);
			int g = (int) (Math.random() * 256);
			int b = (int) (Math.random() * 256);
			return new Color(r, g, b);
		}
	}
}
