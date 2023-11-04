package hw6_21000699_dangngocquan.exercise004;

import hw6_21000699_dangngocquan.base.*;

import java.util.Random;

public class Task {
    public void solve() {
        long[][] statisticInsert = statisticInsert();
        long[][] statisticRemoveMin = statisticRemoveMin();
        writeResultToFile(statisticInsert);
        writeResultToFile(statisticRemoveMin);
    }

    public long[][] statisticInsert() {
        int[] queueSizes = new int[] {1000, 10000, 100000, 1000000, 10000000, 100000000};
        long[][] statistics = new long[4][queueSizes.length];
        int i = 0;
        Random random = new Random();
        QueueGenerator queueGenerator = new QueueGenerator();
        while (i < queueSizes.length) {
            int x = random.nextInt(1000);
            PriorityQueueInterface<Integer, Integer> queue = null;

            for (int j = 0; j < 4; j++) {
                try {
                    switch (j) {
                        case 0 -> {
                            System.out.print("n = " + queueSizes[i]
                                    + ", Unsorted array priority executing insert method ...");
                            queue = queueGenerator.generateRandomUnsortedArrayQueue(queueSizes[i]);
                        }
                        case 1 -> {
                            System.out.print("n = " + queueSizes[i]
                                    + ", Sorted array priority executing insert method ...");
                            queue = queueGenerator.generateRandomSortedArrayQueue(queueSizes[i]);
                        }
                        case 2 -> {
                            System.out.print("n = " + queueSizes[i]
                                    + ", Unsorted linked priority executing insert method ...");
                            queue = queueGenerator.generateRandomUnsortedLinkedQueue(queueSizes[i]);
                        }
                        case 3 -> {
                            System.out.print("n = " + queueSizes[i]
                                    + ", Sorted linked priority executing insert method ...");
                            queue = queueGenerator.generateRandomSortedLinkedQueue(queueSizes[i]);
                        }
                        default -> {}
                    }
                    statistics[j][i] = new TimeExecute<Integer, Integer>().timeExecuteInsert(queue, x, x);
                } catch (OutOfMemoryError e) {
                    statistics[j][i] = -1;
                } finally {
                    System.out.println(statistics[j][i] == -1? ", Out of memory." : ", run time: " + statistics[j][i] + "ms.");
                }
            }
            i++;
        }
        System.out.println("End statistic insert method.");
        return statistics;
    }

    public long[][] statisticRemoveMin() {
        int[] queueSizes = new int[] {1000, 10000, 100000, 1000000, 10000000, 100000000};
        long[][] statistics = new long[4][queueSizes.length];
        int i = 0;
        QueueGenerator queueGenerator = new QueueGenerator();
        while (i < queueSizes.length) {
            PriorityQueueInterface<Integer, Integer> queue = null;
            for (int j = 0; j < 4; j++) {
                try {
                    switch (j) {
                        case 0 -> {
                            System.out.print("n = " + queueSizes[i]
                                    + ", Unsorted array priority executing removeMin method ...");
                            queue = queueGenerator.generateRandomUnsortedArrayQueue(queueSizes[i]);
                        }
                        case 1 -> {
                            System.out.print("n = " + queueSizes[i]
                                    + ", Sorted array priority executing removeMin method ...");
                            queue = queueGenerator.generateRandomSortedArrayQueue(queueSizes[i]);
                        }
                        case 2 -> {
                            System.out.print("n = " + queueSizes[i]
                                    + ", Unsorted linked priority executing removeMin method ...");
                            queue = queueGenerator.generateRandomUnsortedLinkedQueue(queueSizes[i]);
                        }
                        case 3 -> {
                            System.out.print("n = " + queueSizes[i]
                                    + ", Sorted linked priority executing removeMin method ...");
                            queue = queueGenerator.generateRandomSortedLinkedQueue(queueSizes[i]);
                        }
                        default -> {}
                    }
                    statistics[j][i] = new TimeExecute<Integer, Integer>().timeExecuteRemoveMin(queue);
                } catch (OutOfMemoryError e) {
                    statistics[j][i] = -1;
                } finally {
                    System.out.println(statistics[j][i] == -1? ", Out of memory." : ", run time: " + statistics[j][i] + "ms.");
                }
            }
            i++;
        }
        System.out.println("End statistic removeMin method.");
        return statistics;
    }

    public void writeResultToFile(long[][] statistic) {
        StringBuilder sb = new StringBuilder();
        for (long[] times : statistic) {
            for (int i = 0; i < times.length; i++) {
                sb.append(times[i]);
                sb.append(i < times.length - 1? "," : "\n");
            }
        }
        new MyWriter().writeToFile(sb.toString());
    }
}
