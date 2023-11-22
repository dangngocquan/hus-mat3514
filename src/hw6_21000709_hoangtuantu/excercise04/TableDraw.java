package hw6_21000709_hoangtuantu.excercise04;

import javax.swing.*;
import java.util.ArrayList;

public class TableDraw extends JFrame {
	public TableDraw(boolean insert) {
		ArrayList<ArrayList<Double>> times;
		if (insert){
			System.out.println("Getting data for insert time table");
			times = InsertTime.times();
		}else{
			System.out.println("Getting data for remove time table");
			times = removeMinTime.times();
		}

		System.out.println("Drawing!");
		// Tạo tiêu đề của các cột
		String[] columns = new String[6];
		for (int i = 0; i < 6; i++){
			columns[i] = 10 + "^" + (3 + i);
		}

		Object[][] data = times.stream()
				.map(ArrayList :: toArray)
				.toArray(Object[][]::new);

		// Tạo JTable với dữ liệu và tiêu đề
		JTable table = new JTable(data, columns);

		// Đặt JTable vào JScrollPane để có thanh cuộn nếu cần
		JScrollPane scrollPane = new JScrollPane(table);

		// Thêm JScrollPane vào JFrame
		add(scrollPane);

		// Cài đặt thuộc tính của JFrame
		setTitle("Table Example with ArrayList");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
