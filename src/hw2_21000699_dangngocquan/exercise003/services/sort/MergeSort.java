package hw2_21000699_dangngocquan.exercise003.services.sort;

import hw2_21000699_dangngocquan.exercise003.components.ViewCard;
import hw2_21000699_dangngocquan.exercise003.components.ViewCards;
import hw2_21000699_dangngocquan.exercise003.services.animation.Location;

import java.util.*;

public class MergeSort {
    public static <T extends Comparable<T>> void sort(T[] a) {
        mergeSort(a, 0, a.length-1);
    }

    // Sort a[left, right]
    private static <T extends Comparable<T>> void mergeSort(T[] a, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            merge(a, left, mid, right);
        }
    }

    // merge two sorted sub-array a[left, mid] and a[mid+1, right]
    private static <T extends Comparable<T>> void merge(T[] a, int left, int mid, int right) {
        int bLength = right - left + 1;
        T[] b = Arrays.copyOf(a, bLength);
        int i = 0;
        int i1 = left;
        int i2 = mid+1;
        while (i1 <= mid && i2 <= right) {
            if (a[i1].compareTo(a[i2]) <= 0) {
                b[i] = a[i1];
                i1++;
            } else {
                b[i] = a[i2];
                i2++;
            }
            i++;
        }
        while (i1 <= mid) b[i++] = a[i1++];
        while (i2 <= right) b[i++] = a[i2++];
        i = 0;
        while (i < bLength) a[i+left] = b[i++];
    }

    public static void sortWithAnimation(Timer timer, ViewCards viewCards, int period) {
        timer.schedule(new
                Task(timer, viewCards, period), 0, period);
    }

    private static class Task extends TimerTask {
        private Timer timer;
        private ViewCards viewCards;
        private int period;
        private Queue<Integer[]>[] queues;
        private int length;
        private int indexQueue;
        private ViewCard[] array;
        private Integer[] pairLR1, pairLR2;
        private int n, i, i1, i2;

        public Task(Timer timer, ViewCards viewCards, int period) {
            this.timer = timer;
            this.viewCards = viewCards;
            this.period = period;
            Queue<Integer[]> tempQueue = new LinkedList<>();
            tempQueue.add(new Integer[] {0, viewCards.getViewCards().length-1});
            Queue<Integer[]> nextQueue = new LinkedList<>();
            Queue<Integer[]> lastQueue;
            do {
                length++;
                lastQueue = new LinkedList<>(tempQueue);
                nextQueue.clear();
                while (!tempQueue.isEmpty()) {
                    Integer[] pairLR = tempQueue.poll();
                    int l = pairLR[0];
                    int r = pairLR[1];
                    int m = (l + r) / 2;
                    int size = r - l + 1;
                    if (size == 1 && nextQueue.size() > 0) {
                        nextQueue.add(new Integer[] {l, l});
                        nextQueue.add(new Integer[] {r, r});
                    } else if (size >= 2){
                        nextQueue.add(new Integer[] {l, m});
                        nextQueue.add(new Integer[] {m+1, r});
                    }
                }
                tempQueue = new LinkedList<>(nextQueue);
            } while (tempQueue.size() > 0);

            queues = new Queue[length];
            for (int i = 0; i < queues.length; i++) queues[i] = new LinkedList<>();
            queues[length-1] = lastQueue;
            indexQueue = queues.length-1;
        }

        @Override
        public void run() {

            if (array == null) {
                while (indexQueue < queues.length && queues[indexQueue].size() < 2) {
                    indexQueue++;
                }
                if (indexQueue >= queues.length) {
                    timer.cancel();
                    timer.purge();
                } else {
                    pairLR1 = queues[indexQueue].poll();
                    pairLR2 = queues[indexQueue].poll();
                    n = pairLR2[1] - pairLR1[0] + 1;
                    array = new ViewCard[n];
                    i = pairLR1[0];
                    i1 = pairLR1[0];
                    i2 = pairLR2[0];
                    viewCards.pickUp1All(viewCards.y0Card, pairLR1[0], pairLR2[1], 10, period - 10);
                }
            } else {
                if (i <= pairLR2[1]) {
                    if (i1 <= pairLR1[1] && i2 <= pairLR2[1]) {
                        if (viewCards.getViewCards()[i1].compareTo(viewCards.getViewCards()[i2]) <= 0) {
                            Location l1 = new Location(viewCards.xCards[i], viewCards.y6Card);
                            Location l2 = new Location(viewCards.xCards[i1], viewCards.y1Card);
                            viewCards.move(i1, l2, i, l1, 10, period - 10);
                            array[i-pairLR1[0]] = viewCards.getViewCards()[i1];
                            i1++;
                        } else {
                            Location l1 = new Location(viewCards.xCards[i], viewCards.y6Card);
                            Location l2 = new Location(viewCards.xCards[i2], viewCards.y1Card);
                            viewCards.move(i2, l2, i, l1, 10, period - 10);
                            array[i-pairLR1[0]] = viewCards.getViewCards()[i2];
                            i2++;
                        }
                    } else if (i1 <= pairLR1[1]) {
                        Location l1 = new Location(viewCards.xCards[i], viewCards.y6Card);
                        Location l2 = new Location(viewCards.xCards[i1], viewCards.y1Card);
                        viewCards.move(i1, l2, i, l1, 10, period - 10);
                        array[i-pairLR1[0]] = viewCards.getViewCards()[i1];
                        i1++;
                    } else if (i2 <= pairLR2[1]) {
                        Location l1 = new Location(viewCards.xCards[i], viewCards.y6Card);
                        Location l2 = new Location(viewCards.xCards[i2], viewCards.y1Card);
                        viewCards.move(i2, l2, i, l1, 10, period - 10);
                        array[i-pairLR1[0]] = viewCards.getViewCards()[i2];
                        i2++;
                    }
                    i++;
                } else {
                    for (int j = 0; j < n; j++) viewCards.getViewCards()[j+pairLR1[0]] = array[j];
                    viewCards.updateZOrder();
                    viewCards.pickDown6All(viewCards.y6Card, pairLR1[0], pairLR2[1], 10, period - 10);

                    array = null;
                    indexQueue--;
                    if (indexQueue >= 0) {
                        queues[indexQueue].add(new Integer[] {pairLR1[0], pairLR2[1]});
                    } else {
                        timer.cancel();
                        timer.purge();
                    }
                }
            }

        }
    }
}
