package hw6_21000699_dangngocquan.exercise003;

import hw6_21000699_dangngocquan.exercise003.generator.Generator;

public class Task {
    public void solve() {
        int[] arraySizes = new int[] {10, 100, 1000, 10000, 20000, 40000, 60000, 80000, 100000};
        long[][] statistic = statistic(arraySizes);
        writeResultToFile(statistic);
    }

    public long[][] statistic(int[] arraySizes) {
        long[][] statistics = new long[arraySizes.length][6];
        for (int i = 0; i < arraySizes.length; i++) {
            Integer[] values = Generator.randomArray(arraySizes[i], 0, 10041004);
            for (int iAlgorithm = 0; iAlgorithm < 6; iAlgorithm++) {
                switch (iAlgorithm) {
                    case 0 -> {
                        System.out.print("Running n = " + arraySizes[i] + ", Bubble Sort");
                        statistics[i][0] = TimeSort.msBubbleSort(values.clone());
                        System.out.println(", runtime: " + statistics[i][0] + "ms");
                    }
                    case 1 -> {
                        System.out.print("Running n = " + arraySizes[i] + ", Selection Sort");
                        statistics[i][1] = TimeSort.msSelectionSort(values.clone());
                        System.out.println(", runtime: " + statistics[i][1] + "ms");
                    }
                    case 2 -> {
                        System.out.print("Running n = " + arraySizes[i] + ", Insertion Sort");
                        statistics[i][2] = TimeSort.msInsertionSort(values.clone());
                        System.out.println(", runtime: " + statistics[i][2] + "ms");
                    }
                    case 3 -> {
                        System.out.print("Running n = " + arraySizes[i] + ", Quick Sort");
                        statistics[i][3] = TimeSort.msQuickSort(values.clone());
                        System.out.println(", runtime: " + statistics[i][3] + "ms");
                    }
                    case 4 -> {
                        System.out.print("Running n = " + arraySizes[i] + ", Merge Sort");
                        statistics[i][4] = TimeSort.msMergeSort(values.clone());
                        System.out.println(", runtime: " + statistics[i][4] + "ms");
                    }
                    case 5 -> {
                        System.out.print("Running n = " + arraySizes[i] + ", Heap Sort");
                        statistics[i][5] = TimeSort.msHeapSort(values.clone());
                        System.out.println(", runtime: " + statistics[i][5] + "ms");
                    }
                    default -> {}
                }
            }
        }
        return statistics;
    }

    public void writeResultToFile(long[][] statistic) {
        StringBuilder sb = new StringBuilder();
        for (long[] times : statistic) {
            for (int i = 0; i < times.length; i++) {
                sb.append(times[i]);
                if (i < times.length - 1) sb.append(",");
            }
            sb.append("\n");
        }
        MyFileWriter.writeToFile(sb.toString());
    }
}
