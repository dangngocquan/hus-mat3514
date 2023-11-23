package hw6_21000673_nguyenvandai.exercise3;

import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;

import java.awt.Color;

public class MainSortAlgorithmComparison {
    //Bạn phải cài jfree.chart thì khi chạy mới hiện biểu đồ nhé , cài xong rồi set path
    // mình đã chạy vào ảnh bieudo.png
    public static void main(String[] args) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();// lưu trữ data vào các cột biểu đồ



        int[] arraySizes = {100, 1000, 5000, 10000};
        for (int size : arraySizes) {
            int[] arr = generateRandomArray(size);
            long bubbleSortTime = measureExecutionTime(() -> Sort.BubbleSort(arr.clone()));
            long insertionSortTime = measureExecutionTime(() -> Sort.InsertionSort(arr.clone()));
            long selectionSortTime = measureExecutionTime(() -> Sort.SelectionSort(arr.clone()));
            long mergeSort = measureExecutionTime(() -> Sort.mergeSort(arr.clone(), 0, arr.length - 1));
            long quickSort = measureExecutionTime(() -> Sort.QuickSort(arr.clone()));
            dataset.addValue(insertionSortTime, "Insertion Sort", String.valueOf(size));
            dataset.addValue(selectionSortTime, "Selection Sort", String.valueOf(size));
            dataset.addValue(mergeSort, " merge Sort", String.valueOf(size));
            dataset.addValue(quickSort, "quick Sort", String.valueOf(size));
            dataset.addValue(bubbleSortTime, "bubbleSortTime", String.valueOf(size));
        }

        JFreeChart chart = ChartFactory.createLineChart(
                "Sorting Algorithm Comparison", // Chart title
                "Array Size", // X-axis label
                "Execution Time (ms)", // Y-axis label
                dataset, // Dataset
                PlotOrientation.VERTICAL,
                true, // Show legend
                true, // Use tooltips
                false // Generate URLs
        );
//        try {
//            ChartUtilities.saveChartAsJPEG(new File("chart.jpg"), chart, 800, 600);
//            System.out.println("Chart saved as chart.jpg");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        chart.getCategoryPlot().getRenderer().setSeriesPaint(0, Color.RED);
        chart.getCategoryPlot().getRenderer().setSeriesPaint(1, Color.GREEN);
        chart.getCategoryPlot().getRenderer().setSeriesPaint(2, Color.BLUE);
        chart.getCategoryPlot().getRenderer().setSeriesPaint(3, Color.BLACK);
        chart.getCategoryPlot().getRenderer().setSeriesPaint(4, Color.CYAN);
        ChartFrame frame = new ChartFrame("Sorting Algorithm Comparison", chart);// tạo cửa sổ hiện thị biểu đồ
        frame.pack();// tự động điều chỉnh kích thuoc biểu đồ cho phù hợp nội dung trong biểu đồ
        frame.setVisible(true);// show

    }

    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }

    private static long measureExecutionTime(Runnable runnable) {
        long startTime = System.currentTimeMillis();
        runnable.run();
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}