package hw6_21000709_hoangtuantu.excercise04;

import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new TableDraw(true).setVisible(true);
		});

		SwingUtilities.invokeLater(() -> {
			new TableDraw(false).setVisible(true);
		});
	}
}
